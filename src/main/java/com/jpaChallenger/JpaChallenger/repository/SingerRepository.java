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
    List<Singer> findByMusicStyle(Style style);
    @Query("SELECT song FROM Singer s JOIN s.listSongs song WHERE s.name ILIKE %:singerName%")
    List<Song> findSongsBySinger(String singerName);
    @Query("SELECT song FROM Singer s JOIN s.listSongs song WHERE s.name ILIKE %:singer% AND song.album ILIKE %:album%")
    List<Song>findByAlbumAndSinger(String singer,String album);

}
