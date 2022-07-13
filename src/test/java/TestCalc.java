import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCalc {

    @Test
    void testCalcExample1() throws CalculatorException {
        assertEquals(Calculator.calc("1 + 2"), "3");
        assertEquals(Calculator.calc("1 - 7"), "-6");
        assertEquals(Calculator.calc("1 * 7"), "7");
        assertEquals(Calculator.calc("3 / 7"), "0");
        assertEquals(Calculator.calc("7 * 7"), "49");
    }

    @Test
    void testCalcExample2() throws CalculatorException {
        assertEquals(Calculator.calc("I + III"), "IV");
        assertEquals(Calculator.calc("VII - II"), "V");
        assertEquals(Calculator.calc("VI * VI"), "XXXVI");
        assertEquals(Calculator.calc("VI / III"), "II");
    }

    @Test
    void testCalcExample3() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.calc("I - II");
        });
        assertEquals(thrown.getMessage(), "Attention error: There are no negative numbers in the Roman system!"); // В римской системе нет отрицательных чисел!
    }

    @Test
    void testCalcExample4() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.calc("V / VI");
        });
        assertEquals(thrown.getMessage(), "Attention error: There are no negative numbers in the Roman system!"); // В римской системе нет отрицательных чисел!
    }

    @Test
    void testCalcExample5() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.calc("I + 1");
        });
        assertEquals(thrown.getMessage(), "Attention error: Different number systems are used at the same time!"); //Одновременно используются разные системы счисления!
    }

    @Test
    void testCalcExample6() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.calc("6 + V");
        });
        assertEquals(thrown.getMessage(), "Attention error: Different number systems are used at the same time!"); //Одновременно используются разные системы счисления!
    }

    @Test
    void testCalcExample7() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.calc("1");
        });
        assertEquals(thrown.getMessage(), "Warning error: String is not a mathematical operation!"); // Строка не является математической операцией!
    }

    @Test
    void testCalcExample8() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.calc("1 + 2 + 3");
        });
        assertEquals(thrown.getMessage(), "Attention error: The format of the mathematical operation does not satisfy the task - two operands and one operator (+, -, /, *)."); // Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)
    }

    @Test
    void testCalcExample9() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.calc("1 % 2");
        });
        assertEquals(thrown.getMessage(), "Attention error: Does not match one of the arithmetic operations ( +, -, * , /)."); // Внимание ошибка: Не соответствует одной из арифметических операций ( +, -, * , /)
    }
}