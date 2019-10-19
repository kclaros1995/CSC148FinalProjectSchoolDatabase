package Model;

import java.io.Serializable;

public class Course implements Serializable{
	private String courseTitle;
	private String courseNumber;
	private String textbookIsbn;
	private  int numberOfCredits;
	private String facultyId;
	private String courseDescription;
	public Course(String courseTitle, String courseNumber, int numberOfCredits) {
		super();
		this.courseTitle = courseTitle;  
		this.courseNumber = courseNumber;
		this.numberOfCredits = numberOfCredits;
		
	}
	
	public Course(String courseTitle, String courseNumber, int numberOfCredits,
			String courseDescription, String facultyId) {
		super();
		this.courseTitle = courseTitle;
		this.courseNumber = courseNumber;
		this.numberOfCredits = numberOfCredits;
		this.courseDescription = courseDescription;
		this.facultyId = facultyId;
	}

	public Course(Course course) {
		this.courseTitle = course.getCourseTitle();
		this.courseNumber = course.getCourseNumber();
		this.textbookIsbn = course.getTextbookIsbn();
		this.numberOfCredits = course.getNumberOfCredits();
		this.facultyId = course.getFacultyId();
		this.courseDescription = course.getCourseDescription();
	}
	public Course() {
		
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getTextbookIsbn() {
		return textbookIsbn;
	}
	public void setTextbookIsbn(String textbookIsbn) {
		this.textbookIsbn = textbookIsbn;
	}
	public int getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}


	@Override
	public String toString() {
		return "Course \n course Title = " + courseTitle + "\n course Number = " + courseNumber + ", number of credits = " + numberOfCredits + "\n";
	}
	
	

}
