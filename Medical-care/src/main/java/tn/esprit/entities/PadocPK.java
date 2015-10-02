package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class PadocPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpatient;
	private int iddoctor;
public PadocPK() {
	// TODO Auto-generated constructor stub
}
@Column(name="idpatient",insertable=false, updatable=false)
public int getIdpatient() {
	return idpatient;
}
public void setIdpatient(int idpatient) {
	this.idpatient = idpatient;
}
@Column(name="iddoctor",insertable=false, updatable=false)
public int getIddoctor() {
	return iddoctor;
}
public void setIddoctor(int iddoctor) {
	this.iddoctor = iddoctor;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + iddoctor;
	result = prime * result + idpatient;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	PadocPK other = (PadocPK) obj;
	if (iddoctor != other.iddoctor)
		return false;
	if (idpatient != other.idpatient)
		return false;
	return true;
}


}
