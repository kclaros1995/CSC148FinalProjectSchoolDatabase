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

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ClassroomBag implements Serializable {
	private static Classroom[] classroomArray;
	private static int nElems;

	public ClassroomBag(int maxSize) {
		classroomArray = new Classroom[maxSize];
		nElems = 0;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(classroomArray[i]);
		}
		System.out.println(); 
	}

	public Classroom findByClassroomNumber(String classRoomNumber) {
		for (int i = 0; i < nElems; i++) {
			if (classroomArray[i].getRoomNumber().equals(classRoomNumber)) {
				return classroomArray[i];
			}
		}
		return null;
	}

	public void insert(Classroom classroom) {
		classroomArray[nElems++] = classroom;
	}

	public Classroom removeByClassroomNumber(String classroomNumber) {
		int indexFound;
		for (indexFound = 0; indexFound < nElems; indexFound++) {
			if (classroomArray[indexFound].getRoomNumber().equals(classroomNumber)) {
				break;
			}
		}
		if (indexFound == nElems) {
			return null;
		} else {
			Classroom temp = classroomArray[indexFound];
			for (int i = indexFound; i < nElems - 1; i++) {
				classroomArray[i] = classroomArray[i + 1];
			}
			nElems--;
			return temp;

		}
	}

	public static void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("SaveData/ClassroomBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(classroomArray);
			oos.writeObject(nElems);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("SaveData/ClassroomBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			classroomArray = (Classroom[]) ois.readObject();
			nElems = (int) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			Model.Util.failureAlert("Trouble finding ClassroomBag.dat");
		} catch (IOException e) {
			Model.Util.failureAlert("Trouble loading Classroom.dat");
		} catch (ClassNotFoundException e) {
			Model.Util.failureAlert("Class not found exception occurred!");
		}
	}
	
	public void exportClassroomTextData() {
		Stage stage = new Stage();
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TextFiles (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showSaveDialog(stage);
		if (file != null) {

			PrintWriter pw = null;
			try {
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				Model.Util.failureAlert("Failure exporting Student data!");
			}
			for (int i = 0; i < nElems; i++) {
				Classroom classroom = classroomArray[i];
				pw.println(classroom.toString());
			}
			pw.close();
		}
	}

	public void importData() {//// used to import text files

	}

	public static int getnElems() {
		return nElems;
	}

	public static Classroom[] getClassroomArray() {
		return Arrays.copyOf(classroomArray, nElems);
	}


 
}
