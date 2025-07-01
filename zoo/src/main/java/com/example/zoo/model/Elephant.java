package com.example.zoo.model;

public class Elephant extends Animal {

    public Elephant() {
        // Constructor vacío requerido por Spring
    }

    //Atributos

    public Elephant(String name, int age, String specie, boolean adoptable) {

        super(name, age, specie, adoptable);
    }

     public void bathe(){
        System.out.println(this.getName() + " Elephan enjoys a bath");
    }

    @Override
    public void makeSound(){
        System.out.println(getName() +"El elefante emite el siguiente sonido: Chupelo!!!");
    }

    /*
    // Con este metodo solo imprime el nombre y la especie
    @Override
    public String toString(){

        return this.getName() + " " + this.getSpecie();
    }
     */
}
