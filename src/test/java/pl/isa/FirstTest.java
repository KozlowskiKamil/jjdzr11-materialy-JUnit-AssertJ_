package pl.isa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    @BeforeAll
    public static void setup() {
        System.out.println("Setup");
    }

    @Test
    public void firstTest() {
        assertTrue(true);
    }

    @Test
    public void secondTest() {
        assertEquals(4, 2 + 2);
    }

    @Test
    @Disabled
    public void disabledTest() {
        fail();
    }

    @AfterEach
    public void testCleanUp() {
        System.out.println("Test clean up");
    }
}
