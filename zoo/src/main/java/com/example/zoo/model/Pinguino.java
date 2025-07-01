package com.example.zoo.model;

public class Pinguino extends Animal{

    public Pinguino() {
        // Constructor vacío requerido por Spring
    }

    //Atributos
    public Pinguino(String name, int age, String specie, boolean adoptable) {

        super(name, age, specie, adoptable);
    }
    @Override
    public void makeSound (){
        System.out.println(getName() + "Squirk jaja");
    }
    public void swim(){
        System.out.println(this.getName() + " Penguin loves swimming");
    }

}

