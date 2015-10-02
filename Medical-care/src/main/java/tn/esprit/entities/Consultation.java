package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the consultation database table.
 * 
 */
@Entity
@NamedQuery(name="Consultation.findAll", query="SELECT c FROM Consultation c")
public class Consultation implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idconsultation;
	private double cost;
	private String intervention;
	private String treatement;
	private Patient patient;
	private Institution institution;
	private List<Hospitalization> hospitalizations;

	public Consultation() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdconsultation() {
		return this.idconsultation;
	}

	public void setIdconsultation(int idconsultation) {
		this.idconsultation = idconsultation;
	}


	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getIntervention() {
		return this.intervention;
	}

	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}


	public String getTreatement() {
		return this.treatement;
	}

	public void setTreatement(String treatement) {
		this.treatement = treatement;
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


	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="idinstitution")
	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}


	//bi-directional many-to-one association to Hospitalization
	@OneToMany(mappedBy="consultation")
	public List<Hospitalization> getHospitalizations() {
		return this.hospitalizations;
	}

	public void setHospitalizations(List<Hospitalization> hospitalizations) {
		this.hospitalizations = hospitalizations;
	}

	public Hospitalization addHospitalization(Hospitalization hospitalization) {
		getHospitalizations().add(hospitalization);
		hospitalization.setConsultation(this);

		return hospitalization;
	}

	public Hospitalization removeHospitalization(Hospitalization hospitalization) {
		getHospitalizations().remove(hospitalization);
		hospitalization.setConsultation(null);

		return hospitalization;
	}

}