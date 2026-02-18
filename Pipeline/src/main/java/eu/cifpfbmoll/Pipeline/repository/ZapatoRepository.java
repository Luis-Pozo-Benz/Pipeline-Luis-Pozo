package eu.cifpfbmoll.Pipeline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.cifpfbmoll.Pipeline.model.Zapato;

public interface ZapatoRepository extends JpaRepository<Zapato, Long> {

    List<Zapato> findByPrecioBetween(double min, double max);

}
