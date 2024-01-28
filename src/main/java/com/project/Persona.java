package com.project;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Persona", uniqueConstraints = { @UniqueConstraint(columnNames = "personaId") })
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaId", unique = true, nullable = false)
    private long personaId;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nom")
    private String nom;

    @Column(name = "telefon")
    private String telefon;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "Llibre_Persona", joinColumns = {
            @JoinColumn(referencedColumnName = "personaId") }, inverseJoinColumns = {
                    @JoinColumn(referencedColumnName = "llibreId") })
    private Set<Llibre> llibres;

    public Persona() {
    };

    public Persona(String dni, String nom, String telefon) {
        this.nom = nom;
        this.dni = dni;
        this.telefon = telefon;
    }

    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return personaId + ": " + nom + ", " + telefon + ", Llibres:" + this.getLlibres();
    }

}
