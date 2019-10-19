package Model;

import java.io.Serializable;
import java.util.Arrays;

public class Grade implements Serializable {
	private String courseNumber;
	private String letterGrade;

	public Grade(String courseNumber, String letterGrade) {
		super();
		this.courseNumber = courseNumber;
		this.letterGrade = letterGrade;

	}

	public Grade(String courseNumber) {
		super();
		this.courseNumber = courseNumber;
	}

	public Grade() {
		super();
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public String getLetterGrade() {
		return letterGrade;
	}

	@Override
	public String toString() {
		return courseNumber + " " + letterGrade;
	}

}
