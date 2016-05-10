package pokerHand;

import java.util.ArrayList;
import java.util.Arrays;

import deck.Card;
import player.Player;

public class FullHouse implements GetPokerHand {

	private static FullHouse fullHouse = new FullHouse();
	private int totalSameRank;
	private boolean[] cardSameRank = new boolean[7];
	private boolean isThree;
	private boolean isPair;
	private int indexThree[] = new int[3];
	private int indexPair[] = new int[2];
	private int aux;

	private FullHouse() {
	}

	public static FullHouse getInstance() {
		return fullHouse;
	}

	private void getBestFiveFullHouse(ArrayList<Card> bestFive, ArrayList<Card> hand) {

		for (int i = 0; i < this.indexThree.length; i++) {
			bestFive.add(hand.get(this.indexThree[i]));
		}

		for (int i = 0; i < this.indexPair.length; i++) {
			bestFive.add(hand.get(this.indexPair[i]));
		}

	}

	@Override
	public boolean testHand(ArrayList<Card> hand, Player player) {

		this.isPair = false;
		this.isThree = false;

		for (int i = 0; i < Card.ranks.length; i++) {
			this.totalSameRank = 0;
			Arrays.fill(cardSameRank, Boolean.FALSE);
			for (int k = 0; k < hand.size(); k++) {
				if (Card.ranks[i] == hand.get(k).getRank()) {
					this.totalSameRank++;
					this.cardSameRank[k] = true;
				}
			}

			if (this.totalSameRank == 3) {
				this.isThree = true;
				this.aux = 0;

				for (int p = 0; p < hand.size(); p++) {
					if (this.cardSameRank[p] == true) {
						this.indexThree[this.aux] = p;
						this.aux++;
					}
				}

			}

			if (this.totalSameRank == 2) {
				this.isPair = true;
				this.aux = 0;

				for (int p = 0; p < hand.size(); p++) {
					if (this.cardSameRank[p] == true) {
						this.indexPair[this.aux] = p;
						this.aux++;
					}
				}
			}

			if (this.isPair == true && this.isThree == true) {
				getBestFiveFullHouse(player.setBestFive(), hand);
				return true;
			}

		}

		return false;
	}

}
