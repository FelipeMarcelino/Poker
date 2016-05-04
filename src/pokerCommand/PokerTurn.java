package pokerCommand;

import game.Poker;

public class PokerTurn implements PokerCommand {
	private Poker poker;
	
	public PokerTurn(Poker poker){
		this.poker = poker;
	}
	
	@Override
	public void execute() {
		poker.turn();
		
	}
}
