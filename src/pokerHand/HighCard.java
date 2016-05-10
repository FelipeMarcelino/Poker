package pokerHand;

import java.util.ArrayList;

import deck.Card;
import player.Player;

public class HighCard implements GetPokerHand {

	private static HighCard highCard = new HighCard();

	private HighCard() {
	}

	public static HighCard getInstance() {
		return highCard;
	}

	private void getBestFiveHighCard(ArrayList<Card> bestFive, ArrayList<Card> hand) {
		for (int i = 0; i < 5; i++) {
			bestFive.add(hand.get(i));
		}
	}

	@Override
	public boolean testHand(ArrayList<Card> hand, Player player) {

		getBestFiveHighCard(player.setBestFive(), hand);

		return true;
	}

}
