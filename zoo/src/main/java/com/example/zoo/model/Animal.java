package com.example.zoo.model;

public abstract class Animal {

    private Long id;
    private String name;
    private int age;
    private String specie;
    private boolean adoptable;

    private boolean available;

    public Animal() {
        // Constructor vacío
    }

    public Animal(String name, int age, String specie, boolean adoptable) {
        this.name = name;
        this.age = age;
        this.specie = specie;
        this.adoptable = adoptable;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecie() {
        return specie;
    }

    public boolean getAdoptable() {
        return adoptable;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setAdoptable(boolean adoptable) {
        this.adoptable = adoptable;
    }

    //Metodos
    public abstract void makeSound();// esta como protegido

    public void setId(Long newId) {
        this.id = newId;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + " ," +
                "name: " + this.getName() + " ," +
                "specie: " + this.getSpecie() + " ," +
                "age: " + this.age + " ," +
                "adoptable: " + this.adoptable;
    }
}
