package Calculator;

public class Calculator {

    public static double add(double number1, double number2) {
        return number1 + number2;
    }

    public static double subs(double number1, double number2) {
        return number1 - number2;
    }

    public static double div(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("U cannot div by 0");
        }
        return number1 / number2;
    }

    public static double multi(double number1, double number2) {
        return number1 * number2;
    }
}
