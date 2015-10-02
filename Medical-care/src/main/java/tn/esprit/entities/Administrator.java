package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the administrator database table.
 * 
 */
@Entity
@NamedQuery(name="Administrator.findAll", query="SELECT a FROM Administrator a")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idadministrator;
	private String email;
	private String firstname;
	private String lastname;
	private List<Connexion> connexions;

	public Administrator() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdadministrator() {
		return this.idadministrator;
	}

	public void setIdadministrator(int idadministrator) {
		this.idadministrator = idadministrator;
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


	//bi-directional many-to-one association to Connexion
	@OneToMany(mappedBy="administrator")
	public List<Connexion> getConnexions() {
		return this.connexions;
	}

	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}

	public Connexion addConnexion(Connexion connexion) {
		getConnexions().add(connexion);
		connexion.setAdministrator(this);

		return connexion;
	}

	public Connexion removeConnexion(Connexion connexion) {
		getConnexions().remove(connexion);
		connexion.setAdministrator(null);

		return connexion;
	}

}