package chat_UI;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class signup {
	public signup() {
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

		JLabel login = new JLabel("아이디");
		JLabel pw = new JLabel("패스워드");

		JButton sign_btn = new JButton("회원가입");

		TextField login_tf = new TextField(10);
		TextField pw_tf = new TextField(10);
		pw_tf.setEchoChar('*');

		login.setBounds(50, 30, 120, 30);
		login_tf.setBounds(170, 30, 120, 30);
		pw.setBounds(50, 60, 120, 150);
		pw_tf.setBounds(170, 120, 122, 30);
		sign_btn.setBounds(110, 170, 122, 30);

		sign_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 아이디 비밀번호가 빈칸인지 확인하고 check로
				String id = login_tf.getText();
				String pw = pw_tf.getText();
				check c = new check();
				int che = c.check_field(id, pw, "회원가입");

				if (che == 1) {
					new login();
					frm.setVisible(false);
				}

			}
		});

		frm.getContentPane().add(login);
		frm.getContentPane().add(login_tf);
		frm.getContentPane().add(pw);
		frm.getContentPane().add(pw_tf);
		frm.getContentPane().add(sign_btn);

		frm.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new signup();
	}

}
