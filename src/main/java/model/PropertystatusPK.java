package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the propertystatus database table.
 * 
 */
@Embeddable
public class PropertystatusPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer propertyid;
	private Integer propertystatus;

	public PropertystatusPK() {
	}

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	public Integer getPropertyid() {
		return this.propertyid;
	}
	public void setPropertyid(Integer propertyid) {
		this.propertyid = propertyid;
	}

	@Column(unique=true, nullable=false)
	public Integer getPropertystatus() {
		return this.propertystatus;
	}
	public void setPropertystatus(Integer propertystatus) {
		this.propertystatus = propertystatus;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PropertystatusPK)) {
			return false;
		}
		PropertystatusPK castOther = (PropertystatusPK)other;
		return 
			this.propertyid.equals(castOther.propertyid)
			&& this.propertystatus.equals(castOther.propertystatus);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.propertyid.hashCode();
		hash = hash * prime + this.propertystatus.hashCode();
		
		return hash;
	}
}