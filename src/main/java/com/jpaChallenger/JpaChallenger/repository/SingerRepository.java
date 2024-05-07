package com.jpaChallenger.JpaChallenger.repository;


import com.jpaChallenger.JpaChallenger.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SingerRepository extends JpaRepository<Singer,Long> {

    Optional<Singer>findByName(String nombre);
}
