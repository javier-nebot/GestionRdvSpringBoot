package Hopital_Saint.Joseph.OutilGestion.models;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medecin")
public class Medecin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedecin;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	@Column(name = "specialite")
	private String specialite;
	
	@OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
	private Collection<Rdv> rdvs;
	
	
	// Constructors
	
	public Medecin() {
	}
	
	public Medecin(String prenom, String nom, String specialite) {
		this.prenom = prenom;
		this.nom = nom;
		this.specialite = specialite;
	}
	
	
	//Setters and Getters
	public Long getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(Long idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	
	@JsonIgnore
	public Collection<Rdv> getRdvs() {
		return rdvs;
	}

	

	
	
	
	
}
