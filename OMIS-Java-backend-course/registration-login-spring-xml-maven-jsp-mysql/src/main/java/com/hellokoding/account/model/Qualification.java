package com.hellokoding.account.model;  
  
public class Qualification {  
	private long id;  
	private long employeeId;  
	private String qualification;  
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
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return String.format("Qualification [id=%s, employeeId=%s, qualification=%s, level=%s]", id, employeeId,
				qualification, level);
	}
  
}  