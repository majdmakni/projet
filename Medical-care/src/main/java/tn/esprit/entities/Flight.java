package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the flight database table.
 * 
 */
@Entity
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idflight;
	private String airport;
	private String class_;
	private String company;
	private double cost;
	private Date datearrival;
	private Date datedeparture;
	private List<Patient> patients;

	public Flight() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdflight() {
		return this.idflight;
	}

	public void setIdflight(int idflight) {
		this.idflight = idflight;
	}


	public String getAirport() {
		return this.airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}


	@Column(name="class")
	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}


	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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


	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="flight")
	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setFlight(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setFlight(null);

		return patient;
	}

}