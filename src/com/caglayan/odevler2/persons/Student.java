package com.caglayan.odevler2.persons;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.caglayan.odevler2.fileoperations.FileOps;
import com.caglayan.odevler2.lessons.Lesson;
import com.caglayan.odevler2.statics.Statics;

public class Student extends Person implements Serializable {
	private static final long serialVersionUID = -8057798867801621960L;
	private String registrationNumber;
	private LocalDate startDate;
	private LocalDate finishDate;
	private String classRoom;
	private List<Lesson> lessons;
	private String parentPhoneNumber;

	public Student(Name name, Gender gender, LocalDate birthDate, String phoneNumber1, String phoneNumber2,
			LocalDate startDate, LocalDate finishDate, String classRoom, String parentPhoneNumber) {
		super(name, gender, birthDate, phoneNumber1, phoneNumber2);
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.classRoom = classRoom;
		lessons = new ArrayList<Lesson>();
		this.parentPhoneNumber = parentPhoneNumber;
		this.registrationNumber = assignRegistrationNumber();
	}

	public String assignRegistrationNumber() {
		int num = FileOps.readInt(Statics.STUDENT_COUNTER_PATH);
		String regNum = String.format("%d-%03d", this.startDate.getYear(), num);
		FileOps.writeInt(Statics.STUDENT_COUNTER_PATH, ++num);
		return regNum;
	}

	public List<Lesson> getLessons(){
		return this.lessons;
	}
	
	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}
	
	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getParentPhoneNumber() {
		return parentPhoneNumber;
	}

	public void setParentPhoneNumber(String parentPhoneNumber) {
		this.parentPhoneNumber = parentPhoneNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	@Override
	public String toString() {
		return "# Student [registrationNumber=" + registrationNumber + ", startDate=" + startDate + ", finishDate="
				+ finishDate + ", classRoom=" + classRoom + ", parentPhoneNumber=" + parentPhoneNumber + ", name="
				+ name + ", gender=" + gender + ", birthDate=" + birthDate + ", phoneNumber1=" + phoneNumber1
				+ ", phoneNumber2=" + phoneNumber2 + "]";
	}

}
