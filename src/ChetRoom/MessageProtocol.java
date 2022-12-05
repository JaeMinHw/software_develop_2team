package ChetRoom;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageProtocol implements Serializable {
	private static final long serialVersionUID = 1000L;
	
	public String TYPE;
	public sendUser user;
	public Room room;
	public message msg;
	public ArrayList<String> RoomList;
}