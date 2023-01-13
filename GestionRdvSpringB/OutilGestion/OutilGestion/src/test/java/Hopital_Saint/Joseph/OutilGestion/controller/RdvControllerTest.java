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

import Hopital_Saint.Joseph.OutilGestion.models.Medecin;
import Hopital_Saint.Joseph.OutilGestion.models.Patient;
import Hopital_Saint.Joseph.OutilGestion.models.Rdv;
import Hopital_Saint.Joseph.OutilGestion.service.RdvService;

@RunWith(MockitoJUnitRunner.class)
public class RdvControllerTest {
	
	@InjectMocks
	private RdvController rdvController;
	
	@Mock
	private RdvService rdvService;
	
	@Test
	public void getRdvs_withoutException() {
		List<Rdv> list = new ArrayList<>();
		
		Rdv firstRdv = new Rdv();
		Rdv secondRdv = new Rdv();
		
		list.add(secondRdv);
		list.add(firstRdv);
		
		//When 
		Mockito.when(rdvService.getRdvs()).thenReturn(list);
		ResponseEntity<List<Rdv>> resultat = rdvController.getRdvs();
		
		
		//Then 
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
		
	}
	//public void getMedecinsByID
	
	@Test
	public void getRdvByID() throws Exception {
			
		//given
		Rdv rdv = new Rdv();
			
		rdv.setIdRdv(2L);
			
		//when
			
		Mockito.when(rdvService.getRdvByID(2L)).thenReturn(rdv);
		ResponseEntity<Rdv> response =  rdvController.getRdvByID(2L);
			
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
		
		
	@Test
	public void createRdv_WhitoutException() throws Exception {
			
		//given
		
		Medecin medecin = new Medecin();
		medecin.setIdMedecin(3L);
		medecin.setPrenom("Jean-Claude");
		medecin.setNom("Gilles");
		
		Patient patient = new Patient();
		patient.setIdSecu(3L);
		patient.setPrenom("Jean-Claude");
		patient.setNom("Gilles");
		
		Rdv rdv = new Rdv();
		rdv.setIdRdv(3L);
		rdv.setMedecin(medecin);
		rdv.setPatient(patient);
			
		//When
		Mockito.when(rdvService.saveRdv(rdv)).thenReturn(rdv);
		ResponseEntity<Rdv> response = rdvController.saveRdv(rdv);
			
		//Then
		assertThat(response.getBody().getIdRdv()).isGreaterThan(0);
			
	}
		
	@Test
	public void deleteRdvByID() throws Exception {
			
		//given 
		Medecin medecin = new Medecin();
		medecin.setIdMedecin(3L);
		medecin.setPrenom("Jean-Claude");
		medecin.setNom("Gilles");
		
		Patient patient = new Patient();
		patient.setIdSecu(3L);
		patient.setPrenom("Jean-Claude");
		patient.setNom("Gilles");
		
		Rdv rdv = new Rdv();
		rdv.setIdRdv(3L);
		rdv.setMedecin(medecin);
		rdv.setPatient(patient);
			
		//When
		rdvController.deleteByID(30L);
		ResponseEntity<Rdv> retrievedRdv = rdvController.getRdvByID(rdv.getIdRdv());
			
		//Then
		assertThat(retrievedRdv.getBody()).isNull();
	}
		
	@Test
	public void deleteRdvs() throws Exception {
			
		Medecin medecin = new Medecin();
		medecin.setIdMedecin(3L);
		medecin.setPrenom("Jean-Claude");
		medecin.setNom("Gilles");
		
		Patient patient = new Patient();
		patient.setIdSecu(3L);
		patient.setPrenom("Jean-Claude");
		patient.setNom("Gilles");
		
		Rdv rdv = new Rdv();
		rdv.setIdRdv(3L);
		rdv.setMedecin(medecin);
		rdv.setPatient(patient);
			
		rdvController.deleteRdvs();
		ResponseEntity<Rdv> retrievedRdv = rdvController.getRdvByID(rdv.getIdRdv());
			
		//Then
		assertThat(retrievedRdv.getBody()).isNull();
		
			
	}
}

