package Hopital_Saint.Joseph.OutilGestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hopital_Saint.Joseph.OutilGestion.DAO.MedecinDAO;
import Hopital_Saint.Joseph.OutilGestion.models.Medecin;

@Service
public class MedecinServiceImpl implements MedecinService {

	@Autowired
	private MedecinDAO medecinDAO;
	
	@Override
	public List<Medecin> getMedecins() {
		
		List<Medecin> MEDECINS = (List<Medecin>) medecinDAO.findAll();
		if(!MEDECINS.isEmpty()) {
			return MEDECINS;
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public List<Medecin> getBySpecialite(String specialite) {
		List<Medecin> medecins = medecinDAO.findBySpecialite(specialite);
		if(!medecins.isEmpty()) {
			return medecins;
		}
		return null;
	}

	@Override
	public Medecin saveMedecin(Medecin medecin) {
		
		Medecin _medecin = new Medecin();
		_medecin.setPrenom(medecin.getPrenom());
		_medecin.setNom(medecin.getNom());
		_medecin.setSpecialite(medecin.getSpecialite());
		medecinDAO.save(_medecin);
		
		return _medecin;
	}

	@Override
	public Medecin getMedecinByID(Long idMedecin) {
		
		Optional<Medecin> retrievedMedecin = medecinDAO.findById(idMedecin);
		if(retrievedMedecin.isPresent()) {
			return retrievedMedecin.get();
		}
		else {
			return null;
		}
	}

	@Override
	public Medecin updateMedecin(Long idMedecin, Medecin medecin) {
		
		Optional<Medecin> retrievedMedecin = medecinDAO.findById(idMedecin);
		
		Medecin _medecin = retrievedMedecin.get();
		
		_medecin.setPrenom(medecin.getPrenom());
		_medecin.setNom(medecin.getNom());
		_medecin.setSpecialite(medecin.getSpecialite());
		medecinDAO.save(_medecin);
		
		return _medecin;
	}

	@Override
	public void deleteByID(Long idMedecin) {
		medecinDAO.deleteById(idMedecin);
	}

	@Override
	public void deleteMedecins() {
		medecinDAO.deleteAll();
	}

}
