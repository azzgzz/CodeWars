package ru.azzgzz;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 5tyu
 * using lamda, regex
 */
public class AlphabetNuclearWar {

    public static String alphabetWar(String battlefield) {

        String[] shelters = battlefield.split("]");


        if (battlefield.contains("#")) {
            shelters = Stream.of(shelters)
                    .map(str -> str.replaceAll("[a-z]+#", "#"))
                    .map(str -> str.replaceAll("[a-z]+\\[", "["))
                    .toArray(String[]::new);
            if(!shelters[shelters.length-1].contains("["))
                shelters[shelters.length-1] =    shelters[shelters.length-1].replaceAll("[a-z]+$", "");
        }
        else
            return battlefield.replaceAll("[\\[\\]]", "");

        for (int i = 0; i < shelters.length; i++) {
            while (shelters[i].contains("#")){
                shelters[i] = bam(shelters[i]);
                if (i>0)
                    shelters[i-1] = bam(shelters[i-1]);
            }

        }

        battlefield = Stream.of(shelters).collect(Collectors.joining()).replaceAll("\\[", "");
        return battlefield;
    }

    private static String bam(String str) {
        if (str.contains("#"))
            str = str.substring(1);
        if (str.contains("["))
            str = str.replaceAll("[\\[]", "");
        else
            str = str.replaceAll("[a-z]","");
        return str;
    }
}
