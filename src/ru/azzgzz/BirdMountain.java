package ru.azzgzz;

import java.util.Arrays;

public class BirdMountain {

    private static int hei;
    private static int wid;

    private static int[][] intMount;

    public static int peakHeight(char[][] mountain) {
        int maxhei = 1;

        if (mountain == null || mountain.length == 0)
            return 0;

        hei = mountain.length;
        wid = mountain[0].length;
        intMount = new int[hei][wid];

        if (translate(mountain))
            return 0;

        while (!evolve(mountain)) {
            maxhei++;
            translate(mountain);
        }
        return maxhei;
    }


    private static boolean translate(char[][] mountain) {

        boolean isEmpty = true;
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < wid; j++) {
                intMount[i][j] = 0;
                switch (mountain[i][j]) {
                    case ' ': {
                        intMount[i][j] = 0;
                        break;
                    }
                    case '^': {
                        intMount[i][j] = 1;
                        isEmpty = false;
                    }
                }
            }
        }
        return isEmpty;
    }


    private static boolean evolve(char[][] mountain) {
        int x = 0;
        boolean isEmpty = true;
        for (int i = 0; i < hei; i++) {
            for (int j = 0; j < wid; j++) {
                try {
                    x = intMount[i - 1][j] * intMount[i][j + 1] * intMount[i + 1][j] * intMount[i][j - 1];
                } catch (Throwable e) {
                    x = 0;
                }
                switch (x) {
                    case 0: {
                        mountain[i][j] = ' ';
                        break;
                    }
                    case 1: {
                        mountain[i][j] = '^';
                        isEmpty = false;
                    }
                }
            }
        }
        return isEmpty;
    }
}