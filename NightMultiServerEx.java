package soket_t;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class EchoServerThread implements Runnable {
	Socket child;

	InputStream is;
	ObjectInputStream ois;

	OutputStream os;
	ObjectOutputStream oos;

	String receiveData;
	String receivecount;

	public EchoServerThread(Socket s) {
		child = s;
		try {
			System.out.println(child.getInetAddress() + "로 부터 연결 요청을 받음");

			is = child.getInputStream();
			ois = new ObjectInputStream(is);
			os = child.getOutputStream();
			oos = new ObjectOutputStream(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<String> ch = new ArrayList<String>();
		try {
			while (true) {
				receiveData = (String) ois.readObject();
				receivecount = (String) ois.readObject();

				int ch_rec = Integer.parseInt(receivecount);
				System.out.println(child.getInetAddress() + "의 메시지 : " + receiveData);
				System.out.println(child.getInetAddress() + "의 메시지 : " + receivecount);
				for (int i = 0; i < ch_rec; i++) {
					oos.writeObject(receiveData);
					oos.flush();
				}

			}
		} catch (Exception e) {
			System.out.println("클라이언트가 강제 종료");
		} finally {
			try {
				is.close();
				os.close();
				ois.close();
				oos.close();
				child.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class NightMultiServerEx {
	ServerSocket server;
	static final int PORT = 7001;
	Socket child;

	public NightMultiServerEx() {
		try {
			server = new ServerSocket(PORT);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("****** 다중 사용자 접속 채팅 서버 *****");
		System.out.println("서버는 클라이언트 소켓의 접속 요청을 기다리고 있음.");

		while (true) {
			try {
				child = server.accept();

				EchoServerThread childThread = new EchoServerThread(child);
				Thread t = new Thread(childThread);
				t.start();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new NightMultiServerEx();
	}

}
