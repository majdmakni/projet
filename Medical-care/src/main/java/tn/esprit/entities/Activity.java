package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the activity database table.
 * 
 */
@Entity
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idactivity;
	private String address;
	private double cost;
	private Date date;
	private String institution;
	private String type;
	private List<Activities> activities;

	public Activity() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdactivity() {
		return this.idactivity;
	}

	public void setIdactivity(int idactivity) {
		this.idactivity = idactivity;
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


	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="activity")
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

}