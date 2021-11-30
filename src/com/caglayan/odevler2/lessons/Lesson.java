package com.caglayan.odevler2.lessons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.caglayan.odevler2.persons.*;

public class Lesson implements Serializable {
	private static final long serialVersionUID = -4569788897414302923L;
	private Employee masterTrainer;
	private Employee asistantTrainer;
	private String name;
	private String year;
	private List<Student> students;
	private String lessonTime;
	private String lessonDateBetween;

	public Lesson(Employee masterTrainer, Employee asistantTrainer, String name, String year, String lessonTime,
			String lessonDateBetween) {
		this.masterTrainer = masterTrainer;
		this.asistantTrainer = asistantTrainer;
		this.name = name;
		this.year = year;
		this.lessonTime = lessonTime;
		this.lessonDateBetween = lessonDateBetween;
		this.students = new ArrayList<Student>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Student> getStudents() {
		return students;
	}

	public Employee getMasterTrainer() {
		return masterTrainer;
	}

	public void setMasterTrainer(Employee masterTrainer) {
		this.masterTrainer = masterTrainer;
	}

	public Employee getAsistantTrainer() {
		return asistantTrainer;
	}

	public void setAsistantTrainer(Employee asistantTrainer) {
		this.asistantTrainer = asistantTrainer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(String lessonTime) {
		this.lessonTime = lessonTime;
	}

	public String getLessonDateBetween() {
		return lessonDateBetween;
	}

	public void setLessonDateBetween(String lessonDateBetween) {
		this.lessonDateBetween = lessonDateBetween;
	}

	@Override
	public String toString() {
		return "# " + this.name + " [masterTrainer=" + masterTrainer + ", asistantTrainer=" + asistantTrainer + ", name=" + name
				+ ", year=" + year + ", students=" + students + ", lessonTime=" + lessonTime + ", lessonDateBetween="
				+ lessonDateBetween + "]";
	}
}
