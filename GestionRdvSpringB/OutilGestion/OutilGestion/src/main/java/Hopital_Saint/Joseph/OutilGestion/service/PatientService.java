package Hopital_Saint.Joseph.OutilGestion.service;

import java.util.List;

import Hopital_Saint.Joseph.OutilGestion.models.Patient;

public interface PatientService {

	List<Patient> getPatients();
	
	Patient savePatient(Patient patient);
	
	Patient getPatientByID(Long idSecu);
	
	Patient updatePatient(Long idSecu, Patient patient);
	
	void deleteByID(Long idSecu);
	
	void deletePatients();
	
}
