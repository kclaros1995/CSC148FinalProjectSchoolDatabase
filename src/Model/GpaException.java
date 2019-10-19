package Model;

import java.io.Serializable;

public class GpaException extends Exception implements Serializable{
	public GpaException(String message) {
		super(message); 
	}

}
