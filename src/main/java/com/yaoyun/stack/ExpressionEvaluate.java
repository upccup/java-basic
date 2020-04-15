package com.yaoyun.stack;

/**
 * @author yaoyun created on 4月 15, 2020
 * @version 1.0
 */
public class ExpressionEvaluate {

    public static Double evaluate(String expression) {
        Stack<String> ops = new StackList<>();
        Stack<Double> values = new StackList<>();

        String[] strings = expression.split("");
        for (String s : strings) {
            switch (s) {
                case "+":
                case "*":
                case "-":
                case "/":
                    ops.push(s);
                    break;
                case ")":
                    double x = values.pop();
                    double y = values.pop();
                    String operator = ops.pop();
                    values.push(execute(x, y, operator));
                    break;
                case " ":
                case "(":
                    break;
                default:
                    values.push(Double.parseDouble(s));
                    break;
            }
        }

        if (values.isEmpty()) {
            throw new NullPointerException();
        }

        double result = values.pop();

        if (!values.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return result;
    }

    private static Double execute(Double x, Double y, String operator) {
        switch (operator) {
            case "+":
                return y + x;
            case "-":
                return y - x;
            case "*":
                return y * x;
            case "/":
                return y / x;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
