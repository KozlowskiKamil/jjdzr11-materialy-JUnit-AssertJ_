package pl.isa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionTests {
    private static Stream<ValuesWithSum> provideListOfMultipleIntValues() {
        return Stream.of(
                new ValuesWithSum(2, 2),
                new ValuesWithSum(Integer.MAX_VALUE, Integer.MIN_VALUE),
                new ValuesWithSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
    }

    @Test
    public void add_exceedIntMaxValue_throwsUnsupportedOperationException() {
        Exception exception = assertThrows(
                UnsupportedOperationException.class,
                () -> Addition.add(Integer.MAX_VALUE, 2)
        );
        assertEquals("Numbers exceed max value", exception.getMessage(), "Exception message is incorrect");
    }

    @Test
    public void add_exceedIntMinValue_throwsUnsupportedOperationException() {
        Exception exception = assertThrows(
                UnsupportedOperationException.class,
                () -> Addition.add(Integer.MIN_VALUE, -2)
        );
        assertEquals("Numbers exceed min value", exception.getMessage(), "Exception message is incorrect");
    }

    @Test
    public void add_noValuesGiven_returns0() {
        assertEquals(0, Addition.add(), "By default should return 0");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1, Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MAX_VALUE, Integer.MAX_VALUE - 1, 42, -51})
    public void add_singleValue_returnsSameValue(int value) {
        assertEquals(value, Addition.add(value), "Should return the same value");
    }

    @ParameterizedTest
    @MethodSource("provideListOfMultipleIntValues")
    public void add_multipleValues_returnSumOfValues(ValuesWithSum values) {
        assertEquals(values.getSum(), Addition.add(values.values));
    }

    private static class ValuesWithSum {
        int[] values;

        ValuesWithSum(int... values) {
            this.values = values;
        }

        int getSum() {
            return Arrays.stream(values).reduce(0, Integer::sum);
        }

        @Override
        public String toString() {
            return Arrays.toString(values);
        }
    }
}
