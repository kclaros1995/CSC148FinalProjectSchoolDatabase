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
import java.util.Scanner;

public abstract class Person implements Serializable {
	private Name name;
	private String id;
	private String phone;
	private Address address;
	private transient Scanner input;

	private final double PHONE_LENGHT = 10;

	private static int idCounter = 1;

	public Person(Name name, String phone, Address address) {
		super();
		this.name = name;
		setId(id);
		checkPhoneNumber(phone);
		this.address = address;  
	}

	public Person() {
		this.id = getId();
		setId(id);
	}

	public Person(Name name, String phone) {
		super();
		setId(id);
		this.name = name;
		this.phone = phone;
	}

	public Person(Name name) {
		super();
		setId(id);
		this.name = name;
	}

	public Person(Person person) {
		setId(id);
		this.name = person.getName();
		this.id = person.getId();
		checkPhoneNumber(phone);
		this.address = person.getAddress();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = String.valueOf(idCounter++);// this is a new part
	}

	public String getPhone() {
		String s1 = "6311234567";
		String s2 = "(631)1234567";
		String s3 = "(631)123.4567";
		String s4 = "(631)123-4567";
		String s5 = "631-123-4567";

		boolean b = s1.matches("[(]?(\\d{3})[)]?[.-]?(\\d{3})[.-]?(\\d{4})");
		String standardizedPhoneNumber = "";
		if (b) {
			standardizedPhoneNumber = this.phone.replaceAll("[(]?(\\d{3})[)]?[.-]?(\\d{3})[.-]?(\\d{4})", "$1-$2-$3");
		}
		return standardizedPhoneNumber;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setName(String fName, char mInitial, String lName) {
		this.name = new Name(fName, mInitial, lName);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAddress(String streetNumber, String streetName, String city, String state, String zip) {
		this.address = new Address(streetNumber, streetName, city, state, zip);
	}

	public void checkPhoneNumber(String phone) {
		if (phone.length() < PHONE_LENGHT) {
			try {
				throw new InvalidPhoneException("Phone number is too short");
			} catch (InvalidPhoneException e) {
				e.getMessage();
				System.out.println(e.getMessage());
				checkPhoneNumber(getNewPhone());
			}
		} else if (phone.length() > PHONE_LENGHT) {
			try {
				throw new InvalidPhoneException("Phone number is too long");
			} catch (InvalidPhoneException e) {
				e.getMessage();
				System.out.println(e.getMessage());
				checkPhoneNumber(getNewPhone());
			}
		} else
			this.phone = phone;
	}

	public String getNewPhone() {
		String temPphone = " ";
		input = new Scanner(System.in);
		System.out.println("Please re-enter correct phone length, else will be set to zero: ");
		temPphone = input.nextLine();
		return temPphone;

	}
	


	public static int getIdCounter() {
		return idCounter;
	}

	public static void saveIdCounter() {
		try {
			FileWriter fw = new FileWriter("SaveData/idCounter.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write(idCounter);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


	public static void loadIdCounter() {
		File file = new File("SaveData/idCounter.txt");
		try {
			Scanner scanner = new Scanner(file);
			idCounter = scanner.nextInt();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", address=" + address + "]";
	}


	public static void setIdCounter(int idCounter) {
		Person.idCounter = idCounter;
	}

}