package game;

public class InfoRound {

	private int minimumBet;
	private int whoPlayerTurn;
	private int totalPlayers;
	private int totalPlayersInGame;
	private int whoWins;
	
	public int getWhoWins() {
		return whoWins;
	}

	public void setWhoWins(int whoWins) {
		this.whoWins = whoWins;
	}

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
	
	public void setPlayersInGame(int totalPlayersInGame){
		this.totalPlayersInGame = totalPlayersInGame;
	}
	
	public int getPlayersInGame(){
		return this.totalPlayersInGame;
	}
	
	
	
}
