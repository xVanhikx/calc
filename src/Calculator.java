import static java.lang.Double.NaN;
import static java.lang.Math.*;

public class Calculator {
    public enum TwoNumMode {
        normal, add, subtract, multiply, divide, xPowerOfY, addPercent, subtractPercent, multiplyPercent,
        dividePercent
    }
    public enum OneNumMode {
        square, rootSquare, oneDivided, cos, sin, tan, log, ln, abs, rate
    }
    private Double num1, num2;
    private TwoNumMode mode = TwoNumMode.normal;

    private Double calculateTwoImpl() {
        switch (mode) {
            case normal -> {
                return num2;
            }
            case add -> {
                return num1 + num2;
            }
            case subtract -> {
                return num1 - num2;
            }
            case multiply -> {
                return num1 * num2;
            }
            case divide -> {
                return num1 / num2;
            }
            case xPowerOfY -> {
                return pow(num1, num2);
            }
            case addPercent -> {
                return num1 + (num1 * num2 / 100);
            }
            case subtractPercent -> {
                return num1 - (num1 * num2 / 100);
            }
            case multiplyPercent -> {
                return num1 * (num2 / 100);
            }
            case dividePercent -> {
                return num1 / (num2 / 100);
            }
            default -> throw new Error();
        }
    }

    public Double calculateTwo(TwoNumMode newMode, Double num1, Double num2) {
        if (num1 == null || num2 == null) {
            return num1 != null ? num1 : (num2 != null ? num2 : 0.0);
        }

        switch (newMode) {
            case add:
                return num1 + num2;
            case subtract:
                return num1 - num2;
            case multiply:
                return num1 * num2;
            case divide:
                if (num2 == 0) {
                    return NaN;
                }
                return num1 / num2;
            case xPowerOfY:
                return Math.pow(num1, num2);
            default:
                return NaN;
        }
    }

    public Double calculateEqual(Double num) {
        return num;
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = TwoNumMode.normal;
        return NaN;
    }

    public Double calculateOne(OneNumMode newMode, Double num) {
        switch (newMode) {
            case square -> {
                return num * num;
            }
            case rootSquare -> {
                return sqrt(num);
            }
            case oneDivided -> {
                return 1 / num;
            }
            case cos -> {
                return cos(toRadians(num));
            }
            case sin -> {
                return sin(toRadians(num));
            }
            case tan -> {
                if (num == 0 || num % 180 == 0) {
                    return 0.0;
                }
                if (num % 90 == 0.0 && num % 180 != 0.0) {
                    return NaN;
                }
                return tan(toRadians(num));
            }
            case log -> {
                return log10(num);
            }
            case ln -> {
                return log(num);
            }
            case rate -> {
                return num / 100;
            }
            case abs -> {
                return abs(num);
            }
            default -> throw new Error();
        }
    }
}
