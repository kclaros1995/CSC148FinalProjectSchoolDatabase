package Model;

import java.io.Serializable;

public class Classroom implements Serializable{
	private String roomNumber;
	private int capacity;
	private boolean hasProjector;

	public Classroom(String roomNumber, int capacity, boolean hasProjector) {
		super();
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.hasProjector = hasProjector;
	} 
	public Classroom(Classroom classroom) {
		this.roomNumber = classroom.getRoomNumber();
		this.capacity = classroom.getCapacity();
		this.hasProjector = classroom.hasProjector;
	}
	public Classroom() {
		
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean getHasProjector() {
		return hasProjector;
	}

	public void setHasProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}

	@Override
	public String toString() {
		return "Classroom [roomNumber=" + roomNumber + ", capacity=" + capacity + ", hasProjector=" + hasProjector
				+ "]";
	}

}