package Hopital_Saint.Joseph.OutilGestion.service;

import java.util.List;

import Hopital_Saint.Joseph.OutilGestion.models.Medecin;
import Hopital_Saint.Joseph.OutilGestion.models.Patient;
import Hopital_Saint.Joseph.OutilGestion.models.Rdv;

public interface RdvService {
	
	List<Rdv> getRdvs();
	
	Rdv saveRdv(Rdv rdv);
	
	Rdv getRdvByID(Long idRdv);
	
	Rdv updateRdv(Long idRdv, Rdv rdv);
	
	List<Rdv> getRdvByMedecin(Medecin medecin);
	
	List<Rdv> getRdvByPatient(Patient patient);
	
	void deleteByID(Long idRdv);
	
	void deleteRdvs();

}
