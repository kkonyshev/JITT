package com.britebill.interview.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataReader {

    public List<String> readData(String dataFile) {
        List<String> data = new ArrayList<>();
        try {
            data = Files.lines(Paths.get(this.getClass().getResource(dataFile).getFile())).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println ("Problem reading data file");
        }

        return data;
    }
}
