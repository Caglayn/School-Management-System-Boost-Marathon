package com.caglayan.odevler2.menu;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.caglayan.odevler2.fileoperations.FileOps;
import com.caglayan.odevler2.lessons.Lesson;
import com.caglayan.odevler2.persons.Employee;
import com.caglayan.odevler2.persons.Gender;
import com.caglayan.odevler2.persons.Jobs;
import com.caglayan.odevler2.persons.MaritalStatus;
import com.caglayan.odevler2.persons.Name;
import com.caglayan.odevler2.persons.Student;
import com.caglayan.odevler2.school.School;
import com.caglayan.odevler2.statics.Statics;

public class Menu implements ISelectable {
	private static Scanner scanner = new Scanner(System.in);
	private School school;
	Locale locale;
	ResourceBundle languageBundle;
//	Locale locale_en = new Locale("en");
//	ResourceBundle languBundle2 = ResourceBundle.getBundle("com.caglayan.odevler2.texts.texts", locale_en);

	public Menu(String country) {
		locale = new Locale(country);
		languageBundle = ResourceBundle.getBundle("com.caglayan.odevler2.texts.texts", locale);
		school = getSchoolDatas();
		menuLoop();

	}

	private School getSchoolDatas() {
		School school1 = FileOps.readSerializedObject(Statics.SCHOOL_OBJECT_PATH);
		if (school1 != null) {
			return school1;
		} else
			return new School();
	}

	private void writeSchoolDatas(School school) {
		FileOps.writeSerializedObject(school, Statics.SCHOOL_OBJECT_PATH);
	}

	@Override
	public void showMenuItems() {
		System.out.println("\n#########################################################");
		System.out.println("################## Okul Yonetim Sistemi #################");
		System.out.println("#########################################################");

		System.out.println("# 1-  " + languageBundle.getString("LocalGlobal.1") + "\t\t\t\t\t#");
		System.out.println("# 2-  " + languageBundle.getString("LocalGlobal.2") + "\t\t\t\t\t#");
		System.out.println("# 3-  " + languageBundle.getString("LocalGlobal.3") + "\t\t\t\t\t#");
		System.out.println("# 4-  " + languageBundle.getString("LocalGlobal.4") + "\t\t\t\t\t#");
		System.out.println("# 5-  " + languageBundle.getString("LocalGlobal.5") + "\t\t\t\t\t#");
		System.out.println("# 6-  " + languageBundle.getString("LocalGlobal.6") + "\t\t\t\t\t#");
		System.out.println("# 7-  " + languageBundle.getString("LocalGlobal.7") + "\t\t\t\t#");
		System.out.println("# 8-  " + languageBundle.getString("LocalGlobal.8") + "\t\t\t\t\t#");
		System.out.println("# 9-  " + languageBundle.getString("LocalGlobal.9") + "\t\t\t\t\t#");
		System.out.println("# 10- " + languageBundle.getString("LocalGlobal.10") + "\t\t\t\t\t#");
		System.out.println("#########################################################");
	}

	@Override
	public void makeChoice(int choice) {
		switch (choice) {
		case 1:
			newEmployees();
			break;
		case 2:
			listEmployees(school.getEmployees());
			break;
		case 3:
			listOldEmployees(school.getEmployees());
			break;
		case 4:
			newLessons(school.getEmployees());
			break;
		case 5:
			newStudents();
			break;
		case 6:
			lessonsList(school.getLessons());
			break;
		case 7:
			studentsLessons();
			break;
		case 8:
			giftList();
			break;
		case 9:
			calculateSalary();
			break;
		case Statics.MENU_EXIT:
			endLoop();
			break;
		default:
			System.out.println("Hatalı giriş yaptınız, yeniden deneyin.");
		}
	}



	private void newEmployees() {
		Employee teacher1 = new Employee(new Name("Ali", "Can", "YILMAZ"), Gender.MALE,
				LocalDate.parse("21.08.1975", Statics.dateTimeFormatter), "05323212121", "05326546554",
				MaritalStatus.MARRIED, LocalDate.parse("18.10.2010", Statics.dateTimeFormatter), null, Jobs.OGRETMEN,
				5000.0);
		Employee teacher2 = new Employee(new Name("Ayşe", "Su", "PARLAK"), Gender.FEMALE,
				LocalDate.parse("15.02.1986", Statics.dateTimeFormatter), "05323123121", "05329876554",
				MaritalStatus.SINGLE, LocalDate.parse("19.06.2017", Statics.dateTimeFormatter), null, Jobs.OGRETMEN,
				5000.0);
		Employee teacher3 = new Employee(new Name("Veli", "", "YILMAZ"), Gender.MALE,
				LocalDate.parse("15.08.1980", Statics.dateTimeFormatter), "05323123158", "05329843554",
				MaritalStatus.SINGLE, LocalDate.parse("19.06.2014", Statics.dateTimeFormatter),
				LocalDate.parse("19.06.2018", Statics.dateTimeFormatter), Jobs.OGRETMEN, 5000.0);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Employee servant1 = new Employee(new Name("Hasan", "", "ATLI"), Gender.MALE,
				LocalDate.parse("21.08.1965", Statics.dateTimeFormatter), "05323212121", "05326546554",
				MaritalStatus.MARRIED, LocalDate.parse("18.10.2012", Statics.dateTimeFormatter), null, Jobs.HIZMETLI,
				3000.0);
		Employee servant2 = new Employee(new Name("Hüseyin", "", "KATLI"), Gender.MALE,
				LocalDate.parse("15.02.1988", Statics.dateTimeFormatter), "05323123121", "05329876554",
				MaritalStatus.SINGLE, LocalDate.parse("19.06.2013", Statics.dateTimeFormatter), null, Jobs.HIZMETLI,
				3000.0);
		Employee servant3 = new Employee(new Name("Fatma", "", "YATLI"), Gender.FEMALE,
				LocalDate.parse("15.08.1979", Statics.dateTimeFormatter), "05323123158", "05329843554",
				MaritalStatus.MARRIED, LocalDate.parse("19.06.2015", Statics.dateTimeFormatter),
				LocalDate.parse("19.06.2019", Statics.dateTimeFormatter), Jobs.HIZMETLI, 3000.0);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Employee officer1 = new Employee(new Name("Murat", "", "ADANALI"), Gender.MALE,
				LocalDate.parse("18.10.1967", Statics.dateTimeFormatter), "05323212121", "05326546554",
				MaritalStatus.SINGLE, LocalDate.parse("18.10.2011", Statics.dateTimeFormatter), null, Jobs.MEMUR,
				4000.0);
		Employee officer2 = new Employee(new Name("Ceren", "", "ANKARALI"), Gender.FEMALE,
				LocalDate.parse("18.10.1989", Statics.dateTimeFormatter), "05323123121", "05329876554",
				MaritalStatus.SINGLE, LocalDate.parse("18.10.2019", Statics.dateTimeFormatter), null, Jobs.MEMUR,
				4000.0);
		Employee officer3 = new Employee(new Name("Hande", "Nur", "BURSALI"), Gender.FEMALE,
				LocalDate.parse("15.08.1986", Statics.dateTimeFormatter), "05323123158", "05329843554",
				MaritalStatus.MARRIED, LocalDate.parse("19.06.2015", Statics.dateTimeFormatter),
				LocalDate.parse("19.06.2019", Statics.dateTimeFormatter), Jobs.MEMUR, 4000.0);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		school.addEmployee(teacher1);
		school.addEmployee(teacher2);
		school.addEmployee(teacher3);

		school.addEmployee(servant1);
		school.addEmployee(servant2);
		school.addEmployee(servant3);

		school.addEmployee(officer1);
		school.addEmployee(officer2);
		school.addEmployee(officer3);

		writeSchoolDatas(school);
	}

	private void listEmployees(List<Employee> employees) {
		employees.stream().forEach(s -> System.out.println(s));
	}

	private void listOldEmployees(List<Employee> employees) {
		employees.stream().filter(i -> i.getResignDate() != null).forEach(i -> System.out.println(i));
	}

	private void newLessons(List<Employee> employees) {
		Lesson lesson1 = new Lesson(employees.get(1), employees.get(0), "Java Programming", "2020", "3 Saat",
				"Perşembe, 14:00-17:00");
		Lesson lesson2 = new Lesson(employees.get(0), employees.get(1), "C# Programming", "2019", "3 Saat",
				"Cuma, 14:00-17:00");

		school.addLesson(lesson1);
		school.addLesson(lesson2);
		writeSchoolDatas(school);
	}

	private void newStudents() {
		Student student0 = new Student(new Name("isim1", "", "soyisim1"), Gender.FEMALE,
				LocalDate.parse("18.10.1995", Statics.dateTimeFormatter), "05051234568", "05059876541",
				LocalDate.parse("01.01.2020", Statics.dateTimeFormatter), null, "A1", "05326248536");
		Student student1 = new Student(new Name("isim2", "", "soyisim2"), Gender.MALE,
				LocalDate.parse("09.05.1996", Statics.dateTimeFormatter), "05051234568", "05059876541",
				LocalDate.parse("01.01.2019", Statics.dateTimeFormatter), null, "A2", "05326248536");
		Student student2 = new Student(new Name("isim3", "", "soyisim3"), Gender.FEMALE,
				LocalDate.parse("01.12.1992", Statics.dateTimeFormatter), "05051234568", "05059876541",
				LocalDate.parse("01.01.2021", Statics.dateTimeFormatter), null, "A1", "05326248536");
		Student student3 = new Student(new Name("isim4", "", "soyisim4"), Gender.MALE,
				LocalDate.parse("15.11.1998", Statics.dateTimeFormatter), "05051234568", "05059876541",
				LocalDate.parse("01.01.2018", Statics.dateTimeFormatter),
				LocalDate.parse("01.01.2020", Statics.dateTimeFormatter), "A2", "05326248536");
		Student student4 = new Student(new Name("isim5", "", "soyisim5"), Gender.FEMALE,
				LocalDate.parse("18.10.1995", Statics.dateTimeFormatter), "05051234568", "05059876541",
				LocalDate.parse("01.01.2017", Statics.dateTimeFormatter),
				LocalDate.parse("01.01.2019", Statics.dateTimeFormatter), "A1", "05326248536");
		Student student5 = new Student(new Name("isim6", "", "soyisim6"), Gender.MALE,
				LocalDate.parse("18.10.1995", Statics.dateTimeFormatter), "05051234568", "05059876541",
				LocalDate.parse("01.01.2020", Statics.dateTimeFormatter), null, "A2", "05326248536");

		school.addStudent(student0);
		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student3);
		school.addStudent(student4);
		school.addStudent(student5);

		school.getLessons().get(0).addStudent(student0);
		school.getLessons().get(0).addStudent(student1);
		school.getLessons().get(0).addStudent(student2);
		school.getLessons().get(1).addStudent(student3);
		school.getLessons().get(1).addStudent(student4);
		school.getLessons().get(1).addStudent(student5);

		school.getStudents().get(0).addLesson(school.getLessons().get(0));
		school.getStudents().get(1).addLesson(school.getLessons().get(0));
		school.getStudents().get(2).addLesson(school.getLessons().get(0));
		school.getStudents().get(3).addLesson(school.getLessons().get(1));
		school.getStudents().get(4).addLesson(school.getLessons().get(1));
		school.getStudents().get(5).addLesson(school.getLessons().get(1));

		writeSchoolDatas(school);

	}

	private void lessonsList(List<Lesson> lessons) {
		for (Lesson lesson : lessons) {
			System.out.println(lesson.getName());
			lesson.getStudents().stream().forEach(i -> System.out.println(i));
		}
	}

	private void studentsLessons() {
		school.getStudents().stream().forEach(i -> System.out.println(i));
		System.out.println("# " + languageBundle.getString("LocalGlobal.11") + " : ");
		String regNum = scanner.next();
		school.getStudent(regNum).getLessons().stream().forEach(i -> System.out.println(i));
	}

	private void giftList() {
		System.out.println("# " + languageBundle.getString("LocalGlobal.12"));
		int today = LocalDate.now().getMonthValue();
		school.getEmployees().stream()
		.filter(i -> i.getStartToWorkDate().getMonthValue()==today)
		.forEach(s -> System.out.println("# " + s.getName()));
		
		System.out.println("# " + languageBundle.getString("LocalGlobal.13"));
		List<Employee> females = school.getEmployees().stream().filter(i -> i.getGender()==Gender.FEMALE).collect(Collectors.toList());
		females.stream().filter(i -> i.getBirthDate().getMonthValue()==today)
		.forEach(s -> System.out.println("# " + s.getName()));
	}
	
	private void calculateSalary() {
		List<Employee> employees = school.getEmployees().stream().filter(i -> i.getResignDate()==null).collect(Collectors.toList());
		
		System.out.println("# " + languageBundle.getString("LocalGlobal.17") + " : ");
		for (Employee employee : employees) {
			System.out.println(employee.getName() + " : " + employee.calculateCurrentSalary());
		}
	}
	
	
	
	@Override
	public int getUserSelection(String message) {
		System.out.println(message + " ");
		try {
			int userInput = scanner.nextInt();
			if (userInput >= Statics.MENU_MIN && userInput <= Statics.MENU_MAX) {
				return userInput;
			}
		} catch (Exception e) {
			System.out.println("# " + languageBundle.getString("LocalGlobal.14"));
			return -1;
		}
		System.out.println("# " + languageBundle.getString("LocalGlobal.14"));
		return -1;
	}

	@Override
	public void menuLoop() {
		do {
			showMenuItems();
			makeChoice(getUserSelection(""));
		} while (true);
	}

	@Override
	public void endLoop() {
		System.out.println("# " + languageBundle.getString("LocalGlobal.15") + " : ");
		if (scanner.next().equalsIgnoreCase("evet")) {
			System.out.println(languageBundle.getString("LocalGlobal.16"));
			scanner.close();
			System.exit(0);
		}
	}
}
