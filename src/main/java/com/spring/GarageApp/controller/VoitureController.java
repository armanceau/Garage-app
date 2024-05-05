package com.spring.GarageApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.GarageApp.dto.CreateVoiture;
import com.spring.GarageApp.model.Voiture;
import com.spring.GarageApp.service.VoitureService;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

    private final VoitureService service;

	@Autowired
	public VoitureController(VoitureService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Voiture>> findAll() {
		return new ResponseEntity<>(service.findAllVoitures(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Voiture> findOneById(@PathVariable String uuid) {
		Voiture voiture = service.findVoitureById(uuid);
		if(voiture != null) {
			return new ResponseEntity<>(service.findVoitureById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Voiture> save(@RequestBody CreateVoiture voiture) {
		Voiture createdVoiture = service.create(voiture);
		return new ResponseEntity<>(createdVoiture, HttpStatus.CREATED);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		boolean isDeleted = service.delete(uuid);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
