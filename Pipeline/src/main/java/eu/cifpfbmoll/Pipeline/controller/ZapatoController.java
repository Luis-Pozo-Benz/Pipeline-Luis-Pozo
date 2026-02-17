package eu.cifpfbmoll.Pipeline.controller;

import eu.cifpfbmoll.Pipeline.model.Zapato;
import eu.cifpfbmoll.Pipeline.service.ZapatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zapatos")
public class ZapatoController {

    private final ZapatoService zapatoService;

    public ZapatoController(ZapatoService zapatoService) {
        this.zapatoService = zapatoService;
    }

    @GetMapping
    public List<Zapato> getAllZapatos() {
        return zapatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zapato> getById(@PathVariable Long id) {
        final Zapato zapato = zapatoService.findById(id); // ← Persona o null
        if (zapato != null) {
            return ResponseEntity.ok(zapato);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Zapato> createZapato(@RequestBody Zapato zapato) {
        final Zapato saved = zapatoService.save(zapato);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZapato(@PathVariable Long id) {
        zapatoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
