package pokerCommand;

import game.Poker;

public class PokerGenerate implements PokerCommand {

	private Poker poker;

	public PokerGenerate(Poker poker) {
		this.poker = poker;
	}

	@Override
	public void execute() {
		poker.generate();

	}

}
