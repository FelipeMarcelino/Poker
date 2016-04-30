package generateCommand;

import Deck.Deck;

public class GenerateDeck implements GenerateCommand{
	private Deck deck;
	
	public GenerateDeck(Deck deck){
		this.deck = deck;
	}

	@Override
	public void execute() {
		deck.generateDeck();
	}
	
	
	
}
