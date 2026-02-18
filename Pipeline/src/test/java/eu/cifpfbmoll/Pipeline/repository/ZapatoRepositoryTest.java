package eu.cifpfbmoll.Pipeline.repository;

import eu.cifpfbmoll.Pipeline.model.Zapato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ZapatoRepositoryTest {

    @Autowired
    private ZapatoRepository zapatoRepository;

    @BeforeEach
    void cleanDb() {
        zapatoRepository.deleteAll();
    }

    @Test
    void saveAndFindById() {
        Zapato z = new Zapato();
        z.setMarca("Nike Test");
        Zapato saved = zapatoRepository.save(z);

        Zapato found = zapatoRepository.findById(saved.getId()).orElse(null);
        assertThat(found.getMarca()).isEqualTo("Nike Test");
    }

    @Test
    void findAll_ReturnsList() {
        zapatoRepository.save(new Zapato("Test1"));
        zapatoRepository.save(new Zapato("Test2"));

        assertThat(zapatoRepository.findAll()).hasSize(2);
    }

    @Test
    void deleteById_RemovesEntity() {
        Zapato z = zapatoRepository.save(new Zapato("Eliminar"));

        zapatoRepository.deleteById(z.getId());

        assertThat(zapatoRepository.findById(z.getId())).isEmpty();
    }

    @Test
    void countEntities() {
        long initialCount = zapatoRepository.count();
        zapatoRepository.save(new Zapato("Count Test"));

        assertThat(zapatoRepository.count()).isEqualTo(initialCount + 1);
    }

    @Test
    void findByPrecioBetween_ReturnsZapatosInRange() {
        // Arrange - zapatos con precios
        zapatoRepository.save(new Zapato("Nike", 100.0));
        zapatoRepository.save(new Zapato("Adidas", 80.0));
        zapatoRepository.save(new Zapato("Puma", 120.0)); // Fuera de rango

        // Act - buscar entre 80 y 110
        List<Zapato> result = zapatoRepository.findByPrecioBetween(75.0, 110.0);

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(Zapato::getMarca)
                .containsExactlyInAnyOrder("Nike", "Adidas");
    }

}
