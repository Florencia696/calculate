import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    enum Operator {
        ADDITION("+"),
        SUBTRACTION("-"),
        MULTIPLICATION("*"),
        DIVISION("/");

        final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        String getSymbol() {
            return symbol;
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split("\\s+"); // Разделение по пробелам

        if (parts.length != 3) {
            throw new Exception("Неправильный формат выражения");
        }

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Оба операнда должны быть от 1 до 10 включительно");
        }

        Operator operator = getOperator(parts[1]);

        int result;
        switch (operator) {
            case ADDITION:
                result = a + b;
                break;
            case SUBTRACTION:
                result = a - b;
                break;
            case MULTIPLICATION:
                result = a * b;
                break;
            case DIVISION:
                result = a / b;
                break;
            default:
                throw new Exception("Неподдерживаемая операция");
        }

        return String.valueOf(result);
    }

    static Operator getOperator(String symbol) throws Exception {
        for (Operator operator : Operator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new Exception("Неподдерживаемая операция");
    }
}
