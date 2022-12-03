package ChetRoom;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class connect extends Thread {
	Socket socket;

	public void firstconnect() {
		try {
			socket = new Socket("192.168.0.18", 8888);
			new ReadThread(socket).start();
		} catch (IOException e1) {
			System.out.println("오류");
			e1.printStackTrace();
		}
	}

	public void send() throws IOException {
		OutputStream os = socket.getOutputStream();

		ObjectOutputStream oos = new ObjectOutputStream(os);

		MessageProtocol m = new MessageProtocol();
		oos.writeObject(m);
		oos.flush();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ReadThread extends Thread {

	Socket socket;

	public ReadThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// TODO Auto-generated method stub
		super.run();

		// receive : 받기
		try {
			while (true) {
				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				MessageProtocol mp = (MessageProtocol) ois.readObject();

				Thread.sleep(300); // 시간은 맞춰놓는 것이 좋음
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
