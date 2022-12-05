package ChetRoom;

import java.util.ArrayList;

public class RoomControl {
	private volatile static ArrayList<Room> roomList = new ArrayList<>();
	private volatile static int RoomCount = 0;
	
	public static synchronized void addRoom(Room room) {
		if(findRoom(room.RoomName)!=-1) {return;}
		
		roomList.add(room);
		RoomCount+=1;
	}
	
	public static synchronized void removeRoom(String RoomName) {
		int getRoom =findRoom(RoomName);
		
		if(getRoom==-1) {return;}
		
		RoomCount-=1;
		roomList.remove(getRoom);
	}
	
	public static Room getRoom(String RoomName) {
		int getRoom =findRoom(RoomName);
		
		if(getRoom==-1) {return null;}
		
		return roomList.get(getRoom);
	}
	
	public static ArrayList<String> getRoomListName() {
		ArrayList<String> RoomNames = new ArrayList<String>();
		
		for(Room room : roomList) {
			RoomNames.add(room.RoomName);
		}
		return RoomNames;
	}
	
	public static ArrayList<Room> getRoomList() {
		return roomList;
	}
	
	public static int findRoom(String RoomName) {
		int Count = 0;
		int where = -1;
		for(Room r:roomList) {
			if(r.RoomName.equals(RoomName)) {
				where = Count;
			}
			Count+=1;
		}
		return where;
	}

}
