package TalkTalk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import ChetRoom.*;

public class TalkTalk {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int port=8888;
		ServerSocket socket = new ServerSocket(port);
		
		InetAddress local = InetAddress.getLocalHost();
        System.out.println("My PC IP :" + local.getHostAddress());
		System.out.println("접속대기중");
		
		while(true) {
			Socket sock = socket.accept();
			
			System.out.println("사용자가 접속했습니다.");
			System.out.println("Client : "+sock.getInetAddress()+":"+sock.getPort());
			UserThread UserThread = new UserThread(sock);
			UserThread.start();
		}
	}

}
