package org.example.tregeniaweb.controller;

import org.example.tregeniaweb.model.Contacto;
import org.example.tregeniaweb.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid; // <-- corregido

import java.time.LocalDateTime;

@Controller
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contacto";
    }

    @PostMapping("/contacto")
    public String guardarContacto(@ModelAttribute("contacto") @Valid Contacto contacto,
                                  BindingResult result,
                                  RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "contacto";
        }

        contacto.setFechaContacto(LocalDateTime.now());
        contactoRepository.save(contacto);
        redirectAttributes.addFlashAttribute("exito","¡Gracias por contactarnos! Hemos recibido tu mensaje correctamente.");
        return "redirect:/contacto";
    }
}
