package ru.azzgzz;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.*;

public class CodeWarsTasks {

    /**
     * Given two arrays of strings a1 and a2
     * @return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2
     */
    public static String[] inArrayTask2(String[] array1, String[] array2) {

        List<String> set1 = Arrays.stream(array1).distinct().sorted().collect(Collectors.toList());
        List<String> set2 = Arrays.stream(array2).distinct().sorted().collect(Collectors.toList());

        set1.removeIf(x -> {
            for (String s: set2) {
                if (s.contains(x))
                    return false;
            }
            return true;
        });

        return set1.toArray(new String[0]);
    }


    public static String[] inArrayTask(String[] array1, String[] array2) {

        return (Arrays.stream(array1).distinct().sorted())
                .filter(s1 -> Arrays.stream(array2)
                        .anyMatch(s2 -> s2.contains(s1)))
                .toArray(String[] :: new);
    }

    /**
     * 6kyu
     * @param text can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits
     * @return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string
     */
    public static int duplicateCount(String text) {

        int[] cTable = new int[256];

        int[] intCharsArray = text.codePoints().toArray();

        for (int i = 0; i < intCharsArray.length; i++) {
            cTable[intCharsArray[i]]++;
        }

        return (int) Arrays.stream(cTable)
                .filter(x -> x > 1)
                .count();
    }


    public static int nbYear(int p0, double percent, int aug, int p) {
        percent /= 100;
        if (percent <= 0)
            return (int) ceil((p - p0) / aug);
        return (int) ceil((log(percent * p + aug) - log(p0 * percent + aug)) / log(1 + percent));
    }


    public static int findShort(String s) {
        String[] ss = s.split(" ");
        int min = ss[0].length();

        for (int i = 0; i < ss.length; i++) {
            if (min > ss[i].length() && ss[i].length() > 0)
                min = ss[i].length();
        }
        return min;
    }


    public static String maskify(String str) {

        if (str.length() < 5) {
            return str;
        }

        return str.substring(0, str.length() - 4).replaceAll(".", "#") + str.substring(str.length() - 4);
    }


    public static int squareDigits(int n) {

        String number = "" + n;
        String tmp = "";

        for (int i = 0; i < number.length(); i++) {
            tmp = tmp + sqr(Integer.parseInt(number.substring(i, i + 1)));
        }

        return Integer.parseInt(tmp);
    }


    public static int sqr(int a) {
        return a * a;
    }


    public static boolean isIsogram(String str) {

        str = str.toLowerCase();
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.substring(i, i + 1));
        }

        return str.length() == set.size();
    }


    public static boolean isSquare(int n) {

        return (n < 0) ? false : Math.sqrt(n) == Math.floor(Math.sqrt(n));
    }


    public static String simpleTransposition(String text) {

        StringBuilder[] a = {new StringBuilder(), new StringBuilder()};

        for (int i = 0; i < text.length(); i++) {
            a[i % 2].append(text.charAt(i));
        }
        return a[0].toString() + a[1].toString();
    }


    public static boolean comp(int[] a, int[] b) {

        if (a == null || b == null) return false;
        if (b.length == 0 && a.length == 0) return true;
        if (a.length != b.length) return false;

        a = Arrays.stream(a).map(n -> n * n).sorted().toArray();
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    /**
     * 6kyu
     * Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.
     */
    public static int countSmileys(List<String> arr) {

        return (int) arr.stream()
                .map(string -> string.matches("[:;][-~]?[)D]"))
                .filter(a -> a == true)
                .count();
    }


    public static void main(String[] args) {

        char a = 'a';

        int[] b = new int[1024];

        b[a] = 1;

        Arrays.stream(b).filter(x -> x > 0).forEach(x -> System.out.println(x));

    }


}
