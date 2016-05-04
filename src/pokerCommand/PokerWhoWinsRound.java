package pokerCommand;

import game.Poker;

public class PokerWhoWinsRound implements PokerCommand{
	private Poker poker;
	
	public PokerWhoWinsRound(Poker poker){
		this.poker = poker;
	}
	
	@Override
	public void execute() {
		poker.whoWinsRound();;
		
	}
}
