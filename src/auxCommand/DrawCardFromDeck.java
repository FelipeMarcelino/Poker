package auxCommand;

import java.util.ArrayList;

import deck.Card;
import deck.Deck;
import player.PlayersList;

public class DrawCardFromDeck implements AuxCommand {
	private PlayersList playersList;
	private Deck deck;
	private ArrayList<Card> board;
	private int playerIndex;

	public DrawCardFromDeck(PlayersList playersList, Deck deck, ArrayList<Card> board) {
		this.playersList = playersList;
		this.deck = deck;
		this.board = board;
	}

	@Override
	public void execute() {
		this.playerIndex = -1;
		for (int i = 0; i < this.playersList.getSizeList() * 2; i++) {
			if (i % 2 == 0)
				this.playerIndex++;
			this.playersList.selectPlayer(this.playerIndex).receiveCard(this.deck.drawCardFromDeck(i));
		}

		this.board.clear();

		for (int i = this.playersList.getSizeList() * 2; i < this.playersList.getSizeList() * 2 + 5; i++) {
			this.board.add(this.deck.drawCardFromDeck(i));
		}

	}
}
