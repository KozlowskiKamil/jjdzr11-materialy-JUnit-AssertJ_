package pl.isa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AdditionTests {

    private static Stream<ValuesListWithSum> provideListOfMultipleIntValues() {
          return Stream.of(
                  new ValuesListWithSum(5, 2),
                  new ValuesListWithSum(Integer.MAX_VALUE, Integer.MIN_VALUE),
                  new ValuesListWithSum(4, 8));
    }

    private static int[] provideArrayOfMultipleIntValues() {
        int[] ints = {1,2,3};
        return ints;
    }


    @Test
    public void test() {
        assertEquals(4, Addition.add(2, 2), "Should be equal");
    }


    @Test
    public void add_maxValueShouldThrowUnsupportedOperationException() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> Addition.add(Integer.MAX_VALUE, 2));
        assertEquals("Numbers exceed max", exception.getMessage(), "Exception message is incorrect");
    }


    @Test
    public void add_minValueShouldThrowUnsupportedOperationException() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> Addition.add(Integer.MIN_VALUE, -1));
        assertEquals("Numbers exceed MIN", exception.getMessage(), "Wrong mesage");
    }

    @Test
    public void noValueGivern_Retuns0() {
        assertEquals(0, Addition.add(), "Shuld 0");
    }

    @Test
    public void singleValue() {
        assertEquals(7, Addition.add(7), "Shuld be 7");
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, Integer.MAX_VALUE, Integer.MIN_VALUE, -4, 1, 4, 5, 7})
    public void parametrValue(int value) {
        assertEquals(value, Addition.add(value));
    }

    @ParameterizedTest
    @MethodSource("provideListOfMultipleIntValues")
    public void add_multipleValues_returnsSumOfValues(ValuesListWithSum values) {
        assertEquals(values.getSum(), Addition.add(values.values));
    }

        private static class ValuesListWithSum {
        int[] values;

        ValuesListWithSum(int ... values) {
            this.values = values;
        }
        int getSum() {
            return Arrays.stream(values).reduce(0, Integer::sum);
        }

            @Override
            public String toString() {
                return "ValuesListWithSum{" +
                        "values=" + Arrays.toString(values) +
                        '}';
            }
        }
}