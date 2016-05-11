package auxCommand;

import java.util.ArrayList;

import deck.Card;
import game.InfoRound;

/**
 * The command pattern: Comando que irá exibir as cartas da mesa.
 * @author Felie Glicério Gomes Marcelino
 *
 */


public class ShowBoardCards implements AuxCommand {

	private ArrayList<Card> board;
	private InfoRound infoRound;

	/**
	 * 
	 * @param board Um ArrayList que irá guardar as cartas da mesa em cada rodada.
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada{@link game.InfoRound}
	 * @see  java.util.Collections
	 */
	public ShowBoardCards(ArrayList<Card> board, InfoRound infoRound) {
		this.board = board;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.infoRound.showBoardCard(this.board);
	}

}
