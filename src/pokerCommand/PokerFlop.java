package pokerCommand;

import game.Poker;

public class PokerFlop implements PokerCommand {
private Poker poker;
	
	public PokerFlop(Poker poker){
		this.poker = poker;
	}
	
	@Override
	public void execute() {
		poker.flop();
		
	}
}
