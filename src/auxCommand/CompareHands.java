package auxCommand;

import game.InfoRound;
import player.PlayersList;
import pokerHand.PokerHand;

/**
 * The command pattern: Comando para comparara mão dos jogadores.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class CompareHands implements AuxCommand {

	private PlayersList playersList;
	private PokerHand pokerHand;
	private InfoRound infoRound;

	/**
	 * 
	 * @param playersList Objeto contendo lista de jogadares {@link player.PlayersList}
	 * @param pokerHand Objeto da classe PokerHand que contém todas mãos do jogo de Poker {@link pokerHand.PokerHand}
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada {@link game.InfoRound}
	 */
	public CompareHands(PlayersList playersList, PokerHand pokerHand, InfoRound infoRound) {
		this.playersList = playersList;
		this.pokerHand = pokerHand;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.pokerHand.comparePokerHand(this.playersList, this.infoRound.getTotalBet());
	}

}
