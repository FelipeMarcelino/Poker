package pokerCommand;

import game.Poker;

public class PokerRiver implements PokerCommand{
	private Poker poker;
	
	public PokerRiver(Poker poker){
		this.poker = poker;
	}
	
	@Override
	public void execute() {
		poker.river();
		
	}
}	
