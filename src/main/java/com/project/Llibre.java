package com.project;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Llibre", uniqueConstraints = { @UniqueConstraint(columnNames = "llibreId") })
public class Llibre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "llibreId", unique = true, nullable = false)
    private long llibreId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "editoral")
    private String editoral;

    @ManyToOne
    @JoinColumn(name = "autorId", insertable = false, updatable = false)
    private Autor autor;

    @ManyToMany(mappedBy = "llibres")
    private Set<Biblioteca> biblioteques;

    @ManyToMany(mappedBy = "llibres")
    private Set<Persona> persones;

    public Llibre() {
    };

    public Llibre(String nom, String editoral) {
        this.nom = nom;
        this.editoral = editoral;
    }

    public long getLlibreId() {
        return llibreId;
    }

    public void setLlibreId(long llibreId) {
        this.llibreId = llibreId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEditoral() {
        return editoral;
    }

    public void setEditoral(String editoral) {
        this.editoral = editoral;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return llibreId + ": " + nom + ", " + editoral;
    }
}
