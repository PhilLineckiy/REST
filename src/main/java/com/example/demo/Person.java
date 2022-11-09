package com.example.demo;

public class Person {
    private String name;
    private int age;
    private int id;

    public Person() {}
    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getId() {
        return this.id;
    }
}
