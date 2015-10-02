package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the hospitalization database table.
 * 
 */
@Entity
@NamedQuery(name="Hospitalization.findAll", query="SELECT h FROM Hospitalization h")
public class Hospitalization implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idhospitalization;
	private Date dateIntervention;
	private Date releasedate;
	private byte state;
	private List<Healthpack> healthpacks;
	private Consultation consultation;

	public Hospitalization() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdhospitalization() {
		return this.idhospitalization;
	}

	public void setIdhospitalization(int idhospitalization) {
		this.idhospitalization = idhospitalization;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_intervention")
	public Date getDateIntervention() {
		return this.dateIntervention;
	}

	public void setDateIntervention(Date dateIntervention) {
		this.dateIntervention = dateIntervention;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}


	public byte getState() {
		return this.state;
	}

	public void setState(byte state) {
		this.state = state;
	}


	//bi-directional many-to-one association to Healthpack
	@OneToMany(mappedBy="hospitalization")
	public List<Healthpack> getHealthpacks() {
		return this.healthpacks;
	}

	public void setHealthpacks(List<Healthpack> healthpacks) {
		this.healthpacks = healthpacks;
	}

	public Healthpack addHealthpack(Healthpack healthpack) {
		getHealthpacks().add(healthpack);
		healthpack.setHospitalization(this);

		return healthpack;
	}

	public Healthpack removeHealthpack(Healthpack healthpack) {
		getHealthpacks().remove(healthpack);
		healthpack.setHospitalization(null);

		return healthpack;
	}


	//bi-directional many-to-one association to Consultation
	@ManyToOne
	@JoinColumn(name="idconsultation")
	public Consultation getConsultation() {
		return this.consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

}