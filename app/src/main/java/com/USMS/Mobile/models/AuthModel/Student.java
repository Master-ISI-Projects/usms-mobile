package com.USMS.Mobile.models.AuthModel;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int classeId;
    private String classeName;
    private String token;

    public Student(int id, String firstName, String lastName, int classeId, String classeName, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classeId = classeId;
        this.classeName = classeName;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getClasseId() {
        return classeId;
    }

    public void setClasseId(int classeId) {
        this.classeId = classeId;
    }

    public String getClasseName() {
        return classeName;
    }

    public void setClasseName(String classeName) {
        this.classeName = classeName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", classeId=" + classeId +
                ", classeName='" + classeName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
