package chat_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class home extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ★ 프레임 생성
		JFrame frm = new JFrame();

		// ★ 프레임 제목 설정
		frm.setTitle("톡톡 프로그램");

		// 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);

		frm.getContentPane().setLayout(null);

		// 프레임을 닫았을 때 프로그램이 종료되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임 크기 설정
		frm.setSize(350, 300);

		JButton btn1 = new JButton("로그인");
		JButton btn2 = new JButton("회원가입");

		btn1.setBounds(30, 170, 122, 30);
		btn2.setBounds(182, 170, 122, 30);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new login();
				frm.setVisible(false);
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new signup();
				frm.setVisible(false);
			}
		});

		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);

		frm.setVisible(true);
	}

}
