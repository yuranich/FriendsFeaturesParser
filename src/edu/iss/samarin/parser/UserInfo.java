package edu.iss.samarin.parser;

import java.util.List;

/**
 * Created by yuranich on 16.05.2015.
 */
public class UserInfo {
    private long id;
    private String last_name;
    private Country country;
    private List<University> universities;
    private Occupation occupation;
    private City city;
    private List<School> schools;
    private Personal personal;

    public static class Country {
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj instanceof Country) {
                return id == ((Country) obj).getId();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return "country: " + title;
        }
    }

    public static class City {
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj instanceof City) {
                return id == ((City) obj).getId();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return "city: " + title;
        }
    }

    public static class University {
        private int city;
        private int id;
        private String education_form;
        private int faculty;
        private int country;
        private int chair;
        private String chair_name;
        private String education_status;
        private int graduation;
        private String name;

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEducation_form() {
            return education_form;
        }

        public void setEducation_form(String education_form) {
            this.education_form = education_form;
        }

        public int getFaculty() {
            return faculty;
        }

        public void setFaculty(int faculty) {
            this.faculty = faculty;
        }

        public int getCountry() {
            return country;
        }

        public void setCountry(int country) {
            this.country = country;
        }

        public int getChair() {
            return chair;
        }

        public void setChair(int chair) {
            this.chair = chair;
        }

        public String getEducation_status() {
            return education_status;
        }

        public void setEducation_status(String education_status) {
            this.education_status = education_status;
        }

        public int getGraduation() {
            return graduation;
        }

        public void setGraduation(int graduation) {
            this.graduation = graduation;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getChair_name() {
            return chair_name;
        }

        public void setChair_name(String chair_name) {
            this.chair_name = chair_name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj instanceof University) {
                return id == ((University)obj).getId();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return "education.university: " + name;
        }
    }

    public static class Occupation {
        private String type;
        private int id;
        private String name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj instanceof Occupation) {
                if (type.equals(((Occupation) obj).getType())) {
                    if (id == 0) {
                        return name.equals(((Occupation) obj).getName());
                    } else {
                        return id == ((Occupation) obj).getId();
                    }
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return ("work".equals(type))? name.hashCode(): id;
        }

        @Override
        public String toString() {
            return "occupation." + type + ": " + name;
        }
    }

    public static class School {
        private int city;
        private String id;
        private int year_graduated;
        private int country;
        private int year_from;
        private int year_to;
        private String name;
        private String school_class;
        private String speciality;
        private int type;
        private String type_str;

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getYear_graduated() {
            return year_graduated;
        }

        public void setYear_graduated(int year_graduated) {
            this.year_graduated = year_graduated;
        }

        public int getCountry() {
            return country;
        }

        public void setCountry(int country) {
            this.country = country;
        }

        public int getYear_from() {
            return year_from;
        }

        public void setYear_from(int year_from) {
            this.year_from = year_from;
        }

        public int getYear_to() {
            return year_to;
        }

        public void setYear_to(int year_to) {
            this.year_to = year_to;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSchool_class() {
            return school_class;
        }

        public void setSchool_class(String school_class) {
            this.school_class = school_class;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getType_str() {
            return type_str;
        }

        public void setType_str(String type_str) {
            this.type_str = type_str;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj instanceof School) {
                return id.equals(((School) obj).getId());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.parseInt(id);
        }

        @Override
        public String toString() {
            if (name != null && !name.isEmpty()) {
                return "education.school: " + name;
            }
            return "education.school.id: " + id;
        }
    }

    public static class Personal {
        private String religion;
        private int political;

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public int getPolitical() {
            return political;
        }

        public void setPolitical(int political) {
            this.political = political;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
