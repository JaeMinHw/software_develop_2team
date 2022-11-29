package chat_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import ChetRoom.MessageProtocol;
import ChetRoom.message;

public class chat extends Thread {

	public chat() {
		JFrame frm = new JFrame();

		// ★ 프레임 제목 설정
		frm.setTitle("톡톡 프로그램");

		// 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);

		frm.getContentPane().setLayout(null);

		// 프레임을 닫았을 때 프로그램이 종료되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임 크기 설정
		frm.setSize(620, 800);
		JTextArea chat = new JTextArea("", 600, 700);
		JTextArea send_chat = new JTextArea("", 300, 80);

		JButton send_chat_btn = new JButton("전송");

		chat.setBounds(50, 30, 500, 600);
		send_chat.setBounds(150, 650, 300, 40);
		send_chat_btn.setBounds(470, 655, 80, 30);

		chat.setEditable(false);
		frm.add(chat);
		frm.add(send_chat_btn);
		frm.add(send_chat);

		frm.setVisible(true);

		send_chat_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chat.setText(chat.getText() + "\r\n" + who.id_name + " : " + send_chat.getText());
				send_chat.setText("");
			}
		});
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		chat c = new chat();
		Socket sock = new Socket("192.168.0.18", 8888);
		System.out.println("서버와 접속되었습니다.");
		ReceiveThread receiveThread = new ReceiveThread(sock);
		receiveThread.start();
		SendThread sendThead = new SendThread(sock);
		sendThead.start();
	}

}

class SendThread extends Thread {

	private final Socket socket;
	Scanner scanner = new Scanner(System.in);

	public SendThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {

			Socket socket = new Socket("192.168.0.18", 8888);
			OutputStream os = socket.getOutputStream();

			ObjectOutputStream oos = new ObjectOutputStream(os);

			message ms = new message();
			ms.type = "send";

			MessageProtocol m = new MessageProtocol();

			oos.writeObject(m);
			oos.flush();
		} catch (IOException e1) {
			System.out.println("오류");
			e1.printStackTrace();
		}

	}

}