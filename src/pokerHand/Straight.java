package pokerHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import deck.Card;
import player.Player;

public class Straight implements GetPokerHand {

	private static Straight straight = new Straight();
	private ArrayList<Integer> temp = new ArrayList<Integer>();
	private Set<Integer> removeDuplicate = new HashSet<>();
	private boolean thereIsAce;
	private int indexBegin;
	private int indexEnd;

	private Straight() {
	}

	public static Straight getInstance() {
		return straight;
	}

	private void getBestFiveStraight(ArrayList<Card> bestFive, ArrayList<Card> hand) {

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

		this.temp.clear();
		this.removeDuplicate.clear();
		this.indexBegin = 0;
		this.indexEnd = 0;
		this.thereIsAce = false;

		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getRank() == 0)
				this.thereIsAce = true;
			this.temp.add(Card.values[hand.get(i).getRank()]);
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
				getBestFiveStraight(player.setBestFive(), hand);
				return true;
			}
		}

		return false;
	}

}
