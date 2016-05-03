package pokerHand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import deck.Card;
import player.Player;

public class StraightFlush implements GetPokerHand {

	private static StraightFlush straightFlush = new StraightFlush();
	private ArrayList<Card> tempHand = new ArrayList<Card>();
	private int totalSameSuit;
	private boolean[] cardSameSuit = new boolean[7];
	private ArrayList<Integer> temp = new ArrayList<Integer>();
	private Set<Integer> removeDuplicate = new HashSet<>();
	private boolean thereIsAce;
	private int indexBegin;
	private int indexEnd;
	
	private  StraightFlush(){
	}
	
	public static  StraightFlush getInstance(){
	      return  straightFlush;
	}

	private void getBestFiveStraightFlush(ArrayList<Card> bestFive, ArrayList<Card> hand) {

		for (int i = this.indexEnd; i > this.indexBegin - 1; i--) {
			if (this.temp.get(i) == 13 || this.temp.get(i) == 0) {
				for (int k = 0; k < hand.size(); k++) {
					if (hand.get(k).getRank() == 0) {
						bestFive.add(hand.get(k));
						break;
					}
				}
			} else {
				for (int k = 0; k < hand.size(); k++) {
					if (hand.get(k).getRank() == this.temp.get(i)) {
						bestFive.add(hand.get(k));
						break;
					}
				}
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
				this.tempHand.clear();

				for (int k = 0; k < hand.size(); k++) {
					if (this.cardSameSuit[k] == true)
						this.tempHand.add(hand.get(k));
				}

				break;

			}

		}

		if (this.totalSameSuit >= 5) {
			this.temp.clear();
			this.removeDuplicate.clear();
			this.indexBegin = 0;
			this.indexEnd = 0;

			for (int i = 0; i < tempHand.size(); i++) {
				if (tempHand.get(i).getRank() == 0)
					this.thereIsAce = true;
				this.temp.add(Card.values[tempHand.get(i).getRank()]);
			}

			if (this.thereIsAce == true) {
				this.temp.add(0);
			}

			this.removeDuplicate.addAll(this.temp);
			this.temp.clear();
			this.temp.addAll(this.removeDuplicate);

			Collections.sort(this.temp);

			if (this.temp.size() >= 5) {
				for (int i = 0; i < this.temp.size() - 4; i++) {
					if (this.temp.get(i) == this.temp.get(i + 4) - 4) {
						this.indexBegin = i;
						this.indexEnd = i + 4;
					}
				}

				if (this.indexEnd != 0) {
					getBestFiveStraightFlush(player.setBestFive(), tempHand);
					return true;
				}
			}
		}

		return false;
	}

}
