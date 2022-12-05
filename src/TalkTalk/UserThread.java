package TalkTalk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ChetRoom.MessageProtocol;
import ChetRoom.Room;
import ChetRoom.RoomControl;
import ChetRoom.User;

public class UserThread extends Thread{
	private final Socket sock;
	private String divisionRoomName;
	private User user;
	private Room room;
	
	public UserThread(Socket sock) {
		this.sock = sock;
	}
	
	
	@Override
	public void run() {
		
		ObjectInputStream recvData;
		MessageProtocol Buf;
		MessageProtocol sendMessage = new MessageProtocol();
		
		while(true) {
			try {
				recvData = new ObjectInputStream(sock.getInputStream());
				Buf = (MessageProtocol) recvData.readObject();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(room == null) {
					RoomControl.getRoom(room.RoomName).removeUser(user);
					if(RoomControl.getRoom(room.RoomName).userList.size() == 0) {
						RoomControl.removeRoom(room.RoomName);
					}
				}
				
				break;
			}
			
			System.out.println(Buf.TYPE);
			
			if(Buf.TYPE.equals("User")) {
				user = new User(Buf.user.id_name,"****");
				user.Setsock(sock);
				sendMessage.TYPE = "RoomList";
				sendMessage.RoomList = RoomControl.getRoomListName();
				for(String a : sendMessage.RoomList) {
					System.out.println(a);
				}
				try {
					ObjectOutputStream sendWriter = new ObjectOutputStream(user.getSock().getOutputStream());
					sendWriter.writeObject(sendMessage);
					sendWriter.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(Buf.TYPE.equals("room")) {
				Room tmpRoom = RoomControl.getRoom(Buf.room.RoomName);
				tmpRoom.addUser(user);
				this.room = tmpRoom;
			}
			
			if(Buf.TYPE.equals("add Room")) {
				RoomControl.addRoom(Buf.room);
				this.room = Buf.room;
				Buf.room.addUser(user);
			}
			
			if(Buf.TYPE.equals("Send Message")) {
				System.out.println(Buf.user.id_name);
				System.out.println(Buf.msg.msg);
				try {
					room.SendMessage(Buf);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
