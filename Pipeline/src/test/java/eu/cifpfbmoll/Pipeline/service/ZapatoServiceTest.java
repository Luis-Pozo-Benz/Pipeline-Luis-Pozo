package eu.cifpfbmoll.Pipeline.service;

import eu.cifpfbmoll.Pipeline.model.Zapato;
import eu.cifpfbmoll.Pipeline.repository.ZapatoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZapatoServiceTest {

    @Mock
    private ZapatoRepository zapatoRepository;
    @InjectMocks
    private ZapatoService zapatoService;

    @Test
    void findAll_ReturnsAllPersonas() {
        Zapato z1 = new Zapato();
        z1.setMarca("Nike");
        when(zapatoRepository.findAll()).thenReturn(List.of(z1));

        List<Zapato> result = zapatoService.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getMarca()).isEqualTo("Nike");
        verify(zapatoRepository).findAll();
    }

    @Test
    void findById_Exists_ReturnsZapato() {
        // Arrange
        Zapato z = new Zapato();
        z.setMarca("Sneakers");
        when(zapatoRepository.findById(1L)).thenReturn(Optional.of(z));

        // Act
        Zapato result = zapatoService.findById(1L); // ← Tu service unwrap Optional

        // Assert
        assertThat(result).isNotNull(); // ← NO result.getNombre() si puede ser null
        assertThat(result.getMarca()).isEqualTo("Sneakers");
        verify(zapatoRepository).findById(1L);
    }

    @Test
    void findById_NotExists_ReturnsNull() {
        when(zapatoRepository.findById(999L)).thenReturn(Optional.empty());

        Zapato result = zapatoService.findById(999L);

        assertThat(result).isNull();
        verify(zapatoRepository).findById(999L);
    }

    @Test
    void save_ValidPersona_CallsRepository() {
        Zapato z = new Zapato();
        z.setMarca("Jordan");
        when(zapatoRepository.save(any())).thenReturn(z);

        Zapato result = zapatoService.save(z);

        assertThat(result.getMarca()).isEqualTo("Jordan");
        verify(zapatoRepository).save(z);
    }

    @Test
    void deleteById_CallsRepository() {
        zapatoService.deleteById(1L);
        verify(zapatoRepository).deleteById(1L);
    }
}
