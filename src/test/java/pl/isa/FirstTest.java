package pl.isa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {



    @Test
    public void firstTest() {
    assertTrue(true,"This shuld be true");
    }

    @Test
    public void second() {
        assertEquals(2 +2, 4);
    }

    @Test
    public void third(){
        assertEquals("kamil", "kamil");
    }

    @Test
    public void four(){
        assertNotEquals(3 + 2, 6);
    }


    @BeforeEach
    public void before() {
        System.out.println("przed");
    }

    @AfterAll
    public static void clean() {
        System.out.println("clean");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abc", "Abc", "Abc"})
    public void fiveTest(String str){
       assertEquals(3, str.length());
       assertEquals("Abc", str);

    }

    @ParameterizedTest
    @ValueSource(strings = {"Abc", "Abc", "Abc"})
    public void sixTest(String str){
        assertEquals("Abc", str);
    }

}