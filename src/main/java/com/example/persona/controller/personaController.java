package com.example.persona.controller;

import com.example.persona.domain.Persona;
import com.example.persona.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona/")
@CrossOrigin(origins = "*")
public class personaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaService.createPersona(persona);
    }

    @GetMapping
    public Iterable<Persona> getPersona() {
        return personaService.getPersona();
    }

    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable("id") String id){
        personaService.deletePersonaById(id);
        return "Se ha borrado la persona de la base de datos";
    }

    @GetMapping("/{name}")
    public Boolean nameValidator(@PathVariable("name") String name) {
        return personaService.nameValidator(name);
    }
}
