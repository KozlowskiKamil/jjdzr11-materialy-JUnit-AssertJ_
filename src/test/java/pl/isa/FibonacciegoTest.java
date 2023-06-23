package pl.isa;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.isa.Fibonacci.getFibonacci;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

public class FibonacciegoTest {


    @Test
    public void fibonaccM() {
        assertThat(getFibonacci(3)).as("Fibon 3 is = 2").isEqualTo(2);
        assertThat(getFibonacci(5)).as("Fibon 5 is = 5").isEqualTo(5);
        assertThat(getFibonacci(10)).as("Fibon 9 is = 34").isEqualTo(55);
        String fibon100 = "354224848179261915075";
        assertThat(getFibonacci(100)).as("Fibon 9 is = 34").isEqualTo(String.valueOf(fibon100));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "44, 701408733",
            "99, 218922995834555169026",
            "100, 354224848179261915075"
    })
    public void  getFibonElement(int element, BigInteger expectedValue) {
        assertEquals(expectedValue, getFibonacci(element));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -4, -7, -100})
    public void getFibonElementBelowZero(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> getFibonacci(value)).withMessage("Wrong number");
    }


}
