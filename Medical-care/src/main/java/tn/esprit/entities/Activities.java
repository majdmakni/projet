package tn.esprit.entities;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Activities {
private ActivityPK activityPK;
private Date  date;
private Activity activity;
private Healthpack healthpack;
public Activities() {
	
	// TODO Auto-generated constructor stub
}
@EmbeddedId
public ActivityPK getActivityPK() {
	return activityPK;
}

public void setActivityPK(ActivityPK activityPK) {
	this.activityPK = activityPK;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@ManyToOne
@JoinColumn(name="idactivity",referencedColumnName="idactivity",insertable=false,updatable=false)
public Activity getActivity() {
	return activity;
}
public void setActivity(Activity activity) {
	this.activity = activity;
}
@ManyToOne
@JoinColumn(name="idhealthpack",referencedColumnName="idhealthpack",insertable=false,updatable=false)
public Healthpack getHealthpack() {
	return healthpack;
}
public void setHealthpack(Healthpack healthpack) {
	this.healthpack = healthpack;
}


}
