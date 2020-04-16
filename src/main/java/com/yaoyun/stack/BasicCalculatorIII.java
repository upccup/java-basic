package com.yaoyun.stack;

/**
 * @author yaoyun created on 4月 16, 2020
 * @version 1.0
 * @leetcode https://leetcode.com/problems/basic-calculator-iii/ (https://github.com/grandyang/leetcode/issues/772) Implement a basic calculator to evaluate a
 * simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces ``.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces ``. The integer division
 * should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647]. Some examples: "1 + 1"
 * = 2 " 6-4 / 2 " = 4 "2*(5+5*2)/3+(6/2+8)" = 21 "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 *
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorIII {

    public static int calculator(String expression) {
        char sign = '+';
        int value = 0;
        Stack<Integer> valueStack = new StackList<>();
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isDigit(c)) {
                value = value * 10 + c - '0';
            } else if (c == '(') {
                int j = i;
                int bracketCount = 0;
                for (; i < chars.length; i++) {
                    char subChar = chars[i];
                    if (subChar == '(') {
                        bracketCount++;
                    }

                    if (subChar == ')') {
                        bracketCount--;
                        if (bracketCount == 0) {
                            value = calculator(expression.substring(j+1, i));
                            break;
                        }
                    }
                }
            }

            if ((!Character.isDigit(c) && c != ' ') || i == chars.length - 1) {
                if (sign == '+') {
                    valueStack.push(value);
                } else if (sign == '-') {
                    valueStack.push(-value);
                } else if (sign == '*') {
                    valueStack.push(valueStack.pop() * value);
                } else if (sign == '/') {
                    valueStack.push(valueStack.pop() / value);
                }

                sign = c;
                value = 0;
            }
        }

        int result = 0;
        for (; !valueStack.isEmpty(); ) {
            result += valueStack.pop();
        }
        return result;
    }
}
