package com.example.democrud1.design_patter.builderpattern;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String dayOfBirth;
    private String phone;

    public Student(String id, String firstName, String lastName, String dayOfBirth, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


