package com.caglayan.odevler2.persons;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {
	private static final long serialVersionUID = 2578452349706959408L;
	protected Name name;
	protected Gender gender;
	protected LocalDate birthDate;
	protected String phoneNumber1;
	protected String phoneNumber2;
	
	public Person(Name name, Gender gender, LocalDate birthDate, String phoneNumber1, String phoneNumber2) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", birthDate=" + birthDate + ", phoneNumber1="
				+ phoneNumber1 + ", phoneNumber2=" + phoneNumber2 + "]";
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	
	
	
}
