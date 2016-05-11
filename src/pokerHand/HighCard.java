package pokerHand;

import java.util.ArrayList;

import deck.Card;
import player.Player;

/**
 * Classe Flush: Responsável de retornar ao jogador caso sua combinação de cartas
 * entre na regra do HighCard.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class HighCard implements GetPokerHand {

	private static HighCard highCard = new HighCard();

	/*
	 * Private construtor.
	 */
	private HighCard() {
	}

	/**
	 * Retorna {@link #highCard}
	 * @return retorna instância da classe
	 */
	public static HighCard getInstance() {
		return highCard;
	}

	/**
	 * 
	 * @param bestFive 5 melhores cartas
	 * @param hand Mao do jogador combinado com as cartas da mesa.
	 */
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
