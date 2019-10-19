package Model;

import java.io.Serializable;

public class Faculty extends Person implements Serializable {
	private String officeAddress;
	private double salary;
	private String title;

	public Faculty(Name name, String phone, Address address, String officeAddress, double salary, String title) {
		super(name, phone, address);
		this.officeAddress = officeAddress;
		this.salary = salary;
		this.title = title;
	}  
	public Faculty(Name name, String phone, Address address, double salary, String title) {
		super(name, phone, address);
		this.salary = salary;
		this.title = title;
	}  

	public Faculty(Name name, Address address, String phone, String tittle) {
		super(name, phone, address);
		this.title = tittle;
	}

	public Faculty() {
		super();
	}

	public Faculty(Faculty faculty) {
		super(faculty.getName(), faculty.getPhone(), faculty.getAddress());
		this.officeAddress = faculty.getOfficeAddress();
		this.salary = faculty.getSalary();
		this.title = faculty.getTitle();
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Faculty " + "\n\t Name = " + getName() + " ID = " + getId() + "\n\t Phone = " + getPhone() + ", title="
				+ title + "  \n\t Address = " + getAddress() + "\n\t office Address = " + officeAddress + ", salary = "
				+ salary;
	}

}
