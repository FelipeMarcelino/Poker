package pokerHand;

import java.util.ArrayList;

import deck.Card;
import player.Player;
/**
 * 
 * @author Felie Glicério Gomes Marcelino
 *
 */
public interface GetPokerHand {

	boolean testHand(ArrayList<Card> hand, Player player);

}
