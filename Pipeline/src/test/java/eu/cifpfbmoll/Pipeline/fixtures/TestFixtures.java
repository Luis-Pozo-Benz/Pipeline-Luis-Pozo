package eu.cifpfbmoll.Pipeline.fixtures;

import eu.cifpfbmoll.Pipeline.model.Persona;
import eu.cifpfbmoll.Pipeline.model.Zapato;
import eu.cifpfbmoll.Pipeline.service.PersonaService;
import eu.cifpfbmoll.Pipeline.service.ZapatoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class TestFixtures {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ZapatoService zapatoService;

    @Test
    public void cargarFixtures() {
        Set<Zapato> zapatos = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            Zapato z = new Zapato("Marca" + i, 30 + i);
            zapatoService.save(z);
            zapatos.add(z);
        }

        for (int i = 1; i <= 10; i++) {
            Persona p = new Persona("Persona" + i, 38 + i);
            Set<Zapato> zapos = new HashSet<>();
            int count = 0;
            for (Zapato z : zapatos) {
                zapos.add(z);
                count++;
                if (count == 2) break;
            }
            p.setZapatos(zapos);
            personaService.save(p);
        }

        System.out.println("Fixtures cargadas correctamente!");
    }
}
