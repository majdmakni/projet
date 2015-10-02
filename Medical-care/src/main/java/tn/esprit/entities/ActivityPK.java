package tn.esprit.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the activities database table.
 * 
 */
@Embeddable
public class ActivityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idpack;
	private int idactivity;

	public ActivityPK() {
	}

	@Column(name="idhealthpack",insertable=false, updatable=false)
	public int getIdpack() {
		return this.idpack;
	}
	public void setIdpack(int idpack) {
		this.idpack = idpack;
	}

	@Column(name="idactivity",insertable=false, updatable=false)
	public int getIdactivity() {
		return this.idactivity;
	}
	public void setIdactivity(int idactivity) {
		this.idactivity = idactivity;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActivityPK)) {
			return false;
		}
		ActivityPK castOther = (ActivityPK)other;
		return 
			(this.idpack == castOther.idpack)
			&& (this.idactivity == castOther.idactivity);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idpack;
		hash = hash * prime + this.idactivity;
		
		return hash;
	}
	
}