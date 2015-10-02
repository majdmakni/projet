package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int iddoctor;
	private String email;
	private String firstname;
	private String lastname;
	private int phone;
	private String speciality;
	private List<Connexion> connexions;
	private Institution institution;
	private List<Flightdoctor> flightdoctors;
	private List<Padoc> padocs;

	public Doctor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIddoctor() {
		return this.iddoctor;
	}

	public void setIddoctor(int iddoctor) {
		this.iddoctor = iddoctor;
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


	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	//bi-directional many-to-one association to Connexion
	@OneToMany(mappedBy="doctor")
	public List<Connexion> getConnexions() {
		return this.connexions;
	}

	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}

	public Connexion addConnexion(Connexion connexion) {
		getConnexions().add(connexion);
		connexion.setDoctor(this);

		return connexion;
	}

	public Connexion removeConnexion(Connexion connexion) {
		getConnexions().remove(connexion);
		connexion.setDoctor(null);

		return connexion;
	}


	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="idinstitution")
	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}


	//bi-directional many-to-one association to Flightdoctor
	@OneToMany(mappedBy="doctor")
	public List<Flightdoctor> getFlightdoctors() {
		return this.flightdoctors;
	}

	public void setFlightdoctors(List<Flightdoctor> flightdoctors) {
		this.flightdoctors = flightdoctors;
	}

	public Flightdoctor addFlightdoctor(Flightdoctor flightdoctor) {
		getFlightdoctors().add(flightdoctor);
		flightdoctor.setDoctor(this);

		return flightdoctor;
	}

	public Flightdoctor removeFlightdoctor(Flightdoctor flightdoctor) {
		getFlightdoctors().remove(flightdoctor);
		flightdoctor.setDoctor(null);

		return flightdoctor;
	}

	@OneToMany(mappedBy="doctor")
	public List<Padoc> getPadocs() {
		return padocs;
	}


	public void setPadocs(List<Padoc> padocs) {
		this.padocs = padocs;
	}


	

	
}