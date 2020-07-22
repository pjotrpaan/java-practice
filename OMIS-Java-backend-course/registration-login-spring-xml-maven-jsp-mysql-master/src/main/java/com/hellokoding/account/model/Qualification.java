package com.hellokoding.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qualification")
public class Qualification {  
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long employeeId;  
	
	private String name;
	
	private int level;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getQualification() {
		return name;
	}
	public void setQualification(String qualification) {
		this.name = qualification;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Qualification [id=" + id + ", employeeId=" + employeeId + ", qualification=" + name + ", level="
				+ level + "]";
	}
  
}  