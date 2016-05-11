package deck;

/**
 * Classe Carta: Nesta classe cada uma das intâncias terá o seu indexSuit e indexRank
 * que indicará qual é o seu naipe e o seu valor. A classe possui um array contendo os valores
 * de cada carta, respectivo ao indíce do ranks.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class Card {

	public static int[] suits = { 0, 1, 2, 3 };
	public static int[] ranks = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	public static int[] values = { 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	private int indexSuit;
	private int indexRank;

	/**
	 * 
	 * @param indexSuit Indica qual é o naipe da carta.
	 * @param indexRank Indica qual é o valor da carta.
	 */
	public Card(int indexSuit, int indexRank) {
		this.indexRank = indexRank;
		this.indexSuit = indexSuit;
	}

	public int getSuit() {
		return suits[indexSuit];
	}

	public int getRank() {
		return ranks[indexRank];
	}

}
