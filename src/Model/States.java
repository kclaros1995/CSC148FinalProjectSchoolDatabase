package Model;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class States {

	private File file = new File("Import/States.txt");
	private static List<String> states = new ArrayList<>();

	public List<String> getStates() {
		return states;
	} 
 
	public States() {
		Scanner scanner;
		try {
			scanner = new Scanner(new FileInputStream(file));
			while (scanner.hasNextLine()) {
				states.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

}