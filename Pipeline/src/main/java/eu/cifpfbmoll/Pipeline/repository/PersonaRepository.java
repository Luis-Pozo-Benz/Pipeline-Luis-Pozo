package eu.cifpfbmoll.Pipeline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.cifpfbmoll.Pipeline.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByNombreContainingIgnoreCase(String nombre);   
}
