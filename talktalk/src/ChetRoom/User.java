package ChetRoom;

import java.io.Serializable;
import java.net.Socket;

public class User implements Serializable {

	private static final long serialVersionUID = 1234L;

	private String id;
	private String pw;
	private String ip;
	private String port;
	private Socket sock;

	public User(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public void SetIp(String ip, String port) {
		this.ip = ip;
		this.port = port;
	}

	public void Setsock(Socket sock) {
		this.sock = sock;
	}

	public String getIp() {
		return this.ip;
	}

	public String getPort() {
		return this.port;
	}

	public Socket getSock() {
		return this.sock;
	}
}