package Model;

import java.io.Serializable;

public class Name implements Serializable{
	private String fName;
	private String lName;
	private char mInitial; 
	public Name(String fName,  char mInitial, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.mInitial = mInitial;
	}
	public Name(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}
	public Name(Name name) {
		this.fName = name.getfName();
		this.lName = name.getlName();
		this.mInitial = name.getmInitial();
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public char getmInitial() {
		return mInitial;
	}
	public void setmInitial(char mInitial) {
		this.mInitial = mInitial;
	}
	@Override
	public String toString() {
		return "Name [fName=" + fName + ", lName=" + lName + ", mInitial=" + mInitial + "]";
	}
	
	

}
