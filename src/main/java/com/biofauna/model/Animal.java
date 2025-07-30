package com.biofauna.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombreComun;

    @Column(nullable = false, unique = true)
    private String nombreCientifico;

    @Column(length = 10000)
    private String descripcion;

    private String nivelTrofico;

    private String tipo;

    private String habitat;

    private String dieta;

    private Integer promedioVida;

    private String tamañoPromedio;

    private String comportamiento;

    @Enumerated(EnumType.STRING)
    private EstadoConservacion estadoConservacion;
}
