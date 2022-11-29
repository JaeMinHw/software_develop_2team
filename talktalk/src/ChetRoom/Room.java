package ChetRoom;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
	private static final long serialVersionUID = 4003L;
	public String RoomName;
	public ArrayList<User> userList = new ArrayList<>();

	public Room(String RoomName) {
		this.RoomName = RoomName;
	}
}