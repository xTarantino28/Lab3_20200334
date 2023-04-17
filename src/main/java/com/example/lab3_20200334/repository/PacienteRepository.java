package com.example.lab3_20200334.repository;


import com.example.lab3_20200334.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    @Query(value = "Select p.id, p.nombre, p.edad, p.genero, p.diagnostico, p.fecha_cita, p.numero_habitacion, p.doctor_id from paciente p inner join doctor d on p.doctor_id = d.id where d.id = ?1",nativeQuery = true)
    List<Paciente> buscarPacientesPorIdDoctor(int id);

    @Query(nativeQuery = true, value = "Select p.id, p.nombre, p.edad, p.genero, p.diagnostico, p.fecha_cita, p.numero_habitacion, p.doctor_id from paciente p inner join doctor d on p.doctor_id = d.id where d.id = ?1 AND p.fecha_cita > current_date()")
    List<Paciente> buscarlistaCitasPorDoctor(int id);

    @Query(nativeQuery = true, value = "Select p.id, p.nombre, p.edad, p.genero, p.diagnostico, p.fecha_cita, p.numero_habitacion, p.doctor_id from paciente p inner join hospital h on p.hospital_id = h.id where h.id = ?1")
    List<Paciente> buscarPacientesPorHospital(int id);

    Paciente findPacienteById(int id);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value ="UPDATE paciente set numero_habitacion = ?1 where id = ?2")
    void actualizarHabitacionPaciente(int numero_habitacion, int id);




    @Transactional
    @Modifying
    @Query(nativeQuery = true, value ="UPDATE paciente set doctor_id = ?1 where doctor_id = ?2")
    void actualizarDoctorPacientes(int destino, int origen);
}
