package com.jpaChallenger.JpaChallenger.repository;


import com.jpaChallenger.JpaChallenger.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Cantante,Long> {
}
