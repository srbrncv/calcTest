import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        char operation = 0;
        int operationIndex = -1;
        for (int i=0; input.length()>i; i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operation = c;
                operationIndex = i;
                break;
            }
        }

        if (operation == 0) {
            throw new Exception("строка не является математической операцией");
        }

//        int operationIndex = -1;
//        char operation = 0;
//
//        if (input.contains("+")) {
//            operation = '+';
//            operationIndex = input.indexOf("+");
//        } else if (input.contains("-")) {
//            operation = '-';
//            operationIndex = input.indexOf("-");
//        } else if (input.contains("*")) {
//            operation = '*';
//            operationIndex = input.indexOf("*");
//        } else if (input.contains("/")) {
//            operation = '/';
//            operationIndex = input.indexOf("/");
//        }
//
//        if (operationIndex == -1) {
//            throw new Exception("не является математической операцией");
//        }

        String lNumb = input.substring(0, operationIndex);
        String rNum = input.substring(operationIndex + 1);

        int num1; int num2;
        try {
           num1 = Integer.parseInt(lNumb.trim());
           num2 = Integer.parseInt(rNum.trim());
        } catch (NumberFormatException e) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно");
        }

        int result = switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new Exception("Некорректная операция");
        };

        return String.valueOf(result);
    }
}
