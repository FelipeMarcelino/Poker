package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

	ArrayList<Card> deck = new ArrayList<Card>();
	private long seed;

	public void generateDeck() {
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 13; k++) {
				this.deck.add(new Card(i, k));
			}
		}

	}

	public void shuffleDeck() {
		this.seed = System.nanoTime();
		Collections.shuffle(this.deck, new Random(this.seed));

	}

	public Card drawCardFromDeck(int indexCard) {
		return this.deck.get(indexCard);
	}

}
