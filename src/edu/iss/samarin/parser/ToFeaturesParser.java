package edu.iss.samarin.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuranich on 17.05.2015.
 */
public class ToFeaturesParser {
    private List<UserInfo> users;
    private Set<Object> features = new LinkedHashSet<>(100);

    private ToFeaturesParser() {
    }

    public ToFeaturesParser(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (FileInputStream fin = new FileInputStream(fileName)) {
            users = mapper.readValue(fin,
                    mapper.getTypeFactory().constructCollectionType(List.class, UserInfo.class));
            if (users == null || users.isEmpty()) {
                throw new RuntimeException("No info read from json.");
            }
            extractFeaturesFromUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void extractFeaturesFromUsers() {
        for (UserInfo user : users) {
            if (user.getFirst_name() != null && !user.getFirst_name().isEmpty()) {
                features.add(new SimpleFeature("first_name", user.getFirst_name()));
            }
            if (user.getLast_name() != null && !user.getLast_name().isEmpty()) {
                features.add(new SimpleFeature("last_name", user.getLast_name()));
            }
            if (user.getHome_town() != null && !user.getHome_town().isEmpty()) {
                features.add(new SimpleFeature("home_town", user.getHome_town()));
            }
            if (user.getCity() != null && user.getCity().getId() != 0) {
                features.add(user.getCity());
            }
            if (user.getCountry() != null && user.getCountry().getId() != 0) {
                features.add(user.getCountry());
            }
            if (user.getOccupation() != null && user.getOccupation().getId() != 0) {
                features.add(user.getOccupation());
            }
            if (user.getPersonal() != null) {
                UserInfo.Personal person = user.getPersonal();
                if (person.getPolitical() != 0) {
                    features.add(new SimpleFeature("personal.political.id", person.getPolitical()));
                }
                if (person.getReligion() != null && person.getReligion().isEmpty()) {
                    features.add(new SimpleFeature("personal.religion", person.getReligion()));
                }
            }
            if (user.getSchools() != null && !user.getSchools().isEmpty()) {
                for (UserInfo.School school : user.getSchools()) {
                    features.add(school);
                }
            }
            if (user.getUniversities() != null && !user.getUniversities().isEmpty()) {
                for (UserInfo.University university : user.getUniversities()) {
                    features.add(university);
                }
            }
        }
    }

    public class SimpleFeature {
        private String name;
        private Object value;

        private SimpleFeature() {
        }

        public SimpleFeature(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj instanceof SimpleFeature) {
                return value.equals(((SimpleFeature)obj).getValue());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }

        @Override
        public String toString() {
            return name + ": " + value.toString();
        }
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public Set<Object> getFeatures() {
        return features;
    }
}
