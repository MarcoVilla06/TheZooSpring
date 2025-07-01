package com.example.zoo.service;

import com.example.zoo.model.Animal;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AnimalRepository {

    private static final Map<Long, Animal> ANIMALS = new HashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0); // Contador para

    public void addAnimal(Animal animal) {
        Long newId = ID_GENERATOR.incrementAndGet(); // Genera ID unico
        animal.setId(newId); // Asigna el ID al animal
        ANIMALS.put(newId, animal);
    }

    public void deleteAnimal(Animal animal) {
        ANIMALS.entrySet().removeIf(entry -> entry.getValue().equals(animal));
        System.out.println("This Animal delete");
        //Pregunta, si este es el metodo que elimina al animal, es decir, para mi...
        //...esta secuencia es la que se ejecuta, por quee imprime el S.o.p del llamado?
    }

    public Animal getAnimalById(Long id) {
        System.out.println("getting animal with id: " + id);
        Animal animal = ANIMALS.get(id); // Me retorna null si no existe
        System.out.println("animal retrieved with id: " + id + " = " + animal);
        return animal;
    }
    public List<Animal> getAnimalByName(String name) {
        return ANIMALS.values().stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .toList();
    }

    public List<Animal> getAnimalsBySpecie(String specie) {
        return ANIMALS.values().stream()
                .filter(animal -> animal.getSpecie().equalsIgnoreCase(specie))
                .toList();
    }

    public boolean updateAnimal(Animal updatedAnimal) {
        // containsKey asegura que el id exista en el mapa.
        if (ANIMALS.containsKey(updatedAnimal.getId())) {
           ANIMALS.put(updatedAnimal.getId(), updatedAnimal);
            return true;
        }
        return false;
    }

    public List<Animal> getAnimals() {
        return ANIMALS.values().stream().toList();
    }
}
