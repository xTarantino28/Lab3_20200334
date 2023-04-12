package com.example.lab3_20200334.controllers;

import com.example.lab3_20200334.entity.Doctor;;
import com.example.lab3_20200334.repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class DoctorController {
    final DoctorRepository doctorRepository;
   public DoctorController (DoctorRepository doctorRepository) {
       this.doctorRepository = doctorRepository;
   }


    @GetMapping("/doctor/listadoctor")
    public String mostrarListaHospital(Model model){
        List<Doctor> listaDoctor = doctorRepository.findAll();
        model.addAttribute("listaDoctor",listaDoctor);
        return "listadoctor";
    }
}
