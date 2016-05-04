package game;

public class InfoRound {

	private int minimumBet;
	private int totalPlayersInGame;
	private int whoWins;
	private boolean nextTurn;
	
	public int getWhoWins() {
		return whoWins;
	}

	public void setWhoWins(int whoWins) {
		this.whoWins = whoWins;
	}

	
	public int getMinimumBet() {
		return minimumBet;
	}
	public void setMinimumBet(int minimumBet) {
		this.minimumBet = minimumBet;
	}
	

	public void setPlayersInGame(int totalPlayersInGame){
		this.totalPlayersInGame = totalPlayersInGame;
	}
	
	public int getPlayersInGame(){
		return this.totalPlayersInGame;
	}

	public boolean isNextTurn() {
		return nextTurn;
	}

	public void setNextTurn(boolean nextTurn) {
		this.nextTurn = nextTurn;
	}
	
	
	
	
}
