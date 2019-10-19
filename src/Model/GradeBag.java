package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GradeBag {
	private Grade[] gradeArray;
	private int nElems;

	public GradeBag(int maxSize) {
		gradeArray = new Grade[maxSize];
		nElems = 0;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(gradeArray[i]);
		}
	}
	public void insert(Grade grade) {
		gradeArray[nElems++] = grade;
	}
	
	public Grade[] getGradeArray() {
		return Arrays.copyOf(gradeArray, nElems);
	}
	
	
	public void importData() {
		File file = new File("Import/grades.txt");
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				String[] tokens = in.nextLine().split(", ");
				Grade grade = new Grade(tokens[0], tokens[1]);
				insert(grade);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}