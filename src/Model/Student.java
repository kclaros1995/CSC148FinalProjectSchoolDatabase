package Model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Student extends Person implements Serializable {
	private String major;
	private static double gpa;
	private Grade[] coursesTook;
	private Grade[] coursesTaking;
	private Grade[] coursesToTake;
	private final static double MAX_GPA = 4.0;
	private final static double MIN_GPA = 0.0;

	public Student(Name name, String phone, Address address, String major) {
		super(name, phone, address);
		this.major = major; 
	}

	public Student(Name name, String phone, Address  address) {
		super(name, phone, address);
	}


	public Student() {
	}
	
 
	public Student(Name name, String phone, Address address, String major, Grade[] coursesTook, Grade[] coursesTaking,
			Grade[] coursesToTake) {
		super(name, phone, address);
		this.major = major;
		this.coursesTook = coursesTook;
		this.coursesTaking = coursesTaking;
		this.coursesToTake = coursesToTake;
	}

	public Student(Student student) {
		super(student.getName(), student.getPhone(), student.getAddress());
		this.major = student.getMajor();
		this.coursesTook = student.coursesTook;
		this.coursesTaking = student.coursesTaking;
		this.coursesToTake = student.coursesToTake;
	}
	
	public static void checkGpa(double gpa) {
		if (gpa < MIN_GPA) {
			try {
				throw new GpaException("GPA is too low, please enter a valid GPA (0.0 - 4.0): ");
			} catch (GpaException e) {
				e.getMessage();
				System.out.println(e.getMessage());
				checkGpa(getNewGPA());

			}
		} else if (gpa > MAX_GPA) {
			try {
				throw new GpaException("GPA is too high, please enter a valid GPA (0.0 - 4.0): ");
			} catch (GpaException e) {
				e.getMessage();
				System.out.println(e.getMessage());
				checkGpa(getNewGPA());
			}
		}

	}

	private static double getNewGPA() {
		double tempGPA = MIN_GPA;
		Scanner kb = new Scanner(System.in);
		tempGPA = kb.nextDouble();
		return tempGPA;

	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Grade[] getCoursesTook() {
		return coursesTook; 
	}

	public void setCoursesTook(Grade[] coursesTook) {
		this.coursesTook = coursesTook;
	}

	public Grade[] getCoursesTaking() {
		return coursesTaking;
	}

	public void setCoursesTaking(Grade[] coursesTaking) {
		this.coursesTaking = coursesTaking;
	}

	public Grade[] getCoursesToTake() {
		return coursesToTake;
	}

	public void setCoursesToTake(Grade[] coursesToTake) {
		this.coursesToTake = coursesToTake;
	}

	@Override
	public String toString() {
		return "Student:  Name = " + getName() + " ID = " + getId() + "\n\t Phone = " + getPhone() + " Address = "
				+ getAddress() + "\n\t major = " + major + "\n\t coursesTook=" + Arrays.toString(coursesTook)
				+ "\n\t coursesTaking = " + Arrays.toString(coursesTaking) + "\n\t coursesToTake="
				+ Arrays.toString(coursesToTake) + "\n";
	}
 
}
