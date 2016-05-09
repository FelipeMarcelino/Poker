package pokerCommand;

import game.Poker;

public class PokerTurns implements PokerCommand {
	private Poker poker;
	
	public PokerTurns(Poker poker){
		this.poker = poker;
	}
	
	@Override
	public void execute() {
		poker.Turns();
		
	}
}
