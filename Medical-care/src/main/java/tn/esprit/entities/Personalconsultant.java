package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the personalconsultant database table.
 * 
 */
@Entity
@NamedQuery(name="Personalconsultant.findAll", query="SELECT p FROM Personalconsultant p")
public class Personalconsultant implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPersonalconsultant;
	private String email;
	private String firstname;
	private String gender;
	private String lastname;
	private List<Connexion> connexions;
	private List<Patient> patients;

	public Personalconsultant() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdPersonalconsultant() {
		return this.idPersonalconsultant;
	}

	public void setIdPersonalconsultant(int idPersonalconsultant) {
		this.idPersonalconsultant = idPersonalconsultant;
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


	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	//bi-directional many-to-one association to Connexion
	@OneToMany(mappedBy="personalconsultant")
	public List<Connexion> getConnexions() {
		return this.connexions;
	}

	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}

	public Connexion addConnexion(Connexion connexion) {
		getConnexions().add(connexion);
		connexion.setPersonalconsultant(this);

		return connexion;
	}

	public Connexion removeConnexion(Connexion connexion) {
		getConnexions().remove(connexion);
		connexion.setPersonalconsultant(null);

		return connexion;
	}


	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="personalconsultant")
	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setPersonalconsultant(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setPersonalconsultant(null);

		return patient;
	}

}