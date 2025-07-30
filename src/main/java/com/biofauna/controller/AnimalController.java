package com.biofauna.controller;

import com.biofauna.model.Animal;
import com.biofauna.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animales")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        return animalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animalDetails) {
        return animalService.findById(id)
                .map(animal -> {
                    animal.setNombreComun(animalDetails.getNombreComun());
                    animal.setNombreCientifico(animalDetails.getNombreCientifico());
                    animal.setDescripcion(animalDetails.getDescripcion());
                    animal.setNivelTrofico(animalDetails.getNivelTrofico());
                    animal.setTipo(animalDetails.getTipo());
                    animal.setEstadoConservacion(animalDetails.getEstadoConservacion());
                    // actualizá más campos si agregaste otros
                    Animal updated = animalService.save(animal);
                    return ResponseEntity.ok(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        if (animalService.findById(id).isPresent()) {
            animalService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}