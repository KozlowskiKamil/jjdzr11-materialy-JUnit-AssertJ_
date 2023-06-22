package pl.isa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionTests {

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


}