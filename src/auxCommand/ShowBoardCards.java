package auxCommand;

import java.util.ArrayList;

import deck.Card;
import game.InfoRound;

public class ShowBoardCards implements AuxCommand {

	private ArrayList<Card> board;
	private InfoRound infoRound;

	public ShowBoardCards(ArrayList<Card> board, InfoRound infoRound) {
		this.board = board;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.infoRound.showBoardCard(this.board);
	}

}
