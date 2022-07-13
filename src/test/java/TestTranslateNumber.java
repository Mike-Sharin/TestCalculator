import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTranslateNumber {
    @Test
    void testTranslateNumberExample() {
        assertEquals(Calculator.translateNumber(1), "I");
        assertEquals(Calculator.translateNumber(4), "IV");
        assertEquals(Calculator.translateNumber(10), "X");
        assertEquals(Calculator.translateNumber(15), "XV");
        assertEquals(Calculator.translateNumber(23), "XXIII");
        assertEquals(Calculator.translateNumber(36), "XXXVI");
        assertEquals(Calculator.translateNumber(51), "LI");
        assertEquals(Calculator.translateNumber(64), "LXIV");
        assertEquals(Calculator.translateNumber(98), "XCVIII");
        assertEquals(Calculator.translateNumber(100), "C");
    }
}
