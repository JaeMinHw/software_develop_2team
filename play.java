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
		System.out.println("현재 전적");
		System.out.println("player1 : "+p1.GetWinCount()+"승");
		System.out.println("player2 : "+p2.GetWinCount()+"승");
		while(true) {
			System.out.print("게임 을 시작합니다.(1.게임하기 2.종료하기)");
			Check = in.nextInt();
			if(Check==1) {
				PlayGame();
			}
			else if(Check==2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println("다시 입력해 주세요");
			}
				
		}
	}
	
	public void PlayGame() {
		Scanner in = new Scanner(System.in);
		int Check;
		System.out.println("\n\n\n\n게임을 시작 합니다.");
		System.out.println("주사위를 던집니다.");
		
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
				System.out.println("player1이 이겻습니다.");
				p1.PlusWinCount();
			}
			else {
				System.out.println("player2가 이겻습니다.");
				p2.PlusWinCount();
			}
		}
		
		else if(Check == 2) {
			if(p1.CheckDiceNum()[0]<p2.CheckDiceNum()[0]) {
				System.out.println("player1이 이겻습니다.");
				p1.PlusWinCount();
			}
			else {
				System.out.println("player2가 이겻습니다.");
				p2.PlusWinCount();
			}
		}
		
	}
}
