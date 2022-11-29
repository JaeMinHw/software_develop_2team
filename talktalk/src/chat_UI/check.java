package chat_UI;

import javax.swing.JOptionPane;

public class check {

	public int check_field(String id, String pw, String ch) {
		if (id.trim().isEmpty() || pw.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "등록할 아이디 또는 비밀번호를 입력해주세요");
			return 0;
		} else {
			JOptionPane.showMessageDialog(null, ch + "에 성공하셨습니다.");
			return 1;
		}

	}

	public int check_title(String title, String ch) {
		if (title.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "채팅방 제목을 입력해주세요");
			return 0;
		} else {
			JOptionPane.showMessageDialog(null, ch + "에 성공하셨습니다.");
			return 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
