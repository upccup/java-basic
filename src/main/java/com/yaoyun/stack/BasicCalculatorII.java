package com.yaoyun.stack;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author yaoyun created on 4月 15, 2020
 * @version 1.0
 * @leetcode https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {

    public static int calculator(String expression) {
        Stack<String> strStack = splitExpression(expression);
        Stack<String> midStack = multiplicationAndDivision(reversalStack(strStack));

        // 因为相同优先级的运算符需要遵循从左往右运算的顺序,所以计算前需要翻转一下栈,确保最先取出来的是原始数据的头部
        Stack<String> reversalStack = reversalStack(midStack);

        for (; ; ) {
            int x = Integer.parseInt(reversalStack.pop());
            if (reversalStack.isEmpty()) {
                return x;
            }

            String operator = reversalStack.pop();
            int y = Integer.parseInt(reversalStack.pop());
            if (reversalStack.isEmpty()) {
                return execute(x, y, operator);
            } else {
                reversalStack.push(Integer.toString(execute(x, y, operator)));
            }
        }
    }

    /**
     * 先乘除
     *
     * @param strStack 与原始字符串顺序相同的栈(相同优先级的运算符要从左到右运行)
     * @return 乘除计算完后的栈
     */
    private static Stack<String> multiplicationAndDivision(Stack<String> strStack) {
        Stack<String> midStack = new StackList<>();

        for (; !strStack.isEmpty(); ) {
            String str = strStack.pop();
            switch (str) {
                case "*":
                case "/":
                    int y = Integer.parseInt(strStack.pop());
                    int x = Integer.parseInt(midStack.pop());
                    midStack.push(Integer.toString(execute(x, y, str)));
                    break;
                default:
                    midStack.push(str);
                    break;
            }
        }

        return midStack;
    }

    /**
     * 先把连续的数字解析出来
     *
     * @param expression 需要计算的表达式
     * @return 处理完的栈
     */
    private static Stack<String> splitExpression(String expression) {
        Stack<String> strStack = new StackList<>();

        expression = expression.replaceAll(" ", "");

        String[] strings = expression.split("");
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            switch (s) {
                case "":
                case " ":
                    break;
                case "*":
                case "/":
                case "+":
                case "-":
                    strStack.push(s);
                    break;
                default:
                    int currentValue = Integer.parseInt(s);
                    for (int j = i + 1; j < strings.length; j++) {
                        String nextStr = strings[j];
                        if ('0' <= nextStr.charAt(0) && nextStr.charAt(0) <= '9') {
                            currentValue = 10 * currentValue + Integer.parseInt(nextStr);
                            i++;
                        } else {
                            break;
                        }
                    }
                    strStack.push(Integer.toString(currentValue));
                    break;
            }
        }

        return strStack;
    }

    /**
     * 翻转一个栈
     *
     * @param strStack 待处理的栈
     * @return 处理完成的栈
     */
    private static Stack<String> reversalStack(Stack<String> strStack) {
        Stack<String> reversalStack = new StackList<>();
        for (; !strStack.isEmpty(); ) {
            reversalStack.push(strStack.pop());
        }

        return reversalStack;
    }

    private static int execute(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                throw new UnsupportedOperationException();
        }
    }


    /**
     * 优化版
     *
     * @param expression 待计算表达式
     * @return 计算结果
     */
    public static int calculator2(String expression) {
        char sign = '+';
        int val = 0;
        Stack<Integer> valueStack = new StackList<>();

        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                val = val * 10 + c - '0';
            }

            if ((!Character.isDigit(c) && c != ' ') || i == chars.length - 1) {
                switch (sign) {
                    case '+':
                        valueStack.push(val);
                        break;
                    case '-':
                        valueStack.push(-val);
                        break;
                    case '*':
                        valueStack.push(valueStack.pop() * val);
                        break;
                    case '/':
                        valueStack.push(valueStack.pop() / val);
                        break;
                    default:
                        break;
                }
                sign = c;
                val = 0;
            }
        }

        int result = 0;
        for (; !valueStack.isEmpty(); ) {
            result += valueStack.pop();
        }

        return result;
    }
}
