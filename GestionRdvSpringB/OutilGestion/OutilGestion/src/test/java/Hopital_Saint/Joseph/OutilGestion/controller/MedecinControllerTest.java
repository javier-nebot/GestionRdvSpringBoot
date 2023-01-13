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
import Hopital_Saint.Joseph.OutilGestion.service.MedecinService;

@RunWith(MockitoJUnitRunner.class)
public class MedecinControllerTest {
	
	@InjectMocks
	private MedecinController medecinController;
	
	@Mock
	private MedecinService medecinService;
	
	@Test
	public void getMedecins_withoutException() {
		
		//Given 
		List<Medecin> list = new ArrayList<>();
		
		Medecin firstMed = new Medecin();
		Medecin secondMed = new Medecin();
		
		list.add(secondMed);
		list.add(firstMed);
		
		//When 
		Mockito.when(medecinService.getMedecins()).thenReturn(list);
		ResponseEntity<List<Medecin>> resultat = medecinController.getMedecins();
		
		
		//Then 
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
		
	}
// public void getMedecinsByID
	
	@Test
	public void getMedecinByID() throws Exception {
			
		//given
		Medecin medecin = new Medecin();
			
		medecin.setIdMedecin(2L);
			
		//when
			
		Mockito.when(medecinService.getMedecinByID(2L)).thenReturn(medecin);
		ResponseEntity<Medecin> response =  medecinController.getMedecinByID(2L);
			
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
		
		
	@Test
	public void createMedecin_WhitoutException() throws Exception {
			
		//given
		Medecin medecin = new Medecin();
		medecin.setIdMedecin(3L);
		medecin.setPrenom("Jean-Claude");
		medecin.setNom("Gilles");
			
		//When
		Mockito.when(medecinService.saveMedecin(medecin)).thenReturn(medecin);
		ResponseEntity<Medecin> response = medecinController.saveMedecin(medecin);
			
		//Then
		assertThat(response.getBody().getIdMedecin()).isGreaterThan(0);
			
	}
		
	@Test
	public void deleteMedecinByID() throws Exception {
			
		//given 
		Medecin medecin = new Medecin();
		medecin.setIdMedecin(3L);
		medecin.setPrenom("Jean-Claude");
		medecin.setNom("Gilles");
			
		//When
		medecinController.deleteByID(30L);
		ResponseEntity<Medecin> retrievedMedecin = medecinController.getMedecinByID(medecin.getIdMedecin());
			
		//Then
		assertThat(retrievedMedecin.getBody()).isNull();
	}
		
	@Test
	public void deleteMedecins() throws Exception {
			
		Medecin medecin = new Medecin();
		medecin.setIdMedecin(3L);
		medecin.setPrenom("Jean-Claude");
		medecin.setNom("Gilles");
			
		medecinController.deleteMedecins();
		ResponseEntity<Medecin> retrievedBook = medecinController.getMedecinByID(medecin.getIdMedecin());
			
		//Then
		assertThat(retrievedBook.getBody()).isNull();
		
			
	}
}
