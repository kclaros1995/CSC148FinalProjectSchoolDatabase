package Model;

import java.io.Serializable;

public class InvalidPhoneException extends Exception implements Serializable{
	public InvalidPhoneException(String message) {
		super(message);
	}
} 
