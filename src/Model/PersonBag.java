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

import javax.rmi.CORBA.Util;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PersonBag implements Serializable {
	private static Person[] personArray;
	private static int nElems;

	public PersonBag(int maxSize) {
		personArray = new Person[maxSize];
		nElems = 0;
	}

	public void display() {
		for (int i = 0; i < getnElems(); i++) {
			System.out.println(personArray[i]);
		}
		System.out.println();
	}

	public void insert(Person person) {
		personArray[nElems++] = person;
	}

	public Person findById(String id) {
		for (int i = 0; i < getnElems(); i++) {
			if (personArray[i].getId().equals(id)) {
				return personArray[i];
			}

		}
		return null;
	}

	public Person removeById(String id) {
		int indexFound;
		for (indexFound = 0; indexFound < getnElems(); indexFound++) {
			if (personArray[indexFound].getId().equals(id)) {
				break;
			}
		}
		if (indexFound == getnElems()) {
			return null;
		} else {
			Person temp = personArray[indexFound];
			for (int i = indexFound; i < getnElems() - 1; i++) {
				personArray[i] = personArray[i + 1];
			}
			setnElems(getnElems() - 1);
			return temp;
		}
	}

	public static void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("SaveData/PersonBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(personArray);
			oos.writeObject(nElems);
			oos.writeInt(Person.getIdCounter());
			oos.close();
		} catch (FileNotFoundException e) {
			Model.Util.failureAlert("Failure finding PersonBag.dat file!");
		} catch (IOException e) {
			Model.Util.failureAlert("Failure saving PersonBag.dat file!");
		}

	}
	public static void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("SaveData/PersonBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			personArray = (Person[]) ois.readObject();
			nElems = (int) ois.readObject();
			Person.setIdCounter((int) ois.readInt());
			ois.close();
		} catch (FileNotFoundException e) {
			Model.Util.failureAlert("Trouble finding PersonBag.dat");
		} catch (IOException e) {
			Model.Util.failureAlert("Trouble loading PersonBag.dat");
		} catch (ClassNotFoundException e) {
			Model.Util.failureAlert("Class not found exception occurred!");
		}
	}
	public void importFaculty() {
		File file = new File("import/Faculty.txt");
		try {
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				String[] tokens = input.nextLine().split(" ");
				Name name = new Name(tokens[0], tokens[1]);
				String[] tokens2 = input.nextLine().split(" ");
				String phone = input.nextLine();
				Address address = new Address(tokens2[0], tokens2[1] + " " + tokens2[2], tokens2[3], tokens2[4],tokens2[5]);
				double salary = Double.valueOf(input.nextLine());
				String title = input.nextLine();
				System.out.println(name);
				System.out.println(phone);
				System.out.println(address);
				System.out.println(salary);
				System.out.println(title);

			}
			input.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void exportStudentTextData() {
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
				Model.Util.failureAlert("Failure exporting Student data!");
			}
			for (int i = 0; i < getnElems(); i++) {
				Person person = personArray[i];
				if (person instanceof Student) {
					pw.println(person.toString());
				}
			}
			pw.close();
		}
	}

	public void exportFacultyTextData() {
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
				Model.Util.failureAlert("Failure exporting Faculty data!");
			}
			for (int i = 0; i < getnElems(); i++) {
				Person person = personArray[i];
				if (person instanceof Faculty) {
					pw.println(person.toString());
				}
			}
			pw.close();
		}
	}
	

	public static Person[] getPersonArray() {
		return Arrays.copyOf(personArray, getnElems());
	}

	public static int getnElems() {
		return nElems;
	}

	public static void setnElems(int nElems) {
		PersonBag.nElems = nElems;
	}

}
