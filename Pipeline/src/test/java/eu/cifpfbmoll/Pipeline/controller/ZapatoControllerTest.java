package eu.cifpfbmoll.Pipeline.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import eu.cifpfbmoll.Pipeline.service.ZapatoService;
import eu.cifpfbmoll.Pipeline.model.Zapato;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ZapatoControllerTest {

    @Mock
    private ZapatoService zapatoService;

    @InjectMocks
    private ZapatoController zapatoController;

    @Test
    void getAllZapatos() {
        // Arrange
        when(zapatoService.findAll()).thenReturn(List.of(new Zapato()));

    //     // Act - LLAMA AL MÉTODO DEL CONTROLLER
    //     zapatoController.getAllZapatos();

    //     // Assert
    //     verify(zapatoService).findAll();
    // }

    // @Test
    // void getByIdExists() {
    //     // Arrange
    //     Zapato zapato = new Zapato();
    //     zapato.setMarca("Nike");
    //     when(zapatoService.findById(1L)).thenReturn(zapato); // ← Persona (NO Optional)

    //     // Act
    //     zapatoController.getById(1L);

    //     // Assert
    //     verify(zapatoService).findById(1L);
    // }

    // @Test
    // void getByIdNotFound() {
    //     when(zapatoService.findById(999L)).thenReturn(null); // ← null

    //     zapatoController.getById(999L);

    //     verify(zapatoService).findById(999L);
    // }

    // @Test
    // void createZapato() {
    //     // Arrange
    //     Zapato zapato = new Zapato();
    //     when(zapatoService.save(any())).thenReturn(zapato);

    //     // Act - LLAMA AL MÉTODO
    //     zapatoController.createZapato(zapato);

    //     // Assert
    //     verify(zapatoService).save(zapato);
    // }

    // @Test
    // void deleteZapato() {
    //     // Act - LLAMA AL MÉTODO
    //     zapatoController.deleteZapato(1L);

    //     // Assert
    //     verify(zapatoService).deleteById(1L);
    // }
}
