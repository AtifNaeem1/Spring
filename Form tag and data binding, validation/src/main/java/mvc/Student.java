package mvc;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String courseStream;
    private String favoriteLanguage;

    private String[] operatingSystem;
    private LinkedHashMap<String,String> courseStreamOptions;

    public Student()
    {
        courseStreamOptions = new LinkedHashMap<>();
        courseStreamOptions.put("CSE","Computer Science");
        courseStreamOptions.put("ME","Mechanical");
        courseStreamOptions.put("CE","Civil");
        courseStreamOptions.put("IT","Information Technology");
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCourseStream() {
        return courseStream;
    }

    public void setCourseStream(String courseStream) {
        this.courseStream = courseStream;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public LinkedHashMap<String, String> getCourseStreamOptions() {
        return courseStreamOptions;
    }

}
