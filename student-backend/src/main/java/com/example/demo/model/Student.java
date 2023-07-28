package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="email")
	private String emailId;
	@Column(name="salary_package")
	private int salaryPackage;
	public Student() {
		
	}
	public Student(long id, String firstname, String lastname, String emailId, int salaryPackage) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
		this.salaryPackage = salaryPackage;
	}
	public int  getSalaryPackage() {
		return salaryPackage;
	}
	public void setSalaryPackage(int  salaryPackage) {
		this.salaryPackage = salaryPackage;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}

