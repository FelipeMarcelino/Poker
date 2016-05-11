package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Classe Deck: Contém uma composição de objetos da classe Card{@link deck.Card}.
 * Esta classe esta responsável por implementar os métodos de embaralhar {@link #shuffleDeck()} 
 * e retornar a carta de acordo com o índice desejado. {@link #drawCardFromDeck(int)}.
 * @author Felie Glicério Gomes Marcelino
 * @see  java.util.Collections
 */
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

	/**
	 * Embaralha o baralho criado. 
	 */
	public void shuffleDeck() {
		this.seed = System.nanoTime();
		Collections.shuffle(this.deck, new Random(this.seed));

	}

	/**
	 * Retira a carta de acordo com index.
	 * @param indexCard Indica qual carta retornará.
	 * @return Retorna um objeto do tipo Card{@link deck.Card}.
	 */
	public Card drawCardFromDeck(int indexCard) {
		return this.deck.get(indexCard);
	}

}
