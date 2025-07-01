package com.example.zoo.service;

// Librerias que necesitamos

import com.example.zoo.model.Animal;
import com.example.zoo.model.Elephant;
import com.example.zoo.model.Leon;
import com.example.zoo.model.Pinguino;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TheZoo {

    @Value("${theZoo.name}")
    private String name;
    private final AnimalRepository animalRepository;

    public TheZoo(AnimalRepository animalRepository) {

        this.animalRepository = animalRepository;
    }

    public Animal addAnimal(Animal animal) {

        animalRepository.addAnimal(animal);
        return animal;
    }

    public void deleteAnimal(Animal animal) {

        animalRepository.deleteAnimal(animal);
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.getAnimalById(id);
    }

    public void getAnimalByName(Animal animal) {

        animalRepository.getAnimalByName(String.valueOf(animal));
    }

    public void getAnimalsBySpecie(Animal animal) {

        animalRepository.getAnimalsBySpecie(String.valueOf(animal));
    }
    public void updateAnimal(Animal animal) {
        animalRepository.updateAnimal(animal); // Esto actualiza el animal si existe
    }

    public void makeAnimalsSounds() {

        animalRepository.getAnimals().forEach(animal -> animal.makeSound());// Esto era un metodo abstacto
    }

    public List<Pinguino> makePenguinsSwim() {
       return animalRepository.getAnimals()
               .stream()
               .filter(animal -> animal instanceof Pinguino)
               .map(animal -> {
                   Pinguino pingu = (Pinguino) animal;
                   pingu.swim();
                   return pingu;
               })
               .toList();
    }

    public List<Leon> makeLeonsHunt() {
        return animalRepository.getAnimals()
                .stream()
                .filter(animal -> animal instanceof Leon)
                .map(animal -> {
                    Leon leo = (Leon) animal;
                    leo.hunt();
                    return leo;
                })
                .toList();
    }

    public List<Elephant> makeElephanBath() {
        return animalRepository.getAnimals()
                .stream()
                .filter(animal -> animal instanceof Elephant)
                .map(animal -> {
                    Elephant elepha = (Elephant) animal;
                    elepha.bathe();
                    return elepha;
                })
                .toList();
    }

    public void printAnimalsDetails() {

        // Creo una lista
        List<Animal> animalListTheZoo = animalRepository.getAnimals();

        //Imprime la lista creada con el nombre "animalListTheZoo"
        System.out.println(Arrays.toString(animalListTheZoo.toArray()));


        //Crea una lista filtrando los animales que van a ir en ella por el metodo "bySpecie"
        //1 List<Animal> listBySpecie = animalRepository.getAnimalsBySpecie("felino");

        //Imprime la lista creada con el nombre "listBySpecie"
        //1 System.out.println(Arrays.toString(listBySpecie.toArray()));

        /*
        //Imprime el animal que esta en el repositorio identificado con el Id 2.
        System.out.println(animalRepository.getAnimalById(2L));

         */

    }

    public String getName() {
        return this.name;
    }
}