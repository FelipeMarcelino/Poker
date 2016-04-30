package auxCommand;

import deck.Deck;

public class ShuffleDeck implements AuxCommand {
private Deck deck;
	
	public ShuffleDeck(Deck deck){
		this.deck = deck;
	}

	@Override
	public void execute() {
		this.deck.shuffleDeck();
	}

	

	
}
