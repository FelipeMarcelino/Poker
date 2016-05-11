package pokerHand;

import java.util.ArrayList;
import java.util.Arrays;

import deck.Card;
import player.Player;

/**
 * Classe Flush: Responsável de retornar ao jogador caso sua combinação de cartas
 * entre na regra do TwoPair.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class TwoPair implements GetPokerHand {

	private static TwoPair twoPair = new TwoPair();
	private int totalSameRank;
	private int aux;
	private int indexPairA[] = new int[2];
	private int indexPairB[] = new int[2];
	private boolean[] cardSameRank = new boolean[7];
	private boolean isPairA;
	private boolean isPairB;
	private Card auxCard;
	
	/**
	 * Private construtor
	 */
	private TwoPair() {
	}

	/**
	 * Retorna {@link #TwoPair()}
	 * @return Retorna instância da classe.
	 */
	public static TwoPair getInstance() {
		return twoPair;
	}

	/**
	 * 
	 * @param bestFive 5 melhores cartas
	 * @param hand Mao do jogador combinado com as cartas da mesa.
	 */
	private void getBestFiveTwoPairs(ArrayList<Card> bestFive, ArrayList<Card> hand) {

		for (int i = 0; i < this.indexPairB.length; i++) {
			bestFive.add(hand.get(this.indexPairB[i]));
		}

		for (int i = 0; i < this.indexPairA.length; i++) {
			bestFive.add(hand.get(this.indexPairA[i]));
		}

		if (bestFive.get(2).getRank() == 0) {
			this.auxCard = bestFive.get(0);
			bestFive.set(0, bestFive.get(2));
			bestFive.set(2, auxCard);

			this.auxCard = bestFive.get(1);
			bestFive.set(1, bestFive.get(3));
			bestFive.set(3, auxCard);

		}

		for (int i = 0; i < hand.size(); i++) {
			if (i != this.indexPairB[0] && i != this.indexPairB[1] && i != this.indexPairA[0]
					&& i != this.indexPairA[1]) {
				bestFive.add(hand.get(i));
				break;
			}
		}

	}

	@Override
	public boolean testHand(ArrayList<Card> hand, Player player) {

		this.isPairA = false;
		this.isPairB = false;

		for (int i = 0; i < Card.ranks.length; i++) {
			this.totalSameRank = 0;
			Arrays.fill(cardSameRank, Boolean.FALSE);
			for (int k = 0; k < hand.size(); k++) {
				if (Card.ranks[i] == hand.get(k).getRank()) {
					this.totalSameRank++;
					this.cardSameRank[k] = true;
				}
			}

			if (this.totalSameRank == 2 && this.isPairA == true) {
				this.isPairB = true;
				this.aux = 0;

				for (int p = 0; p < hand.size(); p++) {
					if (this.cardSameRank[p] == true) {
						this.indexPairB[this.aux] = p;
						this.aux++;
					}
				}
			}

			if (this.totalSameRank == 2 && this.isPairA == false) {
				this.isPairA = true;
				this.aux = 0;

				for (int p = 0; p < hand.size(); p++) {
					if (this.cardSameRank[p] == true) {
						this.indexPairA[this.aux] = p;
						this.aux++;
					}
				}

			}

			if (this.isPairA == true && this.isPairB == true) {
				getBestFiveTwoPairs(player.setBestFive(), hand);
				return true;
			}

		}

		return false;
	}

}
