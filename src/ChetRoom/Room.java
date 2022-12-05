package ChetRoom;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
	private static final long serialVersionUID = 4003L;
	public String RoomName;
	public ArrayList<User> userList =new ArrayList<>();
	
	public Room(String RoomName) {
		this.RoomName = RoomName;
	}
	
	public void addUser(User u) {
		userList.add(u);
	}
	
	public void removeUser(User u) {
		for(User ul: userList) {
			if(ul.getIp().equals(u.getIp()) && ul.getPort().equals(u.getPort()) ) {
				userList.remove(ul);
				break;
			}
		}
		
	}
	
	public void SendMessage(MessageProtocol msg) throws IOException {
		for(User ul: userList) {
			ObjectOutputStream sendWriter = new ObjectOutputStream(ul.getSock().getOutputStream());
			sendWriter.writeObject(msg);
			sendWriter.flush();
		}
	}
	
}
