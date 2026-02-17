package eu.cifpfbmoll.Pipeline.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "personas")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "talla_pie")
    private double talla_pie;

    @ManyToMany
    @JoinTable(
        name = "persona_zapato",
        joinColumns = @JoinColumn(name = "persona_id"),
        inverseJoinColumns = @JoinColumn(name = "zapato_id")
    )
    private Set<Zapato> zapatos;

    public Persona() {};
    public Persona(String nombre) {
        this.setNombre(nombre);
    };

    public Persona(String nombre, double talla_pie) {
        this.setNombre(nombre);
        this.setTalla_pie(talla_pie);
    };

}
