package pl.isa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTests {
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "11, 89",
            "22, 17711",
            "42, 267914296",
            "99, 218922995834555169026",
            "100, 354224848179261915075"
    })
    public void getElement_elementInRange_correctValue(int element, BigInteger expectedValue) {
        assertEquals(expectedValue, Fibonacci.getElement(element));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 101, 102})
    public void getElement_elementOutOfRange_throwsIllegalArgumentException(int element) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Fibonacci.getElement(element))
                .withMessage("element should be in 0-100 range");
    }
}
