package com.pruebas.dao;

import com.pruebas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface PersonaDAO extends JpaRepository<Persona, Integer>{
}
