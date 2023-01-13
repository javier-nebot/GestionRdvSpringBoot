package Hopital_Saint.Joseph.OutilGestion.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Hopital_Saint.Joseph.OutilGestion.models.Patient;
import Hopital_Saint.Joseph.OutilGestion.service.PatientService;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
	
	@InjectMocks
	private PatientController patientController;
	
	@Mock
	private PatientService patientService;
	
	@Test
	public void getPatients_withoutException() {
		
		//Given 
		List<Patient> list = new ArrayList<>();
		
		Patient firstPatient = new Patient();
		Patient secondPatient = new Patient();
		
		list.add(secondPatient);
		list.add(firstPatient);
		
		//When 
		Mockito.when(patientService.getPatients()).thenReturn(list);
		ResponseEntity<List<Patient>> resultat = patientController.getPatients();
		
		
		//Then 
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
		
	}
// public void getMedecinsByID
	
	@Test
	public void getPatientByID() throws Exception {
			
		//given
		Patient patient = new Patient();
			
		patient.setIdSecu(2L);
			
		//when
			
		Mockito.when(patientService.getPatientByID(2L)).thenReturn(patient);
		ResponseEntity<Patient> response =  patientController.getPatientByID(2L);
			
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
		
		
	@Test
	public void createPatient_WhitoutException() throws Exception {
			
		//given
		Patient patient = new Patient();
		patient.setIdSecu(3L);
		patient.setPrenom("Jean-Claude");
		patient.setNom("Gilles");
			
		//When
		Mockito.when(patientService.savePatient(patient)).thenReturn(patient);
		ResponseEntity<Patient> response = patientController.savePatient(patient);
			
		//Then
		assertThat(response.getBody().getIdSecu()).isGreaterThan(0);
			
	}
		
	@Test
	public void deletePatientByID() throws Exception {
			
		//given 
		Patient patient = new Patient();
		patient.setIdSecu(3L);
		patient.setPrenom("Jean-Claude");
		patient.setNom("Gilles");
			
		//When
		patientController.deleteByID(30L);
		ResponseEntity<Patient> retrievedPatient = patientController.getPatientByID(patient.getIdSecu());
			
		//Then
		assertThat(retrievedPatient.getBody()).isNull();
	}
		
	@Test
	public void deleteMedecins() throws Exception {
			
		Patient patient = new Patient();
		patient.setIdSecu(3L);
		patient.setPrenom("Jean-Claude");
		patient.setNom("Gilles");
		
		
		patientController.deletePatients();
		ResponseEntity<Patient> retrievedPatient = patientController.getPatientByID(patient.getIdSecu());
			
		//Then
		assertThat(retrievedPatient.getBody()).isNull();
		
			
	}
}
