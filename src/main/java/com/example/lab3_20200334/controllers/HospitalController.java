package com.example.lab3_20200334.controllers;


import com.example.lab3_20200334.entity.Doctor;
import com.example.lab3_20200334.entity.Hospital;
import com.example.lab3_20200334.entity.Paciente;
import com.example.lab3_20200334.repository.DoctorRepository;
import com.example.lab3_20200334.repository.HospitalRepository;
import com.example.lab3_20200334.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping(value = {"/hospital" })
public class HospitalController {


    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    final HospitalRepository hospitalRepository;
    public HospitalController (DoctorRepository doctorRepository, PacienteRepository pacienteRepository,HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.hospitalRepository = hospitalRepository;
    }


    @GetMapping(value ={"/hospital/listahospital","/"})
    public String mostrarListaHospital(Model model){
        List<Hospital> listaHospital = hospitalRepository.findAll();
        model.addAttribute("listaHospital",listaHospital);
        return "listahospital";
    }

    @GetMapping("/hospital/listaDoctoresPorHospital")
    public String listaPacientesPorDoctor(@RequestParam("id") int idHospital,
                                          Model model){
        List<Doctor> listaDoctoresPorHospital = doctorRepository.buscarDoctoresPorHospital(idHospital);
        model.addAttribute("listaDoctoresPorHospital",listaDoctoresPorHospital);
        return "listaDoctoresPorHospital";
    }

    @GetMapping("/hospital/listaPacientesPorHospital")
    public String listaPacientesPorHospital(@RequestParam("id") int idHospital,
                                          Model model){
        List<Paciente> listaPacientesPorHospital = pacienteRepository.buscarPacientesPorHospital(idHospital);
        model.addAttribute("listaPacientesPorHospital",listaPacientesPorHospital);
        return "listaPacientesPorHospital";
    }



}
