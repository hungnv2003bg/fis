package com.example.democrud1.design_patter.builderpattern;

// Builder
public interface StudentBuilder {

    StudentBuilder setId(String id);

    StudentBuilder setFirstName(String firstName);

    StudentBuilder setLastName(String lastName);

    StudentBuilder setDayOfBirth(String dayOfBirth);

    StudentBuilder setPhone(String phone);

    Student build();
}

