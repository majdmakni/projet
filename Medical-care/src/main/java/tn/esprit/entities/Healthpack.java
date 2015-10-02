package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the healthpack database table.
 * 
 */
@Entity
@NamedQuery(name="Healthpack.findAll", query="SELECT h FROM Healthpack h")
public class Healthpack implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idhealthpack;
	private double discount;
	private double totalprice;
	private String type;
	private List<Activities> activities;
	private Hospitalization hospitalization;
	private Hotel hotel;

	public Healthpack() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdhealthpack() {
		return this.idhealthpack;
	}

	public void setIdhealthpack(int idhealthpack) {
		this.idhealthpack = idhealthpack;
	}


	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="healthpack")
	public List<Activities> getActivities() {
		return this.activities;
	}

	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}

	public void addActivity(Activities activity) {
		getActivities().add(activity);
	}

	public void removeActivity(Activities activity) {
		getActivities().remove(activity);
	}


	//bi-directional many-to-one association to Hospitalization
	@ManyToOne
	@JoinColumn(name="idhospitalization")
	public Hospitalization getHospitalization() {
		return this.hospitalization;
	}

	public void setHospitalization(Hospitalization hospitalization) {
		this.hospitalization = hospitalization;
	}


	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="idhotel")
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}