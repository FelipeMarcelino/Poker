package pokerHand;

import java.util.ArrayList;

import deck.Card;
import player.Player;

public interface GetPokerHand {

		
	boolean testHand(ArrayList<Card> hand,Player player);
	
}
