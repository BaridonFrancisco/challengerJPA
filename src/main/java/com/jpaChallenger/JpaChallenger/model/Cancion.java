package com.jpaChallenger.JpaChallenger.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double duration;
    @ManyToOne
    private Album album;

    public Cancion() {
    }
}
