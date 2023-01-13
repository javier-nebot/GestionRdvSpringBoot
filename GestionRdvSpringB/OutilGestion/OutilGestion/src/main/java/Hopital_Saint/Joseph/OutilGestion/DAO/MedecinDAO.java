package Hopital_Saint.Joseph.OutilGestion.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Hopital_Saint.Joseph.OutilGestion.models.Medecin;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long>{
	
	List<Medecin> findBySpecialite(String Specialite);
}
