import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOperation {
    @Test
    void testOperationExample1() throws CalculatorException {
        assertEquals(Calculator.operation(1, '+', 2), 3);
        assertEquals(Calculator.operation(1, '-', 5), -4);
        assertEquals(Calculator.operation(1, '-', 1), 0);
        assertEquals(Calculator.operation(8, '*', 8), 64);
        assertEquals(Calculator.operation(6, '/', 3), 2);
    }
}
