package Hopital_Saint.Joseph.OutilGestion.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Hopital_Saint.Joseph.OutilGestion.models.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Long>{
}
