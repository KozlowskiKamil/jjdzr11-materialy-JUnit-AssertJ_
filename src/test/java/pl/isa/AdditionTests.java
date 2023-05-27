package pl.isa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AdditionTests {
    @Test
    public void test() {
        assertEquals(4, Addition.add(2, 2), "Should be equal");
    }
}
