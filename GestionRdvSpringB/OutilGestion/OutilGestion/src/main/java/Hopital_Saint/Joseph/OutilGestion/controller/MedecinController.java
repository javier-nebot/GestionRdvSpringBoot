package Hopital_Saint.Joseph.OutilGestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hopital_Saint.Joseph.OutilGestion.models.Medecin;
import Hopital_Saint.Joseph.OutilGestion.service.MedecinService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/api/medecins")
public class MedecinController {
	
	@Autowired
	private MedecinService medecinService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Medecin>> getMedecins(){
		try {
			List<Medecin> medecins = medecinService.getMedecins();
			return new ResponseEntity<>(medecins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping(path = "/specialite")
	public ResponseEntity<List<Medecin>> getBySpecialite(@PathParam("specialite") String specialite) {
		try {
			return new ResponseEntity<List<Medecin>>(medecinService.getBySpecialite(specialite), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin) {
		try {
			return new ResponseEntity<>(medecinService.saveMedecin(medecin), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{idMedecin}")
	public ResponseEntity<Medecin> getMedecinByID(@PathVariable Long idMedecin) {
		try {
			Medecin _medecin = medecinService.getMedecinByID(idMedecin);
			if(_medecin != null) {
				return new ResponseEntity<Medecin>(_medecin, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping(path = "/{idMedecin}")
	public ResponseEntity<Medecin> updateMedecin(@PathVariable Long idMedecin, @RequestBody Medecin medecin) {
		try {
			return new ResponseEntity<Medecin>(medecinService.updateMedecin(idMedecin, medecin), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{idMedecin}")
	public void deleteByID(@PathVariable Long idMedecin) {
		medecinService.deleteByID(idMedecin);
	}
	
	@DeleteMapping(path = "/")
	public void deleteMedecins() {
		medecinService.deleteMedecins();
	}
	
	

}
