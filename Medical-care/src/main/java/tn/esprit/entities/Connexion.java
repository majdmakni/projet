package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the connexion database table.
 * 
 */
@Entity
@NamedQuery(name="Connexion.findAll", query="SELECT c FROM Connexion c")
public class Connexion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idconnexion;
	private String password;
	private String type;
	private Administrator administrator;
	private Doctor doctor;
	private Patient patient;
	private Personalconsultant personalconsultant;

	public Connexion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdconnexion() {
		return this.idconnexion;
	}

	public void setIdconnexion(int idconnexion) {
		this.idconnexion = idconnexion;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-one association to Administrator
	@ManyToOne
	@JoinColumn(name="email",insertable=false,updatable=false,foreignKey = @ForeignKey(name = "mailadmin"))
	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}


	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="email",insertable=false,updatable=true,foreignKey = @ForeignKey(name = "maildoctor"))
	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="email",insertable=false,updatable=false,foreignKey = @ForeignKey(name = "mailpatient"))
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	//bi-directional many-to-one association to Personalconsultant
	@ManyToOne
	@JoinColumn(name="email",insertable=false,updatable=false,foreignKey = @ForeignKey(name = "mailpersonel"))
	public Personalconsultant getPersonalconsultant() {
		return this.personalconsultant;
	}

	public void setPersonalconsultant(Personalconsultant personalconsultant) {
		this.personalconsultant = personalconsultant;
	}

}