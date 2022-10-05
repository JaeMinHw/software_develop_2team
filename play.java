package DiceGame;

import java.util.Scanner;

public class play {
	private player p1,p2;
	
	public play() {
		p1 = new player("player1");
		p2 = new player("player2");
	}
	
	public void StartGame(){
		int Check;
		Scanner in = new Scanner(System.in);
		System.out.println("���� ����");
		System.out.println("player1 : "+p1.GetWinCount()+"��");
		System.out.println("player2 : "+p2.GetWinCount()+"��");
		while(true) {
			System.out.print("���� �� �����մϴ�.(1.�����ϱ� 2.�����ϱ�)");
			Check = in.nextInt();
			if(Check==1) {
				PlayGame();
			}
			else if(Check==2) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			else {
				System.out.println("�ٽ� �Է��� �ּ���");
			}
				
		}
	}
	
	public void PlayGame() {
		Scanner in = new Scanner(System.in);
		int Check;
		System.out.println("\n\n\n\n������ ���� �մϴ�.");
		System.out.println("�ֻ����� �����ϴ�.");
		
		this.p1.RollDice();
		this.p2.RollDice();
		
		while(true) {
			System.out.println("HIGH or LOW?(1.HIGH 2.LOW)");
			Check = in.nextInt();
			if(Check == 1 || Check == 2) {
				break;
			}
		}
		System.out.println("player1 : "+p1.CheckDiceNum()[0]+", "+p1.CheckDiceNum()[1]);
		System.out.println("player2 : "+p2.CheckDiceNum()[0]+", "+p2.CheckDiceNum()[1]);
		if(Check ==1) {
			if(p1.CheckDiceNum()[1]>p2.CheckDiceNum()[1]) {
				System.out.println("player1�� �̰���ϴ�.");
				p1.PlusWinCount();
			}
			else {
				System.out.println("player2�� �̰���ϴ�.");
				p2.PlusWinCount();
			}
		}
		
		else if(Check == 2) {
			if(p1.CheckDiceNum()[0]<p2.CheckDiceNum()[0]) {
				System.out.println("player1�� �̰���ϴ�.");
				p1.PlusWinCount();
			}
			else {
				System.out.println("player2�� �̰���ϴ�.");
				p2.PlusWinCount();
			}
		}
		
	}
}
