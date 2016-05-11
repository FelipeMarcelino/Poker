package auxCommand;

import java.util.ArrayList;

import deck.Card;
import player.PlayersList;
import pokerHand.PokerHand;

/**
 * The command pattern: Comando que irá atribuir a cada jogador
 * sua mão que será sua combinação de cartas com a da mesa.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class SetPokerHand implements AuxCommand {

	private PlayersList playersList;
	private ArrayList<Card> board;
	private PokerHand pokerHand;
	
	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param pokerHand Objeto da classe PokerHand que contém todas mãos do jogo de Poker {@link pokerHand.PokerHand}
	 * @param board Um ArrayList que irá guardar as cartas da mesa em cada rodada.
	 * @see  java.util.Collections
	 */

	public SetPokerHand(PlayersList playersList, PokerHand pokerHand, ArrayList<Card> board) {
		this.playersList = playersList;
		this.board = board;
		this.pokerHand = pokerHand;
	}

	@Override
	public void execute() {
		this.pokerHand.GetPokerHand(this.playersList, this.board);
	}

}
