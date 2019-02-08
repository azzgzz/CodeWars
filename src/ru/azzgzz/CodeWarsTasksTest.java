package ru.azzgzz;

import org.junit.Test;
import static org.junit.Assert.*;

public class CodeWarsTasksTest {

    @Test
    public void isogramTest() {
        assertEquals(true, CodeWarsTasks.isIsogram("Dermatoglyphics"));
        assertEquals(true, CodeWarsTasks.isIsogram("isogram"));
        assertEquals(false, CodeWarsTasks.isIsogram("moose"));
        assertEquals(false, CodeWarsTasks.isIsogram("isIsogram"));
        assertEquals(false, CodeWarsTasks.isIsogram("aba"));
        assertEquals(false, CodeWarsTasks.isIsogram("moOse"));
        assertEquals(true, CodeWarsTasks.isIsogram("thumbscrewjapingly"));
        assertEquals(true, CodeWarsTasks.isIsogram(""));
    }

    @Test
    public void shouldWorkForSomeExamples() throws Exception {
        assertEquals("negative numbers aren't square numbers", false, CodeWarsTasks.isSquare(-1));
        assertEquals("0 is a square number (0 * 0)",    true,   CodeWarsTasks.isSquare(0));
        assertEquals("3 isn't a square number", false,  CodeWarsTasks.isSquare(3));
        assertEquals("4 is a square number (2 * 2)",    true,   CodeWarsTasks.isSquare(4));
        assertEquals("25 is a square number (5 * 5)",   true,   CodeWarsTasks.isSquare(25));
        assertEquals("26 isn't a square number",false,  CodeWarsTasks.isSquare(26));
    }


    @Test
    public void transpositionTest() {
        doTest("Sample text", "Sml etapetx");
        doTest("Simple transposition", "Sml rnpstoipetasoiin");
        doTest("All that glitters is not gold", "Alta ltesi o odl htgitr sntgl");
        doTest("The better part of valor is discretion", "Tebte ato ao sdsrtoh etrpr fvlri icein");
        doTest("Conscience does make cowards of us all", "Cncec osmk oad fu losinede aecwrso sal");
        doTest("Imagination is more important than knowledge", "Iaiaini oeipratta nwegmgnto smr motn hnkolde");
    }
    private void doTest(String text, String expected) {
        assertEquals(expected, CodeWarsTasks.simpleTransposition(text));
    }

    @Test
    public void compTest() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(true, CodeWarsTasks.comp(a, b));
    }
}