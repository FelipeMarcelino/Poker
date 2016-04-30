package gameCommand;

import deck.Deck;

public class ShuffleDeck implements GameCommand {
private Deck deck;
	
	public ShuffleDeck(Deck deck){
		this.deck = deck;
	}

	@Override
	public void execute() {
		deck.shuffleDeck();
		
	}
}
