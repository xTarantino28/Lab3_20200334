package com.example.lab3_20200334.repository;


import com.example.lab3_20200334.entity.Doctor;
import com.example.lab3_20200334.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query(value = "SELECT d.id, d.nombre, d.especialidad, d.hospital_id FROM hospital_db.doctor d inner join hospital h on h.id = d.hospital_id where h.id = ?1",nativeQuery = true)
    List<Doctor> buscarDoctoresPorHospital(int idHospital);


    @Query(value = "Select d.nombre from doctor d inner join paciente p on p.doctor_id = d.id ",nativeQuery = true)
    List<String> doctoresPacientes();




}
