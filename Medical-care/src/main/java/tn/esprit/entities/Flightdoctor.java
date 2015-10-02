package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the flightdoctor database table.
 * 
 */
@Entity
@NamedQuery(name="Flightdoctor.findAll", query="SELECT f FROM Flightdoctor f")
public class Flightdoctor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idflightdoctor;
	private String airport;
	private Date datearrival;
	private Date datedeparture;
	private Doctor doctor;
	private Patient patient;

	public Flightdoctor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdflightdoctor() {
		return this.idflightdoctor;
	}

	public void setIdflightdoctor(int idflightdoctor) {
		this.idflightdoctor = idflightdoctor;
	}


	public String getAirport() {
		return this.airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatearrival() {
		return this.datearrival;
	}

	public void setDatearrival(Date datearrival) {
		this.datearrival = datearrival;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedeparture() {
		return this.datedeparture;
	}

	public void setDatedeparture(Date datedeparture) {
		this.datedeparture = datedeparture;
	}


	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="iddoctor")
	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="idpatient")
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}