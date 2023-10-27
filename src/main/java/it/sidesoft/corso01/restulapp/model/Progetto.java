package it.sidesoft.corso01.restulapp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table( name = "progetto" )
public class Progetto {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titolo;

    @Column
    private String descrizione;
    //@OneToMany(mappedBy = "progetto", fetch = FetchType.LAZY)
    //private List<Persona> persone;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PROGETTO_PERSONA",joinColumns = @JoinColumn(name = "progetto_id"))
    private List<Persona> persone;
}

