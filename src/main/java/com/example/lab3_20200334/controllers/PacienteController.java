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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@Controller
public class PacienteController {

    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;

    final HospitalRepository hospitalRepository;
    public PacienteController (DoctorRepository doctorRepository, PacienteRepository pacienteRepository,HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/paciente/listapaciente")
    public String mostrarListaHospital(Model model){
        List<Paciente> listaPaciente = pacienteRepository.findAll();
        List<String> listaDoctores = doctorRepository.doctoresPacientes();
        List<String> listaHospitales = hospitalRepository.hospitalesPacientes();
        model.addAttribute("listaDoctores",listaDoctores);
        model.addAttribute("listaHospitales",listaHospitales);
        model.addAttribute("listaPaciente",listaPaciente);
        return "listapaciente";
    }

    @PostMapping("/guardarPacienteHabitacion")
    public String guardarPacienteHabitacion(@RequestParam("id") int id,
                                   @RequestParam("numero_habitacion") int numero_habitacion ){
        System.out.println(id);
        System.out.println(numero_habitacion);
        pacienteRepository.actualizarHabitacionPaciente(numero_habitacion,id);
        return "redirect:/paciente/listapaciente";
    }

    @GetMapping("/paciente/editarPaciente")
    public String formEditarPaciente(Model model, @RequestParam("id") int idpaciente ){


        Optional<Paciente> optPaciente = pacienteRepository.findById(idpaciente);

        if (optPaciente.isPresent()) {
            Paciente paciente = optPaciente.get();
            model.addAttribute("paciente",paciente);
            return "editarPaciente";
        } else {
            return "redirect:/paciente/listapaciente";
        }

    }

    /*
    @GetMapping("/paciente/derivarPaciente")
    public String formDerivarPaciente(Model model, @RequestParam("id") int idpaciente ){
        Paciente paciente = pacienteRepository.findPacienteById(idpaciente);
        model.addAttribute("paciente",paciente);
        return "derivarPaciente";
    }*/

    @GetMapping("/paciente/derivarPaciente")
    public String formDerivarPaciente( Model model){
        List<Doctor> listaDoctores = doctorRepository.findAll();
        model.addAttribute("listaDoctores",listaDoctores);
        return "derivarPaciente";
    }

    @PostMapping("/derivarPaciente")
    public String guardarDerivarPaciente(@RequestParam("id_doctor_origen") int id_doctor_origen, @RequestParam("id_doctor_destino") int id_doctor_destino ){
        pacienteRepository.actualizarDoctorPacientes(id_doctor_destino,id_doctor_origen);
        return "redirect:/paciente/listapaciente";
    }


}
