import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVerifyOperand {

    @Test
    void testVerifyOperand1() throws CalculatorException {
        assertEquals(Calculator.verifyOperand("1"), 1);
        assertEquals(Calculator.verifyOperand("2"), 2);
        assertEquals(Calculator.verifyOperand("3"), 3);
        assertEquals(Calculator.verifyOperand("4"), 4);
        assertEquals(Calculator.verifyOperand("5"), 5);
        assertEquals(Calculator.verifyOperand("6"), 6);
        assertEquals(Calculator.verifyOperand("7"), 7);
        assertEquals(Calculator.verifyOperand("8"), 8);
        assertEquals(Calculator.verifyOperand("9"), 9);
        assertEquals(Calculator.verifyOperand("10"), 10);
        assertEquals(Calculator.verifyOperand("I"), 1);
        assertEquals(Calculator.verifyOperand("II"), 2);
        assertEquals(Calculator.verifyOperand("III"), 3);
        assertEquals(Calculator.verifyOperand("IV"), 4);
        assertEquals(Calculator.verifyOperand("V"), 5);
        assertEquals(Calculator.verifyOperand("VI"), 6);
        assertEquals(Calculator.verifyOperand("VII"), 7);
        assertEquals(Calculator.verifyOperand("VIII"), 8);
        assertEquals(Calculator.verifyOperand("IX"), 9);
        assertEquals(Calculator.verifyOperand("X"), 10);
    }

    @Test
    void testVerifyOperand2() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("15");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand3() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("XII");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand4() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("F");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand5() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("-6");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand6() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("0");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand7() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("V2");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand8() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("5,4");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand9() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("3.7");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand10() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("6.");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }

    @Test
    void testVerifyOperand11() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperand("8,");
        });
        assertEquals(thrown.getMessage(), "Attention error: The numbers do not match the given parameters."); // Внимание ошибка: Числа не соответствуют заданным параметрам.
    }
}