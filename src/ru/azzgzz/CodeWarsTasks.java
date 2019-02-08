package ru.azzgzz;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class CodeWarsTasks {


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

        if (a == null || b == null)     return false;
        if (b.length == 0 && a.length == 0) return true;
        if (a.length != b.length) return false;

        a = Arrays.stream(a).map(n -> n*n).sorted().toArray();
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    public static void main(String[] args) {

        int[] a = {1, -1, 0, 5, 1};
        a = Arrays.stream(a).map(n -> abs(n)).sorted().toArray();

        Collection<Integer> collection;
        collection = Arrays.stream(a).boxed().collect(Collectors.toList());

        collection.forEach(q -> q=q*q);

        System.out.println(collection.toString());
    }


}
