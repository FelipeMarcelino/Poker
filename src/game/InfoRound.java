package game;

public class InfoRound {

	private int minimumBet;
	private int whoWinsRound;
	private int whoWinsTurn;
	private int totalBetTurn;
	private int totalBetRound;
	private int indexShowBoardCard = 3;
	private boolean nextTurn;

	
	public int getTotalBetTurn() {
		return totalBetTurn;
	}

	public void sumTotalBetTurn(int totalBetTurn) {
		this.totalBetTurn += totalBetTurn;
	}

	public int getTotalBetRound() {
		return totalBetRound;
	}

	public void sumTotalBetRound(int totalBetRound) {
		this.totalBetRound += totalBetRound;
	}	

	
	public int getWhoWinsRound() {
		return whoWinsRound;
	}

	public void setWhoWinsRound(int whoWinsRound) {
		this.whoWinsRound = whoWinsRound;
	}

	public int getWhoWinsTurn() {
		return whoWinsTurn;
	}

	public void setWhoWinsTurn(int whoWinsTurn) {
		this.whoWinsTurn = whoWinsTurn;
	}

	public int getMinimumBet() {
		return minimumBet;
	}
	public void setMinimumBet(int minimumBet) {
		this.minimumBet = minimumBet;
	}
	

	public boolean isNextTurn() {
		return nextTurn;
	}

	public void setNextTurn(boolean nextTurn) {
		this.nextTurn = nextTurn;
	}
	
	public void initTotalBetRound(){
		this.totalBetRound = 0;
	}
	
	public void initTotalBetTurn(){
		this.totalBetTurn = 0;
	}
	
	public void showBoardCard(ArrayList<Card> board){
		
	}
	
	
}
