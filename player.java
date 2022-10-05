package DiceGame;

public class player {
	private String playerName;
	private int winCount;
	private Dice d1, d2;
	public player(String name) {
		this.playerName = name;
		winCount = 0;
		d1 = new Dice();
		d2 = new Dice();
	}
	public void RollDice() {
		d1.rollDice();
		d2.rollDice();
	}
	public void PlusWinCount() {
		this.winCount +=1;
	}
	public int[] CheckDiceNum() {
		int[] NumArray = {this.d1.CheckDiceNum(),this.d2.CheckDiceNum()};
		if(this.d1.CheckDiceNum()>this.d2.CheckDiceNum()) {
			NumArray[0] = this.d2.CheckDiceNum();
			NumArray[1] = this.d1.CheckDiceNum();
		}
		return NumArray;
	}
	public int GetWinCount() {
		return this.winCount;
	}
	public String GetPlayerName() {
		return this.playerName;
	}
}