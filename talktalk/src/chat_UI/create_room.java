package chat_UI;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ChetRoom.MessageProtocol;
import ChetRoom.Room;
import ChetRoom.connect;

public class create_room {

	public create_room() {
		JFrame frm = new JFrame();

		// ★ 프레임 제목 설정
		frm.setTitle("톡톡 프로그램");

		// 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);

		frm.getContentPane().setLayout(null);

		// 프레임을 닫았을 때 프로그램이 종료되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임 크기 설정
		frm.setSize(350, 250);

		JLabel title = new JLabel("채팅방 제목");
		JButton create = new JButton("생성");

		TextField title_tf = new TextField(10);

		title.setBounds(50, 60, 120, 30);
		title_tf.setBounds(170, 60, 120, 30);
		create.setBounds(110, 130, 122, 30);

		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String create_title = title_tf.getText();
				check c = new check();
				int che = c.check_title(create_title, "채팅방 생성");

				if (che == 1) {

					Room room = new Room(create_title);

					MessageProtocol m = new MessageProtocol();
					m.TYPE = "Room";
					m.room = room;

					new connect("send");

					new chat();

					frm.setVisible(false);
				}

			}
		});

		frm.getContentPane().add(title);
		frm.getContentPane().add(title_tf);
		frm.getContentPane().add(create);

		frm.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new create_room();
	}

}
