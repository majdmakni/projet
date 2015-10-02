package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idpatient;
	private Date birthdate;
	private String country;
	private String email;
	private String firstname;
	private String gender;
	private int phone;
	private List<Connexion> connexions;
	private List<Consultation> consultations;
	private List<Flightdoctor> flightdoctors;
	private List<Medicalrecord> medicalrecords;
	private List<Padoc> padocs;
	private Personalconsultant personalconsultant;
	private Flight flight;

	public Patient() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdpatient() {
		return this.idpatient;
	}

	public void setIdpatient(int idpatient) {
		this.idpatient = idpatient;
	}


	@Temporal(TemporalType.DATE)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	//bi-directional many-to-one association to Connexion
	@OneToMany(mappedBy="patient")
	public List<Connexion> getConnexions() {
		return this.connexions;
	}

	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}

	public Connexion addConnexion(Connexion connexion) {
		getConnexions().add(connexion);
		connexion.setPatient(this);

		return connexion;
	}

	public Connexion removeConnexion(Connexion connexion) {
		getConnexions().remove(connexion);
		connexion.setPatient(null);

		return connexion;
	}


	//bi-directional many-to-one association to Consultation
	@OneToMany(mappedBy="patient")
	public List<Consultation> getConsultations() {
		return this.consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Consultation addConsultation(Consultation consultation) {
		getConsultations().add(consultation);
		consultation.setPatient(this);

		return consultation;
	}

	public Consultation removeConsultation(Consultation consultation) {
		getConsultations().remove(consultation);
		consultation.setPatient(null);

		return consultation;
	}


	//bi-directional many-to-one association to Flightdoctor
	@OneToMany(mappedBy="patient")
	public List<Flightdoctor> getFlightdoctors() {
		return this.flightdoctors;
	}

	public void setFlightdoctors(List<Flightdoctor> flightdoctors) {
		this.flightdoctors = flightdoctors;
	}

	public Flightdoctor addFlightdoctor(Flightdoctor flightdoctor) {
		getFlightdoctors().add(flightdoctor);
		flightdoctor.setPatient(this);

		return flightdoctor;
	}

	public Flightdoctor removeFlightdoctor(Flightdoctor flightdoctor) {
		getFlightdoctors().remove(flightdoctor);
		flightdoctor.setPatient(null);

		return flightdoctor;
	}


	//bi-directional many-to-one association to Medicalrecord
	@OneToMany(mappedBy="patientBean")
	public List<Medicalrecord> getMedicalrecords() {
		return this.medicalrecords;
	}

	public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}

	public Medicalrecord addMedicalrecord(Medicalrecord medicalrecord) {
		getMedicalrecords().add(medicalrecord);
		medicalrecord.setPatientBean(this);

		return medicalrecord;
	}

	public Medicalrecord removeMedicalrecord(Medicalrecord medicalrecord) {
		getMedicalrecords().remove(medicalrecord);
		medicalrecord.setPatientBean(null);

		return medicalrecord;
	}





	//bi-directional many-to-one association to Personalconsultant
	@ManyToOne
	@JoinColumn(name="idconsultant")
	public Personalconsultant getPersonalconsultant() {
		return this.personalconsultant;
	}

	public void setPersonalconsultant(Personalconsultant personalconsultant) {
		this.personalconsultant = personalconsultant;
	}


	//bi-directional many-to-one association to Flight
	@ManyToOne
	@JoinColumn(name="idflight")
	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@OneToMany(mappedBy="patient")
	public List<Padoc> getPadocs() {
		return padocs;
	}


	public void setPadocs(List<Padoc> padocs) {
		this.padocs = padocs;
	}

}