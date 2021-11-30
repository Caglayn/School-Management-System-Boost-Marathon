package com.caglayan.odevler2.statics;

import java.io.File;
import java.time.format.DateTimeFormatter;

public class Statics {
	public static final int MENU_MIN = 0;
	public static final int MENU_MAX = 10;
	public static final int MENU_EXIT = 10;
	public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	public static final File EMPLOYEE_COUNTER_PATH = new File("C:\\Files\\Employee.dat");
	public static final File STUDENT_COUNTER_PATH = new File("C:\\Files\\Student.dat");
	public static final File SCHOOL_OBJECT_PATH = new File("C:\\Files\\School.dat");
}
