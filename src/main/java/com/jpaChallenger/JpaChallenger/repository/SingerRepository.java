package com.jpaChallenger.JpaChallenger.repository;


import com.jpaChallenger.JpaChallenger.model.Singer;
import com.jpaChallenger.JpaChallenger.model.Song;
import com.jpaChallenger.JpaChallenger.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SingerRepository extends JpaRepository<Singer,Long> {

    Optional<Singer>findByName(String nombre);
    List<Singer>findByStyle(Style style);
    @Query("SELECT song FROM Singer s JOIN s.listSongs song WHERE song.name ILIKE %:songName%")
    List<Song> findSongsBySinger(String songName);
    /*@Query(value = "SELECT * FROM cantante c WHERE c.musicStyle ",nativeQuery = true)
    List<Song>findSongsByStyle();*/
}
