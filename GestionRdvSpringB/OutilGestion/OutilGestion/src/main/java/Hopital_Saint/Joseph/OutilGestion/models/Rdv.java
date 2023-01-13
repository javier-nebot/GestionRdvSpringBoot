package Hopital_Saint.Joseph.OutilGestion.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rendezvous")
public class Rdv implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRdv;
	@Column(name = "dateTime")
	private LocalDateTime dateRdv;
	
	@ManyToOne
	@JoinColumn(name = "ID_MEDECIN")
	private Medecin medecin;
	
	@ManyToOne
	@JoinColumn(name = "ID_PATIENT")
	private Patient patient;
	
	
	// Constructor
	
	public Rdv() {
	}
	
	public Rdv(LocalDateTime dateRdv, Medecin medecin, Patient patient) {
		this.dateRdv = dateRdv;
		this.medecin = medecin;
		this.patient = patient;
	}
	

	// Getters and Setters
	
	public Long getIdRdv() {
		return idRdv;
	}

	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}

	public LocalDateTime getDateRdv() {
		return dateRdv;
	}
	
	public void setDateRdv(LocalDateTime dateRdv) {
		this.dateRdv = dateRdv;
	}
	
	public Medecin getMedecin() {
		return medecin;
	}
	
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	

}
