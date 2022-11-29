package ChetRoom;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class connect {

	public connect(String what) {
		try {

			Socket socket = new Socket("192.168.0.18", 8888);
			if (what == "send") {
				send(socket);
			} else if (what == "recv") {
				recv(socket);
			}
		} catch (IOException e1) {
			System.out.println("오류");
			e1.printStackTrace();
		}
	}

	public void send(Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();

		ObjectOutputStream oos = new ObjectOutputStream(os);

		MessageProtocol m = new MessageProtocol();
		oos.writeObject(m);
		oos.flush();
	}

	public void recv(Socket socket) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
