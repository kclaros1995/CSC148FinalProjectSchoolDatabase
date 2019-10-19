package Model;

import View.StudentPane;

public class College {
	private static PersonBag personBag;
	private static CourseBag courseBag; 
	private static ClassroomBag classroomBag;
	private static TextbookBag textbookBag;
	private static GradeBag gradeBag;

	public College(int personBagMaxSize, int courseBagMaxiSize, int classroomBagmaxSize, int textbookBagMaxSize, int gradeBagMaxSize) {
		super();
		College.personBag = new PersonBag(personBagMaxSize);
		College.courseBag = new CourseBag(courseBagMaxiSize);
		College.classroomBag = new ClassroomBag(classroomBagmaxSize);
		College.textbookBag = new TextbookBag(textbookBagMaxSize);
		College.gradeBag = new GradeBag(gradeBagMaxSize);
		loadAll();
  
	}
 
	public static void loadAll() {
		PersonBag.load();
		CourseBag.load();
		ClassroomBag.load();
		TextbookBag.load();
	}
	

	public static void saveAll() {
		PersonBag.save();
		CourseBag.save();
		ClassroomBag.save();
		TextbookBag.save();
	} 
	

	public static GradeBag getGpaBag() {
		return gradeBag;
	}

	public static void setGpaBag(GradeBag gradeBag) {
		College.gradeBag = gradeBag;
	}

	public static PersonBag getPersonBag() {
		return personBag;
	}

	public static void setPersonBag(PersonBag personBag) {
		College.personBag = personBag;
	}

	public static CourseBag getCourseBag() {
		return courseBag;
	}

	public static void setCourseBag(CourseBag courseBag) {
		College.courseBag = courseBag;
	}


	public  static ClassroomBag getClassroomBag() {
		return classroomBag;
	}

	public static void setClassroomBag(ClassroomBag classroomBag) {
		College.classroomBag = classroomBag;
	}

	public static TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public static void setTextbookBag(TextbookBag textbookBag) {
		College.textbookBag = textbookBag;
	}

	public static GradeBag getGradeBag() {
		return gradeBag;
	}

	public static void setGradeBag(GradeBag gradeBag) {
		College.gradeBag = gradeBag;
	}
	
	

}
