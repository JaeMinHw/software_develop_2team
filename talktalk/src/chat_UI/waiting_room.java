package chat_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import ChetRoom.MessageProtocol;
import ChetRoom.Room;
import ChetRoom.connect;

public class waiting_room extends JFrame {

	public waiting_room() {
		ArrayList<String> RoomList = null;
//		try {
//
//			Socket socket = new Socket("192.168.0.18", 8888);
//
//			InputStream is = socket.getInputStream();
//
//			ObjectInputStream ois = new ObjectInputStream(is);
//
//			MessageProtocol m = new MessageProtocol();
//			if (m.TYPE == "RoomList") {
//				RoomList = (ArrayList<String>) ois.readObject();
//			}
//
//		} catch (IOException e1) {
//			System.out.println("오류");
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String[] room = { "수다 떨 사람", "롤 같이 할 사람", "배그 듀오", "배그 스쿼드", "노래방" };
		JFrame frm = new JFrame();
		// ★ 프레임 제목 설정
		frm.setTitle("톡톡 프로그램");

		// 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);

		frm.getContentPane().setLayout(null);

		// 프레임을 닫았을 때 프로그램이 종료되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		JList scrollList = new JList(RoomList.toArray());
		JList scrollList = new JList(room);

		JLabel text = new JLabel("현재 참가할 수 있는 채팅방");

		who w = new who();
		JLabel who = new JLabel(w.id_name + "님");

		JButton btn1 = new JButton("방 만들기");

		scrollList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frm.add(new JScrollPane(scrollList));

		scrollList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// 서버에 해당 채팅방 제목 전송 후 해당하는 채팅방으로 이동

					String item = scrollList.getSelectedValue().toString(); // list를 클릭했을 때 데이터 가져오기

					// Jlabel에 출력
					System.out.println(item);

					// 서버에 객체 전송해서
					Room room = new Room(item);

					MessageProtocol m = new MessageProtocol();
					m.TYPE = "room";
					m.room = room;

					new connect("send");
					new chat();
					frm.setVisible(false);
				}
			}
		});

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new create_room();
				frm.setVisible(false);
			}
		});

		// 프레임 크기 설정
		frm.setSize(700, 700);

		btn1.setBounds(400, 170, 122, 30);
		scrollList.setBounds(50, 50, 300, 500);
		text.setBounds(120, 30, 200, 15);
		who.setBounds(450, 30, 50, 15);

		frm.add(scrollList);
		frm.add(text);
		frm.add(who);
		frm.getContentPane().add(btn1);

		frm.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new waiting_room();
	}

}
