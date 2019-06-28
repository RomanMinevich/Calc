public class Calculator {
    static String expression, operator;
    static String[] arguments;
    static Object result;

    static void getExpression(String[] args) {
        StringBuffer enteredData = new StringBuffer();

        for (String arg : args) {
            enteredData.append(arg);
        }

        expression = enteredData.toString();
        expression = expression.replace("Calculator.classCalculator.javaRomanNumerals.classRomanNumerals.java", "*");
    }

    static void getOperator() {
        for (String operator : new String[]{"+", "-", "*", "/"}) {

            if (expression.contains(operator)) {
                Calculator.operator = operator;
            }
        }
    }

    static void splitExpression() {
        arguments = expression.split(String.format("\\%s", operator), 2);
    }

    static void calculate(int argument1, int argument2) {
        switch (operator) {
            case "+":
                result = argument1 + argument2;
                break;
            case "-":
                result = argument1 - argument2;
                break;
            case "*":
                result = argument1 * argument2;
                break;
            case "/":
                result = argument1 / argument2;
        }
    }

    static void showResult() {
        System.out.println(arguments[0] + " " + operator + " " + arguments[1] + " = " + result);
    }

    static void showErrorMessage() {
        System.out.println("Incorrect data entered");

    }

    public static void main(String[] args) {
        getExpression(args);
        getOperator();
        splitExpression();

        if (RomanNumerals.checkArgument(arguments[0]) && RomanNumerals.checkArgument(arguments[1])) {
            calculate(RomanNumerals.argumentsToArabic(arguments[0]), RomanNumerals.argumentsToArabic(arguments[1]));
            RomanNumerals.resultToRoman();
            showResult();
        } else {
            try {
                int number1 = Integer.parseInt(arguments[0]);
                int number2 = Integer.parseInt(arguments[1]);

                if (number1 < 0 || number1 > 10 || number2 < 0 || number2 > 10) {
                    showErrorMessage();
                } else {
                    calculate(number1, number2);
                    showResult();
                }

            } catch (NumberFormatException e) {
                showErrorMessage();
            } catch (ArithmeticException e) {
                System.out.println("Can't divide by zero");
            }
        }
    }
}
