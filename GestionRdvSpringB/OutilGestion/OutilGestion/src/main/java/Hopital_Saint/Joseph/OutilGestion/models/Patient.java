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
@Table(name = "Patient")
public class Patient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecu;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
	private Collection<Rdv> rdvs;
	
	
	// Constructors	
	
	public Patient() {
	}

	public Patient(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	
	// Getters and Setters
	
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


	public Long getIdSecu() {
		return idSecu;
	}

	public void setIdSecu(Long idSecu) {
		this.idSecu = idSecu;
	}

	public void setRdvs(Collection<Rdv> rdvs) {
		this.rdvs = rdvs;
	}
	
	
	@JsonIgnore
	public Collection<Rdv> getRdvs() {
		return rdvs;
	}
	
	
		
}
