package com.example.democrud1.design_patter.builderpattern;

public class MainStudent {
    public static void main(String[] args) {

        StudentBuilder studentBuilder = new StudentConcreteBuilder()
                .setId("1")
                .setFirstName("Nguyen")
                .setLastName("Van Hung")
                .setDayOfBirth("25")
                .setPhone("0364920603");


        System.out.println(studentBuilder.build());
    }

}
