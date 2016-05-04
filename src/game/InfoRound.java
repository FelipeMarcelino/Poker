package game;

public class InfoRound {

	private int minimumBet;
	private int whoPlayerTurn;
	private int totalPlayers;
	
	public void setTotalPlayers(int totalPlayers){
		this.totalPlayers = totalPlayers;
	}
	
	public int getMinimumBet() {
		return minimumBet;
	}
	public void setMinimumBet(int minimumBet) {
		this.minimumBet = minimumBet;
	}
	
	public void setFirstPlayer(int whoPlayerTurn) {
		this.whoPlayerTurn = whoPlayerTurn;
	}
	
	public int rotateTurnPlayer(){
		this.whoPlayerTurn += 1;
		if(this.whoPlayerTurn == this.totalPlayers) this.whoPlayerTurn = 0;
		return this.whoPlayerTurn;
	}
	
}
