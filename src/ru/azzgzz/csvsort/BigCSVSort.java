package ru.azzgzz.csvsort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BigCSVSort {
    private String header;
    private List<OneLine> body;

    BigCSVSort () {
        header = null;
        body = new ArrayList();
    }

    public void smallSort(String filePath) throws FileNotFoundException {
        Reader reader = new FileReader(filePath);
    }
}
