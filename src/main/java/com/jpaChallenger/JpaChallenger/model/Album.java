package com.jpaChallenger.JpaChallenger.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate realeaseDate;
    @OneToMany(mappedBy = "album",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Cancion> songsList;
    @ManyToOne
    private Cantante cantante;

    public Album() {
    }
}
