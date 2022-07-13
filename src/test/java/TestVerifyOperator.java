import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestVerifyOperator {

    @Test
    void testVerifyOperator1() throws CalculatorException {
        assertEquals(Calculator.verifyOperator("+"), '+');
        assertEquals(Calculator.verifyOperator("-"), '-');
        assertEquals(Calculator.verifyOperator("*"), '*');
        assertEquals(Calculator.verifyOperator("/"), '/');
    }

    @Test
    void testVerifyOperator2() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperator("+_-");
        });
        assertEquals(thrown.getMessage(), "Attention error: Does not match one of the arithmetic operations ( +, -, * , /)."); // Внимание ошибка: Не соответствует одной из арифметических операций ( +, -, * , /)
    }

    @Test
    void testVerifyOperator3() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperator("++");
        });
        assertEquals(thrown.getMessage(), "Attention error: Does not match one of the arithmetic operations ( +, -, * , /)."); // Внимание ошибка: Не соответствует одной из арифметических операций ( +, -, * , /)
    }

    @Test
    void testVerifyOperator4() throws CalculatorException {
        Throwable thrown = assertThrows(CalculatorException.class, () -> {
            Calculator.verifyOperator("%");
        });
        assertEquals(thrown.getMessage(), "Attention error: Does not match one of the arithmetic operations ( +, -, * , /)."); // Внимание ошибка: Не соответствует одной из арифметических операций ( +, -, * , /)
    }
}
