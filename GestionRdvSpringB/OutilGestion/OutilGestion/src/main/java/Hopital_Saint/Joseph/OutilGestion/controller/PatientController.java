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

import Hopital_Saint.Joseph.OutilGestion.models.Patient;
import Hopital_Saint.Joseph.OutilGestion.service.PatientService;

@RestController
@RequestMapping(path = "/api/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Patient>> getPatients() {
		try {
			List<Patient> patients = patientService.getPatients();
			return new ResponseEntity<>(patients, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient  patient) {
		try {
			return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{idSecu}")
	public ResponseEntity<Patient> getPatientByID(@PathVariable Long idSecu) {
		try {
			Patient _patient = patientService.getPatientByID(idSecu);
			if(_patient != null) {
				return new ResponseEntity<Patient>(_patient, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{idSecu}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long idSecu, @RequestBody Patient patient) {
		try {
			return new ResponseEntity<Patient>(patientService.updatePatient(idSecu, patient), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{idSecu}")
	public void deleteByID(@PathVariable Long idSecu) {
		patientService.deleteByID(idSecu);
	}
	
	@DeleteMapping(path = "/")
	public void deletePatients() {
		patientService.deletePatients();
	}

}
