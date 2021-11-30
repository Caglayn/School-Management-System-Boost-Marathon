package com.caglayan.odevler2.persons;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import com.caglayan.odevler2.fileoperations.FileOps;
import com.caglayan.odevler2.statics.Statics;

public class Employee extends Person implements Workable, Serializable {
	private static final long serialVersionUID = 7188787445319018254L;
	private MaritalStatus maritalStatus;
	private LocalDate startToWorkDate;
	private LocalDate resignDate;
	private Jobs job;
	private String employeeNumber;
	private double startSalary;
	private double salaryIncreaseRate;

	public Employee(Name name, Gender gender, LocalDate birthDate, String phoneNumber1, String phoneNumber2,
			MaritalStatus maritalStatus, LocalDate startToWorkDate, LocalDate resignDate, Jobs job,
			double startSalary) {
		super(name, gender, birthDate, phoneNumber1, phoneNumber2);
		this.maritalStatus = maritalStatus;
		this.startToWorkDate = startToWorkDate;
		this.resignDate = resignDate;
		this.job = job;
		this.startSalary = startSalary;
		this.salaryIncreaseRate = assignSalaryIncreaseRate();
		this.employeeNumber = assignEmployeeNumber();
	}

	@Override
	public double assignSalaryIncreaseRate() {
		if (this.job == Jobs.OGRETMEN)
			return 10.0;
		else if (this.job == Jobs.MEMUR)
			return 9.0;
		else
			return 8.5;
	}
	
	@Override
	public String assignEmployeeNumber() {
		int num = FileOps.readInt(Statics.EMPLOYEE_COUNTER_PATH);
		String empNum = String.format("%C-%03d", this.job.toString().charAt(0), num);
		FileOps.writeInt(Statics.EMPLOYEE_COUNTER_PATH, ++num);
		return empNum;
	}

	@Override
	public double calculateCurrentSalary() {
		long years = this.startToWorkDate.until(LocalDate.now(), ChronoUnit.YEARS);
		double currentSalary = this.startSalary;
		
		for(int i = 0; i<years*2;i++) {
			currentSalary = currentSalary*(100.0+this.salaryIncreaseRate)/100;
		}
		
		return currentSalary;
	}



	@Override
	public String toString() {
		return "# " + this.job + "[maritalStatus=" + maritalStatus + ", startToWorkDate=" + startToWorkDate + ", resignDate="
				+ resignDate + ", job=" + job + ", employeeNumber=" + employeeNumber + ", startSalary=" + startSalary
				+ ", salaryIncreaseRate=" + salaryIncreaseRate + ", name=" + name + ", gender=" + gender
				+ ", birthDate=" + birthDate + ", phoneNumber1=" + phoneNumber1 + ", phoneNumber2=" + phoneNumber2
				+ "]";
	}

	public void setEmployeeSurName(String surName) {
		this.name.setSurName(surName);
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public LocalDate getResignDate() {
		return resignDate;
	}

	public void setResignDate(LocalDate resignDate) {
		this.resignDate = resignDate;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public LocalDate getStartToWorkDate() {
		return startToWorkDate;
	}

	public double getStartSalary() {
		return startSalary;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}
	
}
