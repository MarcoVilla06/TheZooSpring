package com.example.zoo.api;

import com.example.zoo.model.Animal;
import com.example.zoo.model.Elephant;
import com.example.zoo.model.Leon;
import com.example.zoo.model.Pinguino;
import com.example.zoo.service.TheZoo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final TheZoo theZoo;


    public AnimalController(TheZoo theZoo) {
        this.theZoo = theZoo;
        zooOps();//Se ejecuta desde aca, para que al realizar los llamados...
                 //...tenga los animales instanciado para poder consultar.
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable String id)
    {
        //zooOps();//Philip los habia dejado aca, pero cada vez que hacia un...
                   //...llamado los creaba nuevamente.
        return ResponseEntity.ok(theZoo.getAnimalById(Long.parseLong(id)));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable String id) {

        // buscamos el animal por su ID
        Animal animalToDelete = theZoo.getAnimalById(Long.parseLong(id));

        // Verificamos si existe, esto lo puedo omitir, ya que yo se que si existe
        // para este ejercicio,
        if(animalToDelete == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró animal con ID " + id);
        }

        // lo elimina usando el metodo que tengo en theZoo
        theZoo.deleteAnimal(animalToDelete);

        return ResponseEntity.ok("Animal con ID " + id + " eliminado correctamente");
    }

    @PostMapping
    public ResponseEntity<String> createAnimal(@RequestBody Map<String, Object> requestData) {

        // Extrae el tipo de animal y valida
        String type = (String) requestData.get("type");
        if (type == null) {
            return ResponseEntity.badRequest().body("El campo 'type' es obligatorio (ej: 'Pinguino', 'Leon')");
        }
        // Crea la instancia correcta usando un factory
        Animal newAnimal;
        switch (type.toLowerCase()) {
            case "pinguino":
                newAnimal = new Pinguino();
                break;
            case "leon":
                newAnimal = new Leon();
                break;
            case "elephant":
                newAnimal = new Elephant();
                break;
            default:
                return ResponseEntity.badRequest().body("Tipo de animal no válido: " + type);
        }

        // Asigna los campos comunes desde el JSON
        newAnimal.setName((String) requestData.get("name"));
        newAnimal.setAge((Integer) requestData.get("age"));
        newAnimal.setSpecie((String) requestData.get("specie"));
        newAnimal.setAdoptable((Boolean) requestData.get("adoptable"));

        // Guarda el animal en el zoo
        theZoo.addAnimal(newAnimal);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(type + " creado con ID: " + newAnimal.getId());
    }


    public void zooOps() {

        System.out.println("Bienvenidos a " + theZoo.getName());

        //De la clase Animal creo un leon llamado "leon1" el cual es = Creo el nuevo animal utilizando la...
        //...clase llamada Leon y lleno los atributos alli establecidos.
        Animal leon1 = new Leon("Marco", 20, "felino", false);
        Animal leon2 = new Leon("Jose",12,"felino",false);
        Animal elephant1 = new Elephant("Dumbo",20,"mamifero",false);
        Animal elephant2 = new Elephant("Pancho", 22,"mamifero", false);
        Animal penguin1 = new Pinguino("Andrea",12,"ave",false);
        Animal penguin2 = new Pinguino("Camila",15,"ave",false);
        Animal leon3 = new Leon("Juan",6,"felino",false);

        //Aqui agrego el leon al zoologico utilizando la instruccion addAnimal, esta instruccion..
        //... trae por dentro el agregar al repositorio
        theZoo.addAnimal(leon1);
        theZoo.addAnimal(leon2);
        theZoo.addAnimal(elephant1);
        theZoo.addAnimal(elephant2);
        theZoo.addAnimal(penguin1);
        theZoo.addAnimal(penguin2);



        theZoo.printAnimalsDetails();

        /*
        //Con esto actualizamos el nombre del animal.
        Animal retrievedAnimal = theZoo.getAnimalById(leon1.getId());
        retrievedAnimal.setName("Marcolino");
        theZoo.updateAnimal(retrievedAnimal);

        theZoo.deleteAnimal(penguin1);//Elimina el objeto de la lista junto con el id.

        theZoo.printAnimalsDetails();

        theZoo.addAnimal(leon3);
        theZoo.printAnimalsDetails();

         */


    }
}
