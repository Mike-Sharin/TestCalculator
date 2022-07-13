import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
    public static final String regexOperators = "[\\+|\\-|\\*|\\/]";
    public static final String regexRomanNumber = "I|II|III|IV|V|VI|VII|VIII|IX|X";

    public static void main(String[] args) throws CalculatorException {
        Scanner in = new Scanner(System.in);

        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.\n" +
                "Калькулятор умеет работать с арабскими (1,2,3,4,5…) и с римскими (I,II,III,IV,V…) числами.\n" +
                "Для работы введите число, затем операцию и сново число через пробел.\n" +
                "Для выхода наберите слово exit\n");

        String keyboardInput;
        String resultCalc;

        while (true) {
            System.out.print("Input: ");
            keyboardInput = in.nextLine();

            if (keyboardInput.toUpperCase().trim().equals("EXIT")) {
                System.out.println("Выход из программы!");
                break;
            } else {
                resultCalc = calc(keyboardInput.toUpperCase().trim());   // требование к программе № 1

                if (!resultCalc.equals(""))
                    System.out.print("Output: " + resultCalc + "\n\n");
            }
        }
        in.close();
    }

    public static String calc(String input) throws CalculatorException {
        String[] mas = input.trim().split(" ");

        if(mas.length < 3)
                    throw new CalculatorException("Warning error: String is not a mathematical operation!");   // testCalcExample7
        else if(mas.length > 3)
                throw new CalculatorException("Attention error: The format of the mathematical operation does not satisfy the task - two operands and one operator (+, -, /, *).");   // testCalcExample6

        char operator = verifyOperator(mas[1]);
        int operand1 = verifyOperand(mas[0]);
        int operand2 = verifyOperand(mas[2]);

        boolean romanOperand1 = Pattern.matches(regexRomanNumber,mas[0]);
        boolean romanOperand2 = Pattern.matches(regexRomanNumber,mas[2]);

        if(romanOperand1 != romanOperand2) {
            throw new CalculatorException("Attention error: Different number systems are used at the same time!");   //  требование к программе № 5 - testCalcExample5-testCalcExample6
        }

        int operationResult = operation(operand1, operator, operand2);

        if(romanOperand1 && (operationResult <= 0)) //  требование к программе № 10 - testCalcExample3-testCalcExample4
            throw new CalculatorException("Attention error: There are no negative numbers in the Roman system!"); // В римской системе нет отрицательных чисел!

        if(romanOperand1)   //  требование к программе № 6 - testCalcExample1-testCalcExample2
            return translateNumber(operationResult);
        else
            return String.valueOf(operationResult);
    }

    public static String translateNumber(int number){
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        String[] romansArray = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        int[] arabicArray = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100};
        for (int i = arabicArray.length - 1; i >= 0; i--) {
            tmp = number / arabicArray[i];
            number %= arabicArray[i];
            while (tmp > 0) {
                sb.append(romansArray[i]);
                tmp--;
            }
        }
        return sb.toString();
    }
    public static int operation(int operand1, char operator, int operand2) throws CalculatorException{
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new CalculatorException("Attention error: Does not match one of the arithmetic operations ( +, -, * , /).");
        }
    }

    public static int verifyOperand(String operandString) throws CalculatorException{
        switch(operandString){              // требование к программе № 3, 4, 7  - testVerifyOperand1-testVerifyOperand11
            case "I":
            case "II":
            case "III":
            case "IV":
            case "V":
            case "VI":
            case "VII":
            case "VIII":
            case "IX":
            case "X":
                return RomanNumber.valueOf(operandString).getArabicNumber();
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                return Integer.parseInt(operandString);
            default:
                throw new CalculatorException("Attention error: The numbers do not match the given parameters.");
        }
    }

    public static char verifyOperator(String operatorString) throws CalculatorException {
        if(operatorString.length() == 1 && Pattern.matches(regexOperators,operatorString))
            return operatorString.charAt(0);
        else
            throw new CalculatorException("Attention error: Does not match one of the arithmetic operations ( +, -, * , /).");  // требование к программе № 8 - testCalcExample9 и testVerifyOperator1()-testVerifyOperator4()
    }
}

/*
ТЕСТОВАЯ ЗАДАЧА “КАЛЬКУЛЯТОР”

Описание:
    Создай консольное приложение “Калькулятор”. Приложение должно читать из консоли введенные пользователем строки, числа, арифметические операции проводимые между ними и выводить в консоль результат их выполнения.
    Реализуй класс Main с методом public static String calc(String input). Метод должен принимать строку с арифметическим выражением между двумя числами и возвращать строку с результатом их выполнения.
    Ты можешь добавлять свои импорты, классы и методы. Добавленные классы не должны иметь модификаторы доступа (public или другие)
Требования:
    1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотри пример)!
        Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
    2. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
    3. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
    4. Калькулятор умеет работать только с целыми числами.
    5. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
    6. При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.
    7. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
    8. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
    9. Результатом операции деления является целое число, остаток отбрасывается.
    10. Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль. Результатом работы калькулятора с римскими числами могут быть только положительные числа,
        если результат работы меньше единицы, выбрасывается исключение
Пример работы программы:
1.  Input: 1 + 2
    Output: 3
2.  Input: VI / III
    Output: II
3.  Input: I - II
    Output: throws Exception //т.к. в римской системе нет отрицательных чисел
4.  Input: I + 1
    Output: throws Exception //т.к. используются одновременно разные системы счисления
5.  Input: 1
    Output: throws Exception //т.к. строка не является математической операцией
6.  Input: 1 + 2 + 3
    Output: throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)
*/