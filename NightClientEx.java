package soket_t;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;

public class NightClientEx implements Serializable {
	Socket client = null;
	String ip;

	static final int PORT = 7001;
	BufferedReader reader;

	InputStream is;
	ObjectInputStream ois;

	OutputStream os;
	ObjectOutputStream oos;

	String sendData;
	String sendcount;
	String receiveData;
	String receivecount;

	public NightClientEx(String ip) {

		this.ip = ip;
		try {
			System.out.println("*****클라이언트(사용자)******");

			client = new Socket(ip, PORT);

			reader = new BufferedReader(new InputStreamReader(System.in));

			os = client.getOutputStream();
			oos = new ObjectOutputStream(os);

			is = client.getInputStream();
			ois = new ObjectInputStream(is);

			System.out.println("입력>>");
			while ((sendData = reader.readLine()) != null) {
				sendcount = reader.readLine();
				oos.writeObject(sendData);
				oos.writeObject(sendcount);
				oos.flush();
				if (sendData.equals("quit"))
					break;
				for (int i = 0; i < Integer.parseInt(sendcount); i++) {
					receiveData = String.valueOf(ois.readObject());
					System.out.println(client.getInetAddress() + "로 부터 받은 메시지: " + receiveData);
				}

				System.out.print("입력>>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				is.close();
				ois.close();
				os.close();
				oos.close();
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new NightClientEx("127.0.0.1");
	}
}