package Hopital_Saint.Joseph.OutilGestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hopital_Saint.Joseph.OutilGestion.DAO.RdvDAO;
import Hopital_Saint.Joseph.OutilGestion.models.Medecin;
import Hopital_Saint.Joseph.OutilGestion.models.Patient;
import Hopital_Saint.Joseph.OutilGestion.models.Rdv;

@Service
public class RdvServiceImpl implements RdvService {

	@Autowired
	private RdvDAO rdvDAO;
	
	@Override
	public List<Rdv> getRdvs() {
		
		List<Rdv> RDVS = (List<Rdv>) rdvDAO.findAll();
		if(!RDVS.isEmpty()) {
			return RDVS;
		}
		return null;
	}

	@Override
	public Rdv saveRdv(Rdv rdv) {
		
		Rdv _rdv = new Rdv();
		_rdv.setDateRdv(rdv.getDateRdv());
		_rdv.setMedecin(rdv.getMedecin());
		_rdv.setPatient(rdv.getPatient());
		rdvDAO.save(_rdv);
		
		return _rdv;
	}

	@Override
	public Rdv getRdvByID(Long idRdv) {

		Optional<Rdv> retrievedRdv = rdvDAO.findById(idRdv);
		if(retrievedRdv.isPresent()) {
			return retrievedRdv.get();
		}
		return null;
	}

	@Override
	public Rdv updateRdv(Long idRdv, Rdv rdv) {
		
		Optional<Rdv> retrievedRdv = rdvDAO.findById(idRdv);
		
		Rdv _rdv = retrievedRdv.get();
		_rdv.setDateRdv(rdv.getDateRdv());
		_rdv.setMedecin(rdv.getMedecin());
		_rdv.setPatient(rdv.getPatient());
		
		rdvDAO.save(_rdv);
		
		return _rdv;
	}

	@Override
	public void deleteByID(Long idRdv) {
		rdvDAO.deleteById(idRdv);		
	}

	@Override
	public void deleteRdvs() {
		rdvDAO.deleteAll();		
	}

	@Override
	public List<Rdv> getRdvByMedecin(Medecin medecin) {
		List<Rdv> rdvs = rdvDAO.findByMedecin(medecin);
		if(!rdvs.isEmpty()) {
			return rdvs;
		}
		return null;
	}

	@Override
	public List<Rdv> getRdvByPatient(Patient patient) {
		List<Rdv> rdvs = rdvDAO.findByPatient(patient);
		if(!rdvs.isEmpty()) {
			return rdvs;
		}
		return null;
	}


}
