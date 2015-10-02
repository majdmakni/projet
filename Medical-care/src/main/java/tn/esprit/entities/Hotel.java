package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idhotel;
	private String address;
	private double cost;
	private String email;
	private String name;
	private int phone;
	private int stars;
	private List<Healthpack> healthpacks;

	public Hotel() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdhotel() {
		return this.idhotel;
	}

	public void setIdhotel(int idhotel) {
		this.idhotel = idhotel;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	public int getStars() {
		return this.stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}


	//bi-directional many-to-one association to Healthpack
	@OneToMany(mappedBy="hotel")
	public List<Healthpack> getHealthpacks() {
		return this.healthpacks;
	}

	public void setHealthpacks(List<Healthpack> healthpacks) {
		this.healthpacks = healthpacks;
	}

	public Healthpack addHealthpack(Healthpack healthpack) {
		getHealthpacks().add(healthpack);
		healthpack.setHotel(this);

		return healthpack;
	}

	public Healthpack removeHealthpack(Healthpack healthpack) {
		getHealthpacks().remove(healthpack);
		healthpack.setHotel(null);

		return healthpack;
	}

}