package com.pruebas.rest;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personas")
public class PersonaRest {

    private final PersonaDAO personaDAO;

    public PersonaRest(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    @PostMapping("/guardar")//localhost:8080/personas/guardar
    public void guardar(@RequestBody Persona persona){

        personaDAO.save(persona);
    }

    @GetMapping ("/listar")//localhost:8080/personas/listar
    public List<Persona> listar(){

        return personaDAO.findAll();
    }

    @DeleteMapping ("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){

        personaDAO.deleteById(id);
    }

    @PutMapping ("/actualizar")
    public void actualizar(@RequestBody Persona persona){

        personaDAO.save(persona);
    }
}
