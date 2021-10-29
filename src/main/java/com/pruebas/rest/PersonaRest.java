package com.pruebas.rest;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
@RequestMapping("personas")
public class PersonaRest {

    private final PersonaDAO personaDAO;

    public PersonaRest(PersonaDAO personaDAO) {

        this.personaDAO = personaDAO;
    }

    @PostMapping("/guardar") // localhost:8080/personas/guardar
    public void guardar(@RequestBody Persona persona) {

        personaDAO.save(persona);
    }

    @GetMapping("/listar") // localhost:8080/personas/listar
    public List<Persona> listar() {

        return personaDAO.findAll();
    }
    
    @GetMapping("/listar/{id}") // localhost:8080/personas/listar/1
    public Optional<Persona> obtenerProductoPorId(@PathVariable("id") Integer idproducto) {
        return personaDAO.findById(idproducto);
    }
    
    
    @DeleteMapping("/eliminar/{id}") // localhost:8080/personas/eliminar/1
    public void eliminar(@PathVariable("id") Integer id) {

        personaDAO.deleteById(id);
    }

    @PutMapping("/actualizar") // localhost:8080/personas/actualizar
    public void actualizar(@RequestBody Persona persona) {

        personaDAO.save(persona);
    }
}
