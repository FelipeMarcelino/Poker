package pokerCommand;

import game.Poker;

public class PokerWhoWinsGame implements PokerCommand {
	private Poker poker;

	public PokerWhoWinsGame(Poker poker) {
		this.poker = poker;
	}

	@Override
	public void execute() {
		poker.whoWinsGame();

	}
}
