package pokerHand;

import java.util.ArrayList;
import java.util.Arrays;

import deck.Card;
import player.Player;
/**
 * Classe Flush: Responsável de retornar ao jogador caso sua combinação de cartas
 * entre na regra do Flush.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class Flush implements GetPokerHand {

	private static Flush flush = new Flush();
	private int totalSameSuit;
	private boolean[] cardSameSuit = new boolean[7];

	/**
	 * Private construtor.
	 */
	private Flush() {
	}

	/**
	 * Retorna {@link #flush}
	 * @return Retorna a instância da classe.
	 */
	public static Flush getInstance() {
		return flush;
	}

	/**
	 * 
	 * @param bestFive 5 melhores cartas
	 * @param hand Mao do jogador combinado com as cartas da mesa.
	 */
	private void getBestFiveFlush(ArrayList<Card> bestFive, ArrayList<Card> hand) {
		for (int i = 0; i < hand.size(); i++) {
			if (this.cardSameSuit[i] == true) {
				bestFive.add(hand.get(i));
				if (bestFive.size() == 5)
					break;
			}
		}
	}

	
	@Override
	public boolean testHand(ArrayList<Card> hand, Player player) {

		for (int i = 0; i < Card.suits.length; i++) {
			this.totalSameSuit = 0;
			Arrays.fill(cardSameSuit, Boolean.FALSE);
			for (int k = 0; k < hand.size(); k++) {
				if (Card.suits[i] == hand.get(k).getSuit()) {
					this.totalSameSuit++;
					this.cardSameSuit[k] = true;
				}
			}

			if (this.totalSameSuit >= 5) {
				getBestFiveFlush(player.setBestFive(), hand);
				return true;
			}

		}

		return false;
	}

}
