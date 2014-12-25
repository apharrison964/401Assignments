package lec10.ex1;

public class Room {
	
	private String building;
	private int room_number;
	
	Room(String building, int room_number) {
		this.building = building;
		this.room_number = room_number;
	}
	
	public String toString() {
		return room_number + " " + building;
	}
}
