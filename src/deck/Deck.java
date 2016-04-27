package deck;

import java.util.ArrayList;

public class Deck {
	
	private static ArrayList <Card> deck = new ArrayList<Card>();
	
	
	public static ArrayList<Card> generateDeck(){
		
		for(int i = 0; i < 4; i++){
			for(int k = 0; k < 12; k++){
				deck.add(new Card (i,k));
			}
		}
		
		return deck;
	}
	
}
