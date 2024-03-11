package studentManagementSystem;

public class StudentFactory {
	public static Student createStudent(String name, int rollNo, int standard, int scienceMark, int mathMark, int englishMark) {
		return new Student(name,rollNo,standard,scienceMark,mathMark,englishMark);
	}
}
