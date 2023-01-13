package Hopital_Saint.Joseph.OutilGestion.service;

import java.util.List;

import Hopital_Saint.Joseph.OutilGestion.models.Medecin;

public interface MedecinService {

	List<Medecin> getMedecins();
	
	List<Medecin> getBySpecialite(String specialite);
	
	Medecin saveMedecin(Medecin medecin);
	
	Medecin getMedecinByID(Long idMedecin);
	
	Medecin updateMedecin(Long idMedecin, Medecin medecin);
	
	void deleteByID(Long idMedecin);
	
	void deleteMedecins();
	
}
