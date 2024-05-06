package com.jpaChallenger.JpaChallenger.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "cantante")
public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private Integer age;

    private String city;

    private LocalDate birthDate;

    private String nationality;

    private String musicStyle;
    @OneToMany(mappedBy = "cantante",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Album>albumsList;

    public Cantante() {
    }

    public Cantante(String name, String lastName, Integer age, String city, LocalDate birthDate, String nationality, String musicStyle) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.musicStyle = musicStyle;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", birthDate=" + birthDate +
                ", nationality='" + nationality + '\'' +
                ", musicStyle='" + musicStyle + '\'' +
                '}';
    }
}
