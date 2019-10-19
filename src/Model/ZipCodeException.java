package Model;

import java.io.Serializable;

public class ZipCodeException extends Exception implements Serializable{
	public ZipCodeException(String message) {
		super(message);
	}

}
