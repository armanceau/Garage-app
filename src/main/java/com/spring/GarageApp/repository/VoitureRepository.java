package com.spring.GarageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.GarageApp.model.Voiture;
import java.util.List;
import java.util.Optional;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, String> {
    List<Voiture> findAll();

    Optional<Voiture> findOneByUuid(String uuid);

    Voiture save (Voiture voiture);

    void deleteByUuid(String uuid); 
}
