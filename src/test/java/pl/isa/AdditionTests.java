package pl.isa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
        assertEquals("Numbers exceed MIN", exception.getMessage(),"Wrong mesage");
    }
}