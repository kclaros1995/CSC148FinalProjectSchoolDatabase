
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CourseBag implements Serializable{
	private static Course[] courseArray;
	private static int nElems;

	public CourseBag(int maxSize) {
		courseArray = new Course[maxSize];
		nElems = 0;
	}  

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(courseArray[i]);
		}
		System.out.println();
	}

	public void insert(Course course) {
		courseArray[nElems++] = course;
	}

	public Course findByCourseNumber(String courseNumber) {
		for (int i = 0; i < nElems; i++) {
			if (courseArray[i].getCourseNumber().equals(courseNumber)) {
				return courseArray[i];
			}
		}
		return null;
	}

	public Course removeByCourseNumber(String courseNumber) {
		int indexFound;
		for (indexFound = 0; indexFound < nElems; indexFound++) {
			if (courseArray[indexFound].getCourseNumber().equals(courseNumber)) {
				break;
			}
		}
		if (indexFound == nElems) {
			return null;
		} else {
			Course temp = courseArray[indexFound];
			for (int i = indexFound; i < nElems - 1; i++) {
				courseArray[i] = courseArray[i + 1];
			}
			nElems--;
			return temp;
		}
	}

	public static void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("SaveData/CourseBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(courseArray);
			oos.writeObject(nElems);
			oos.close();
		} catch (FileNotFoundException e) {
			Model.Util.failureAlert("Failure saving CourseBag.dat file!");
		} catch (IOException e) {
			Model.Util.failureAlert("Failure saving CourseBag.dat file!");
		}

	}

	public static void load() { 
		FileInputStream fis;
		try {
			fis = new FileInputStream("SaveData/CourseBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			courseArray = (Course[]) ois.readObject();
			nElems = (int) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			Model.Util.failureAlert("Trouble loading Course.dat");
		} catch (IOException e) {
			Model.Util.failureAlert("Trouble loading Course.dat");
		} catch (ClassNotFoundException e) {
			Model.Util.failureAlert("Class not found exception occurred!");
		}
	}
	
	public void importData() {
		File file = new File("Import/courses.txt");
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				String[] tokens = in.nextLine().split(", ");
				Course course = new Course(tokens[0], tokens[1], Integer.valueOf(tokens[2]));
				insert(course);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void exportCourseTextData() {
		Stage stage = new Stage();
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extFilter); 
		File file = fileChooser.showSaveDialog(stage);
		if (file != null) {

			PrintWriter pw = null;
			try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				Model.Util.failureAlert("Failure exporting Course data!");
			}
			for (int i = 0; i < nElems; i++) {
				Course course = courseArray[i];
					pw.println(course.toString());
			}
			pw.close();
		}
	}
	public static int getnElems() { 
		return nElems;
	}

	public static Course[] getCourseArray() {
		return Arrays.copyOf(courseArray, nElems);
	}

}
