package ru.azzgzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CodeWarsTasksTest {


    @Test
    public void duplicateContTest() {
        assertEquals(0, CodeWarsTasks.duplicateCount("abcde"));

        assertEquals(1, CodeWarsTasks.duplicateCount("abcdea"));

        assertEquals(1, CodeWarsTasks.duplicateCount("indivisibility"));

        String testThousandA = new String(new char[1000]).replace('\0', 'a');
        String testHundredB = new String(new char[100]).replace('\0', 'b');
        String testTenC = new String(new char[10]).replace('\0', 'c');
        String test1CapitalA = new String(new char[1]).replace('\0', 'A');
        String test1d = new String(new char[1]).replace('\0', 'd');
        String test = test1d + test1CapitalA + testTenC +
                testHundredB + testThousandA;


        assertEquals(3, CodeWarsTasks.duplicateCount(test));
    }


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
        assertEquals("0 is a square number (0 * 0)", true, CodeWarsTasks.isSquare(0));
        assertEquals("3 isn't a square number", false, CodeWarsTasks.isSquare(3));
        assertEquals("4 is a square number (2 * 2)", true, CodeWarsTasks.isSquare(4));
        assertEquals("25 is a square number (5 * 5)", true, CodeWarsTasks.isSquare(25));
        assertEquals("26 isn't a square number", false, CodeWarsTasks.isSquare(26));
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
        assertTrue(CodeWarsTasks.comp(a, b));
    }


    @Test
    public void countSmileysTest() {
        List<String> a = new ArrayList<>();
        a.add(":)");
        a.add(":D");
        a.add(":-}");
        a.add(":-()");
        a.add(":):)");
        assertEquals(2, CodeWarsTasks.countSmileys(a));

        a = new ArrayList<>();
        a.add(":)");
        a.add("XD");
        a.add(":0}");
        a.add("x:-");
        a.add("):-");
        a.add("D:");
        assertEquals(1, CodeWarsTasks.countSmileys(a));

        a = new ArrayList<>();
        a.add(":)");
        a.add(":D");
        a.add("X-}");
        a.add("xo)");
        a.add(":X");
        a.add(":-3");
        a.add(":3");
        assertEquals(2, CodeWarsTasks.countSmileys(a));

        a = new ArrayList<>();
        a.add(":)");
        a.add(":)");
        a.add("x-]");
        a.add(":ox");
        a.add(";-(");
        a.add(";-)");
        a.add(";~(");
        a.add(":~D");
        assertEquals(4, CodeWarsTasks.countSmileys(a));
    }
}