package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TextbookBag implements Serializable {
	private static Textbook[] textbookArray;
	private static int nElems;

	public TextbookBag(int maxSize) {
		textbookArray = new Textbook[maxSize];
		nElems = 0;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(textbookArray[i]);
		}
		System.out.println();
	}

	public void insert(Textbook textbook) {
		textbookArray[nElems++] = textbook;
	}

	public Textbook findByIsbn(String isbn) {
		for (int i = 0; i < nElems; i++) {
			if (textbookArray[i].getIsbn().equals(isbn)) {
				return textbookArray[i];
			}
		}
		return null;
	}

	public Textbook removeByIsbn(String isbn) {
		int indexFound;
		for (indexFound = 0; indexFound < nElems; indexFound++) {
			if (textbookArray[indexFound].getIsbn().equals(isbn)) {
				break;
			}
		}
		if (indexFound == nElems) {
			return null;
		} else {
			Textbook temp = textbookArray[indexFound];
			for (int i = indexFound; i < nElems - 1; i++) {
				textbookArray[i] = textbookArray[i + 1];
			}
			nElems--;
			return temp;
		}

	}

	public static void save() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("SaveData/TextbookBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(textbookArray);
			oos.writeObject(nElems);
			oos.close();
		} catch (FileNotFoundException e) {
			Model.Util.failureAlert("Failure finding TextbookBag.dat file!");
		} catch (IOException e) {
			Model.Util.failureAlert("Failure saving TextbookBag.dat file!");
		}

	}

	public static void load() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("SaveData/TextbookBag.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			textbookArray = (Textbook[]) ois.readObject();
			nElems = (int) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			Model.Util.failureAlert("Trouble finding Textbook.dat");
		} catch (IOException e) {
			Model.Util.failureAlert("Trouble loading Textbook.dat");
		} catch (ClassNotFoundException e) {
			Model.Util.failureAlert("Class not found exception occurred!");
		}
	}

	public void exportTextbookTextData() {
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
				Model.Util.failureAlert("Failure exporting textbook data!");
			}
			for (int i = 0; i < nElems; i++) {
				Textbook textbook = textbookArray[i];
				pw.println(textbook.toString());
			}
			pw.close();
		}
	}

	public void imporTextbookTextData() {
		File file = new File("import/Textbook.txt");
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String title = scanner.nextLine();
					String[] tokens = scanner.nextLine().split("[.]?");
					Name author = new Name(tokens[0], tokens[1]);
					String publisher = scanner.nextLine();
					String isbn = scanner.nextLine();
					Textbook textbook = new Textbook(title, author, publisher, isbn,
							Double.valueOf(scanner.nextLine()));
					insert(textbook);
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

	}

	public static int getnElems() {
		return nElems;
	}

	public static Textbook[] getTextbookArray() {
		return Arrays.copyOf(textbookArray, nElems);
	}

}
