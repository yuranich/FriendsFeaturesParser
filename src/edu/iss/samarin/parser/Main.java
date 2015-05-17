package edu.iss.samarin.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

/**
 * Created by yuranich on 17.05.2015.
 */
public class Main {
    private static final String FILE_NAME = "friends.json";
    private static final String OUTPUT_FILE = "user.featnames";

    public static void main(String[] args) {
        ToFeaturesParser parser = new ToFeaturesParser(FILE_NAME);
        try (FileOutputStream fon = new FileOutputStream(OUTPUT_FILE)) {
            PrintStream out = new PrintStream(fon);
            out.println("Features size: " + parser.getFeatures().size());
            for (Object o : parser.getFeatures()) {
                out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
