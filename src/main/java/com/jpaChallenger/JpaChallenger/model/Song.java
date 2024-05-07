package com.jpaChallenger.JpaChallenger.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cancion")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double duration;
    private String album;
    @ManyToOne
    private Singer singer;

    public Song() {
    }

    public Song(String album, Double duration, String name) {
        this.album = album;
        this.duration = duration;
        this.name = name;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Canciones" + "\n" +
                "Nombre de la cancion" + name + "\n"+
                "Duracion: " + duration + "\n"+
                "Album: " + album;

    }
}
