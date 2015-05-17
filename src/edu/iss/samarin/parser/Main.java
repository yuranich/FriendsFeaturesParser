package edu.iss.samarin.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by yuranich on 17.05.2015.
 */
public class Main {
    private static final String FILE_NAME = "friends.json";
    private static final String RESULT_FILE = "result.json";
    private static List<UserInfo> users;

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (FileInputStream fin = new FileInputStream(FILE_NAME)) {
            users = mapper.readValue(fin,
                    mapper.getTypeFactory().constructCollectionType(List.class, UserInfo.class));
            mapper.writeValue(new File(RESULT_FILE), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
