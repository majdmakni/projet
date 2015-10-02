package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medicalrecord database table.
 * 
 */
@Entity
@NamedQuery(name="Medicalrecord.findAll", query="SELECT m FROM Medicalrecord m")
public class Medicalrecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idmedicalrecord;
	private String disease;
	private byte[] file;
	private String otherinformations;
	private String sanguingroup;
	private float weight;
	private Patient patientBean;

	public Medicalrecord() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdmedicalrecord() {
		return this.idmedicalrecord;
	}

	public void setIdmedicalrecord(int idmedicalrecord) {
		this.idmedicalrecord = idmedicalrecord;
	}


	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}


	@Lob
	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}


	public String getOtherinformations() {
		return this.otherinformations;
	}

	public void setOtherinformations(String otherinformations) {
		this.otherinformations = otherinformations;
	}


	public String getSanguingroup() {
		return this.sanguingroup;
	}

	public void setSanguingroup(String sanguingroup) {
		this.sanguingroup = sanguingroup;
	}


	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}


	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="patient")
	public Patient getPatientBean() {
		return this.patientBean;
	}

	public void setPatientBean(Patient patientBean) {
		this.patientBean = patientBean;
	}

}