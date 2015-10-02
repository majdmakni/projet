package tn.esprit.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Padoc {
	private PadocPK padocPK;
	private Patient patient;
	private Doctor doctor;
	public Padoc() {
		// TODO Auto-generated constructor stub
	}
	@EmbeddedId
	public PadocPK getPadocPK() {
		return padocPK;
	}
	public void setPadocPK(PadocPK padocPK) {
		this.padocPK = padocPK;
	}
	@ManyToOne
	@JoinColumn(name="idpatient",referencedColumnName="idpatient",insertable=false,updatable=false)
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@ManyToOne
	@JoinColumn(name="iddoctor",referencedColumnName="iddoctor",insertable=false,updatable=false)
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	

}
