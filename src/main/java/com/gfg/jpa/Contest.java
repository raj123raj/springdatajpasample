package com.gfg.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contestName;
	private String contestDescription;

	protected Contest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getContestName() {
		return contestName;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	public String getContestDescription() {
		return contestDescription;
	}

	public void setContestDescription(String contestDescription) {
		this.contestDescription = contestDescription;
	}

	@Override
	public String toString() {
		return "Contest [contestName=" + contestName + ", contestDescription=" + contestDescription + "]";
	}
	
	

}
