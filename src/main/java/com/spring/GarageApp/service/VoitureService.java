package com.spring.GarageApp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.GarageApp.dto.CreateVoiture;
import com.spring.GarageApp.model.Voiture;
import com.spring.GarageApp.repository.VoitureRepository;

import jakarta.transaction.Transactional;

@Service
public class VoitureService {

    private final VoitureRepository repository;

    @Autowired
	public VoitureService(VoitureRepository repository) {
		this.repository = repository;
	}

	public List<Voiture> findAllVoitures() {
		return repository.findAll();
	}

	public Voiture findVoitureById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Voiture create(CreateVoiture voiture) {
		// ici je suis dans la DTO
		//
		Voiture voitureACreer = new Voiture(
			voiture.getModele(),
			voiture.getMarque(),
			voiture.getPrix()
		);
		// je suis dans une entité
		return repository.save(voitureACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Voiture voitureASupprimer = findVoitureById(uuid);

        if (voitureASupprimer != null) {
            repository.delete(voitureASupprimer);
            return true; // La suppression a réussi
        } else {
            return false; // La voiture n'a pas été trouvée ou a déjà été supprimée
        }	
	}
}
