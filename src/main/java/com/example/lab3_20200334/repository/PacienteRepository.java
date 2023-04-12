package com.example.lab3_20200334.repository;


import com.example.lab3_20200334.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

}
