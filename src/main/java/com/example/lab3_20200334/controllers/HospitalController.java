package com.example.lab3_20200334.controllers;


import com.example.lab3_20200334.entity.Hospital;
import com.example.lab3_20200334.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping(value = {"/hospital" })
public class HospitalController {


    final HospitalRepository hospitalRepository;
    public HospitalController (HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }


    @GetMapping("/hospital/listahospital")
    public String mostrarListaHospital(Model model){
        List<Hospital> listaHospital = hospitalRepository.findAll();
        model.addAttribute("listaHospital",listaHospital);
        return "listahospital";
    }



}
