package eu.cifpfbmoll.Pipeline.service;

import eu.cifpfbmoll.Pipeline.model.Persona;
import eu.cifpfbmoll.Pipeline.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    
    private PersonaRepository personaRepository;

    public Persona findById(Long id) {
        final Optional<Persona> optional = personaRepository.findById(id);
        return optional.orElse(null); // ← ESTO unwrap Optional → Persona o null
    }

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    public List<Persona> findByNombre(String nombre) {
        return personaRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
