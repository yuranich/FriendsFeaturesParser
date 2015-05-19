package edu.iss.samarin.parser;

import java.io.*;

/**
 * Created by yuranich on 17.05.2015.
 */
public class Main {
    private static final String FILE_NAME = "friends.json";
    private static final String OUTPUT_FILE = "user.featnames";
    private static final String OUTPUT_FEATS = "user.feat";

    public static void main(String[] args) {
        ToFeaturesParser parser = new ToFeaturesParser(FILE_NAME);
        try (FileOutputStream fon = new FileOutputStream(OUTPUT_FEATS)) {
            PrintStream out = new PrintStream(fon);
            out.print(parser.getUsers().size());
            out.print(' ');
            out.println(parser.getFeatures().size());
            for (UserInfo user : parser.getUsers()) {
                out.print(user.getId());
                for (Object feat : parser.getFeatures()) {
                    out.print(' ');
                    out.print(parser.isUserContainsFeature(user, feat)? 1: 0);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (FileOutputStream fon = new FileOutputStream(OUTPUT_FILE)) {
//            PrintStream out = new PrintStream(fon);
//            out.println("Features size: " + parser.getFeatures().size());
//            for (Object o : parser.getFeatures()) {
//                out.println(o);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
