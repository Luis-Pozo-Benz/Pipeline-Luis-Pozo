package eu.cifpfbmoll.Pipeline.repository;

import eu.cifpfbmoll.Pipeline.model.Persona;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class PersonaRepositoryTest {

    // @Autowired
    // private PersonaRepository personaRepository;

    // @BeforeEach
    // void cleanDb() {
    //     personaRepository.deleteAll(); // ← deja la tabla limpia para el test
    // }

    // @Test
    // void saveAndFindById() {
    //     Persona p = new Persona();
    //     p.setNombre("Luis Test");
    //     Persona saved = personaRepository.save(p);

    //     Persona found = personaRepository.findById(saved.getId()).orElse(null);
    //     assertThat(found.getNombre()).isEqualTo("Luis Test");
    // }

    // @Test
    // void findAll_ReturnsList() {
    //     personaRepository.save(new Persona("Test1"));
    //     personaRepository.save(new Persona("Test2"));

    //     assertThat(personaRepository.findAll()).hasSize(2);
    // }

    // @Test
    // void deleteById_RemovesEntity() {
    //     Persona p = personaRepository.save(new Persona("Eliminar"));

    //     personaRepository.deleteById(p.getId());

    //     assertThat(personaRepository.findById(p.getId())).isEmpty();
    // }

    // @Test
    // void countEntities() {
    //     long initialCount = personaRepository.count();
    //     personaRepository.save(new Persona("Count Test"));

    //     assertThat(personaRepository.count()).isEqualTo(initialCount + 1);
    // }
}
