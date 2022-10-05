package DiceGame;

import java.util.*;

public class Dice {
	private int faceNum;
	public String DiceName;
	public Dice() {
		faceNum = 0;
	}
	
	public void rollDice() {
		Random random = new Random();
		this.faceNum = random.nextInt(6)+1;
	}
	public int CheckDiceNum() {
		return this.faceNum;
	}
}
