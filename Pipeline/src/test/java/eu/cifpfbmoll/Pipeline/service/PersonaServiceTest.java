package eu.cifpfbmoll.Pipeline.service;

import eu.cifpfbmoll.Pipeline.model.Persona;
import eu.cifpfbmoll.Pipeline.repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {

    @Mock
    private PersonaRepository personaRepository;
    @InjectMocks
    private PersonaService personaService;

    @Test
    void findAll_ReturnsAllPersonas() {
        Persona p1 = new Persona();
        p1.setNombre("Luis");
        when(personaRepository.findAll()).thenReturn(List.of(p1));

        List<Persona> result = personaService.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNombre()).isEqualTo("Luis");
        verify(personaRepository).findAll();
    }

    @Test
    void findById_Exists_ReturnsPersona() {
        // Arrange
        Persona p = new Persona();
        p.setNombre("Ana");
        when(personaRepository.findById(1L)).thenReturn(Optional.of(p));

        // Act
        Persona result = personaService.findById(1L); // ← Tu service unwrap Optional

        // Assert
        assertThat(result).isNotNull(); // ← NO result.getNombre() si puede ser null
        assertThat(result.getNombre()).isEqualTo("Ana");
        verify(personaRepository).findById(1L);
    }

    @Test
    void findById_NotExists_ReturnsNull() {
        when(personaRepository.findById(999L)).thenReturn(Optional.empty());

        Persona result = personaService.findById(999L);

        assertThat(result).isNull();
        verify(personaRepository).findById(999L);
    }

    @Test
    void save_ValidPersona_CallsRepository() {
        Persona p = new Persona();
        p.setNombre("Pedro");
        when(personaRepository.save(any())).thenReturn(p);

        Persona result = personaService.save(p);

        assertThat(result.getNombre()).isEqualTo("Pedro");
        verify(personaRepository).save(p);
    }

    @Test
    void deleteById_CallsRepository() {
        personaService.deleteById(1L);
        verify(personaRepository).deleteById(1L);
    }

    @Test
    void findByNombre_ReturnsCorrectPersonas() {
        // Arrange
        Persona p1 = new Persona();
        p1.setNombre("Luis Pozo");
        when(personaRepository.findByNombreContainingIgnoreCase(anyString())) // ← anyString()
                .thenReturn(List.of(p1));

        // Act
        List<Persona> result = personaService.findByNombre("Luis"); // ← Llama con "Luis"

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNombre()).contains("Luis");
        verify(personaRepository).findByNombreContainingIgnoreCase("Luis");
    }

}
