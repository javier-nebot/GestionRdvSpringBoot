package Hopital_Saint.Joseph.OutilGestion.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Hopital_Saint.Joseph.OutilGestion.models.Medecin;
import Hopital_Saint.Joseph.OutilGestion.models.Patient;
import Hopital_Saint.Joseph.OutilGestion.models.Rdv;

@Repository
public interface RdvDAO extends CrudRepository<Rdv, Long> {

	List<Rdv> findByMedecin(Medecin medecin);

	List<Rdv> findByPatient(Patient patient);
}
