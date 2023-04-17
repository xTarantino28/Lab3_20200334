package com.example.lab3_20200334.repository;


import com.example.lab3_20200334.entity.Hospital;
import com.example.lab3_20200334.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

    @Query(value = "Select h.nombre from hospital h inner join doctor d on h.id = d.hospital_id ",nativeQuery = true)
    List<String> hospitalesDoctores();


    @Query(value = "Select h.nombre from hospital h inner join paciente p on h.id = p.hospital_id ",nativeQuery = true)
    List<String> hospitalesPacientes();
}
