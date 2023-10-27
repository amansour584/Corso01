package it.sidesoft.corso01.restulapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  it.sidesoft.corso01.restulapp.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Long> {
    List<Persona> findByNome(String nome);
    List<Persona> findByCognomeContainingIgnoreCase(String cognome);
}
