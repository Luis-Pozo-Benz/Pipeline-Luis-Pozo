package eu.cifpfbmoll.Pipeline.service;

import eu.cifpfbmoll.Pipeline.model.Zapato;
import eu.cifpfbmoll.Pipeline.repository.ZapatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZapatoService {

    @Autowired
    private ZapatoRepository zapatoRepository;

    public Zapato findById(Long id) {
        final Optional<Zapato> optional = zapatoRepository.findById(id);
        return optional.orElse(null); // ← ESTO unwrap Optional → Persona o null
    }

    public ZapatoService(ZapatoRepository zapatoRepository) {
        this.zapatoRepository = zapatoRepository;
    }

    public List<Zapato> findAll() {
        return zapatoRepository.findAll();
    }

    public Zapato save(Zapato zapato) {
        return zapatoRepository.save(zapato);
    }

    public void deleteById(Long id) {
        zapatoRepository.deleteById(id);
    }
}
