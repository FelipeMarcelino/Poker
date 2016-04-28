package command;

import java.util.ArrayList;

import deck.*;

public class GetDeck implements Command <Void> {

	private ArrayList<Card> deck;
	
	public GetDeck(ArrayList<Card> deck){
		this.deck = deck;
	}
	
	@Override
	public Void execute() {
		
		
		for(int i = 0; i < 4; i++){
			for(int k = 0; k < 12; k++){
				this.deck.add(new Card (i,k));
			}
		}
		
		return null;
		
	}

}
