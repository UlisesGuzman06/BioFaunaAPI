package com.biofauna.repository;

import com.biofauna.model.Animal;
import com.biofauna.model.EstadoConservacion; // importá el enum
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByTipo(String tipo);

    List<Animal> findByNivelTrofico(String nivelTrofico);

    List<Animal> findByEstadoConservacion(EstadoConservacion estadoConservacion);

}
