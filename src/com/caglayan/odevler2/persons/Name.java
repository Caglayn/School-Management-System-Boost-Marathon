package com.caglayan.odevler2.persons;

import java.io.Serializable;

public class Name implements Serializable {
	private static final long serialVersionUID = -1344177588825399475L;
	
	private String name;
	private String midName;
	private String surName;
	
	
	public Name(String name, String midName, String surName) {
		this.name = name;
		this.midName = midName;
		this.surName = surName;
	}


	public String getSurName() {
		return surName;
	}


	public void setSurName(String surName) {
		this.surName = surName;
	}


	public String getName() {
		return name;
	}


	public String getMidName() {
		return midName;
	}


	@Override
	public String toString() {
		String str = this.midName.isEmpty() ? this.name + " " + this.surName : this.name + " " + this.midName + " " + this.surName;
		return str;
	}
	
	
	
}
