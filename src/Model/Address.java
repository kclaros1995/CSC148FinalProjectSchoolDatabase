package Model;


import java.io.Serializable;
import java.util.Scanner;

import javafx.scene.control.SingleSelectionModel;

public class Address implements Serializable{
	private String streetNumber;
	private String streetName;
	private String city;
	private String state ;
	private String zip;

	private final double ZIP_LENGTH = 5;

	public Address(String streetNumber, String streetName, String city, String state, String zip) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state; 
		checkZipCode(zip);
	}

	public Address(Address address) {
		this.streetNumber = address.getStreetNumber();
		this.streetName = address.getStreetName();
		this.city = address.getCity();
		this.state = address.getState();
		checkZipCode(zip);
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		checkZipCode(zip);
	}

	public void checkZipCode(String zip) {
		if (zip.length() < ZIP_LENGTH) {
			try {
				throw new ZipCodeException("zip too short, please provide a valid zip: ");
			} catch (ZipCodeException e) {
				e.getMessage();
				System.out.println(e.getMessage());
				checkZipCode(getNewZip());
			}
		} else if (zip.length() > ZIP_LENGTH) {
			try {
				throw new ZipCodeException("zip too long, please provide a valid zip: ");
			} catch (ZipCodeException e) {
				e.getMessage();
				System.out.println(e.getMessage());
				checkZipCode(getNewZip());
			}
		} else
			this.zip = zip;
	}

	public String getNewZip() {
		String tempZip = " ";
		Scanner kb = new Scanner(System.in);
		tempZip = kb.nextLine();
		return tempZip;
	}

	@Override
	public String toString() {
		return "Address [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}

}
