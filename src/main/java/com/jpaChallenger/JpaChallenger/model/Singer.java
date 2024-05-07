package com.jpaChallenger.JpaChallenger.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "cantante")
public class Singer {
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
    @OneToMany(mappedBy = "singer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Song>listSongs=new ArrayList<>();

    public Singer() {
    }

    public Singer(String name, String lastName, Integer age, String city, LocalDate birthDate, String nationality, String musicStyle) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.musicStyle = musicStyle;
    }

    public List<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(List<Song> listSongs) {
        this.listSongs = listSongs;
    }

    public String getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(String musicStyle) {
        this.musicStyle = musicStyle;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addSong(Song c){
        this.listSongs.add(c);
    }




    @Override
    public String toString() {
        return 	"*****Singer*****\n"+
                " Nombre:" + name + "\n"+
                " Apellido: " + lastName + "\n"+
                " Edad: " + age + "\n"+
                " Ciudad: " + city + "\n"+
                " Fecha nacimiento: " + birthDate + "\n"+
                " Nacionalidad: " + nationality + "\n"+
                " Estilo musical:  " + musicStyle+"\n"+
                " Lista canciones\n" +this.listSongs.toString();
    }
}
