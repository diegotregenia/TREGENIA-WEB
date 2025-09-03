package org.example.tregeniaweb.controller;

import jakarta.validation.Valid;
import org.example.tregeniaweb.model.Suscripcion;
import org.example.tregeniaweb.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class SuscripcionController {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @GetMapping("/suscripciones")
    public String listarSuscripciones(Model model) {
        List<Suscripcion> lista = suscripcionRepository.findAll();
        model.addAttribute("suscripciones", lista);
        return "lista";
    }

    @GetMapping("/suscribirse")
    public String mostrarFormulario(Model model) {
        model.addAttribute("suscripcion", new Suscripcion());
        return "suscripcion";
    }

    @PostMapping("/suscribirse")
    public String guardarSuscripcion(@Valid @ModelAttribute("suscripcion") Suscripcion suscripcion,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            return "suscripcion";
        }

        suscripcion.setFechaSuscripcion(LocalDateTime.now());
        suscripcionRepository.save(suscripcion);
        model.addAttribute("exito", "Gracias por suscribirte. Te mantendremos informado con nuestras novedades.");
        return "suscripcion";
    }
}
