package com.example.lab3_20200334.controllers;

import com.example.lab3_20200334.entity.Doctor;
import com.example.lab3_20200334.entity.Paciente;
import com.example.lab3_20200334.repository.DoctorRepository;
import com.example.lab3_20200334.repository.HospitalRepository;
import com.example.lab3_20200334.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class DoctorController {
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    final HospitalRepository hospitalRepository;
    public DoctorController (DoctorRepository doctorRepository, PacienteRepository pacienteRepository,HospitalRepository hospitalRepository) {
       this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.hospitalRepository = hospitalRepository;
   }



    @GetMapping("/doctor/listadoctor")
    public String mostrarListaHospital(Model model){
        List<Doctor> listaDoctor = doctorRepository.findAll();
        List<String> listaHospitales = hospitalRepository.hospitalesDoctores();
        model.addAttribute("listaDoctor",listaDoctor);
        for (String h : listaHospitales) {
            System.out.println(h);
        }
        model.addAttribute("listaHospitales",listaHospitales);
        return "listadoctor";
    }

    @GetMapping("/doctor/listaPacientesPorDoctor")
    public String listaPacientesPorDoctor(@RequestParam("id") int id,
                                       Model model){

        List<Paciente> listaPacientesPorDoctor = pacienteRepository.buscarPacientesPorIdDoctor(id);
        model.addAttribute("listaPacientesPorDoctor",listaPacientesPorDoctor);
        return "listapacientespordoctor";
    }


    @GetMapping("/doctor/listaCitasPorDoctor")
    public String listaCitasPorDoctor(@RequestParam("id") int idDoctor,
                                          Model model){
        List<Paciente> listaCitasPorDoctor = pacienteRepository.buscarlistaCitasPorDoctor(idDoctor);
        model.addAttribute("listaPacientesPorDoctor",listaCitasPorDoctor);
        return "listacitaspendientesdoctor";
    }


}
