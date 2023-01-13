package Hopital_Saint.Joseph.OutilGestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Hopital_Saint.Joseph.OutilGestion.DAO.PatientDAO;
import Hopital_Saint.Joseph.OutilGestion.models.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	public List<Patient> getPatients() {
		
		List<Patient> patients = (List<Patient>) patientDAO.findAll();
		if(!patients.isEmpty()) {
			return patients;
		}
		return null;
	}

	@Override
	public Patient savePatient(Patient patient) {
		
		Patient _patient = new Patient();
		_patient.setPrenom(patient.getPrenom());
		_patient.setNom(patient.getNom());
		patientDAO.save(_patient);
		
		return _patient;
	}

	@Override
	public Patient getPatientByID(Long idSecu) {
		
		Optional<Patient> patient = patientDAO.findById(idSecu);
		if(patient.isPresent()) {
			return patient.get();
		}
		return null;
	}

	@Override
	public Patient updatePatient(Long idSecu, Patient patient) {
		
		Optional<Patient> retrievedPatient = patientDAO.findById(idSecu);
		
		Patient _patient = retrievedPatient.get();
		_patient.setPrenom(patient.getPrenom());
		_patient.setNom(patient.getNom());
		
		patientDAO.save(_patient);
				
		return _patient;
	}

	@Override
	public void deleteByID(Long idSecu) {
		patientDAO.deleteById(idSecu);		
	}

	@Override
	public void deletePatients() {
		patientDAO.deleteAll();		
	}

}
