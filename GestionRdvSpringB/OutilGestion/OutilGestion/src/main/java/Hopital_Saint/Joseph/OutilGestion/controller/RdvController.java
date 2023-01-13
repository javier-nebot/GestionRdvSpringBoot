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
import Hopital_Saint.Joseph.OutilGestion.models.Patient;
import Hopital_Saint.Joseph.OutilGestion.models.Rdv;
import Hopital_Saint.Joseph.OutilGestion.service.RdvService;

@RestController
@RequestMapping(path = "/api/rendezvous")
public class RdvController {
	
	@Autowired
	private RdvService rdvService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Rdv>> getRdvs() {
		
		try {
			List<Rdv> rdvs = rdvService.getRdvs();
			return new ResponseEntity<>(rdvs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Rdv> saveRdv(@RequestBody Rdv rdv) {
		try {
			return new ResponseEntity<>(rdvService.saveRdv(rdv), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Rdv>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{idRdv}")
	public ResponseEntity<Rdv> getRdvByID(@PathVariable Long idRdv) {
		try {
			Rdv _rdv = rdvService.getRdvByID(idRdv);
			if(_rdv != null) {
				return new ResponseEntity<>(_rdv, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{idRdv}")
	public ResponseEntity<Rdv> updateRdv(@PathVariable Long idRdv, @RequestBody Rdv rdv) {
		try {
			return new ResponseEntity<Rdv>(rdvService.updateRdv(idRdv, rdv), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/medecin")
	public ResponseEntity<List<Rdv>> getRdvByMedecin(@RequestBody Medecin medecin) {
		try {
			return new ResponseEntity<List<Rdv>>(rdvService.getRdvByMedecin(medecin), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(params = "/patient")
	public ResponseEntity<List<Rdv>> getRdvByPatient(@RequestBody Patient patient) {
		try {
			return new ResponseEntity<List<Rdv>>(rdvService.getRdvByPatient(patient), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{idRdv}")
	public void deleteByID(@PathVariable Long idRdv) {
		rdvService.deleteByID(idRdv);
	}
	
	@DeleteMapping(path = "/")
	public void deleteRdvs() {
		rdvService.deleteRdvs();
	}

}
