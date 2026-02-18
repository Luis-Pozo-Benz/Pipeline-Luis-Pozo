package eu.cifpfbmoll.Pipeline.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import eu.cifpfbmoll.Pipeline.service.PersonaService;
import eu.cifpfbmoll.Pipeline.model.Persona;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonaControllerTest {

    @Mock
    private PersonaService personaService;

    @InjectMocks
    private PersonaController personaController;

    @Test
    void getAllPersonas() {
        // Arrange
        when(personaService.findAll()).thenReturn(List.of(new Persona()));

        // Act - LLAMA AL MÉTODO DEL CONTROLLER
        personaController.getAllPersonas();

        // Assert
        verify(personaService).findAll();
    }

    @Test
    void getByIdExists() {
        // Arrange
        Persona persona = new Persona();
        persona.setNombre("Ana");
        when(personaService.findById(1L)).thenReturn(persona); // ← Persona (NO Optional)

        // Act
        personaController.getById(1L);

        // Assert
        verify(personaService).findById(1L);
    }

    @Test
    void getByIdNotFound() {
        when(personaService.findById(999L)).thenReturn(null); // ← null

        personaController.getById(999L);

        verify(personaService).findById(999L);
    }

    @Test
    void createPersona() {
        // Arrange
        Persona persona = new Persona();
        when(personaService.save(any())).thenReturn(persona);

        // Act - LLAMA AL MÉTODO
        personaController.createPersona(persona);

        // Assert
        verify(personaService).save(persona);
    }

    @Test
    void deletePersona() {
        // Act - LLAMA AL MÉTODO
        personaController.deletePersona(1L);

        // Assert
        verify(personaService).deleteById(1L);
    }
}
