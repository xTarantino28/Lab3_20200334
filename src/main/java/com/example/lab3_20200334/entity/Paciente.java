package com.example.lab3_20200334.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name ="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "genero")
    private String genero;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "fecha_cita")
    private Date fecha_cita;

    @Column(name = "numero_habitacion")
    private int numero_habitacion;

    @Column(name = "doctor_id")
    private int doctor_id;

}
