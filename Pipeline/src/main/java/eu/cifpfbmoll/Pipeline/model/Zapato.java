package eu.cifpfbmoll.Pipeline.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "zapatos")
@Data
public class Zapato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "precio")
    private double precio;

    @ManyToMany(mappedBy = "zapatos")
    @JsonIgnore
    private Set<Persona> personas;

    public Zapato() {}

    public Zapato(String marca) {
        this.setMarca(marca);
    }

    public Zapato(String marca, double precio) {
        this.setMarca(marca);
        this.setPrecio(precio);
    }
}
