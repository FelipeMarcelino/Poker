package command;

import java.util.ArrayList;

import deck.*;

public class GetDeck implements Command <ArrayList<Card>> {

	@Override
	public ArrayList<Card> execute() {
		
		return Deck.generateDeck() ;
	}

}
