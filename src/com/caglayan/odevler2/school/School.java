package com.caglayan.odevler2.school;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.caglayan.odevler2.lessons.Lesson;
import com.caglayan.odevler2.persons.Employee;
import com.caglayan.odevler2.persons.Student;

public class School implements Serializable {
	private static final long serialVersionUID = -576373386878327387L;

	
	private List<Employee> employees;
	private List<Student> students;
	private List<Lesson> lessons;

	public School() {
		this.employees = new ArrayList<Employee>();
		this.students = new ArrayList<Student>();
		this.lessons = new ArrayList<Lesson>();
	}
	
	public Student getStudent(String registrationNumber) {
		return this.students.stream().filter(i -> i.getRegistrationNumber().equalsIgnoreCase(registrationNumber)).collect(Collectors.toList()).get(0);
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}
}
