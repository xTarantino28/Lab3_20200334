package com.example.lab3_20200334.controllers;


import com.example.lab3_20200334.entity.Hospital;
import com.example.lab3_20200334.entity.Paciente;
import com.example.lab3_20200334.repository.HospitalRepository;
import com.example.lab3_20200334.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PacienteController {

    final PacienteRepository pacienteRepository;
    public PacienteController (PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/paciente/listapaciente")
    public String mostrarListaHospital(Model model){
        List<Paciente> listaPaciente = pacienteRepository.findAll();
        model.addAttribute("listaPaciente",listaPaciente);
        return "listapaciente";
    }





}
