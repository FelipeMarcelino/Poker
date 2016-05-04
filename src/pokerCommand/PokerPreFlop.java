package pokerCommand;

import game.Poker;

public class PokerPreFlop implements PokerCommand {
	private Poker poker;
	
	public PokerPreFlop(Poker poker){
		this.poker = poker;
	}
	
	@Override
	public void execute() {
		poker.preFlop();
		
	}
}
