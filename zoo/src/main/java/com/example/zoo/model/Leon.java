package com.example.zoo.model;

public class Leon extends Animal {

    //Atributos
    public Leon() {
        // Constructor vacío requerido por Spring
    }

    public Leon(String name, int age, String specie, boolean adoptable) {
        super(name, age, specie, adoptable);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " ruge: ¡Grrrr Perra!");
    }
    public void hunt(){
        System.out.println(this.getName() + " Lion hunts for food");
    }

}
