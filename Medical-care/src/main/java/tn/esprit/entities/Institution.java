package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the institution database table.
 * 
 */
@Entity
@NamedQuery(name="Institution.findAll", query="SELECT i FROM Institution i")
public class Institution implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idinstitution;
	private String address;
	private String email;
	private int phone;
	private List<Consultation> consultations;
	private List<Doctor> doctors;

	public Institution() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdinstitution() {
		return this.idinstitution;
	}

	public void setIdinstitution(int idinstitution) {
		this.idinstitution = idinstitution;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	//bi-directional many-to-one association to Consultation
	@OneToMany(mappedBy="institution")
	public List<Consultation> getConsultations() {
		return this.consultations;
	}

	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Consultation addConsultation(Consultation consultation) {
		getConsultations().add(consultation);
		consultation.setInstitution(this);

		return consultation;
	}

	public Consultation removeConsultation(Consultation consultation) {
		getConsultations().remove(consultation);
		consultation.setInstitution(null);

		return consultation;
	}


	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="institution")
	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setInstitution(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setInstitution(null);

		return doctor;
	}

}