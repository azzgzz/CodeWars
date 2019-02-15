package ru.azzgzz.csvsort;

public class OneLine {
    private int key;
    private String value;

    public OneLine(String str) {
        key = Integer.parseInt(str.split(";")[0]);
        value = str;
    }

    public int compareTo (OneLine b) {
        return b.key - key;
    }

    public String getValue() {
        return value;
    }
}
