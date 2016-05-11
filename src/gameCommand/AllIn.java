package gameCommand;

import game.InfoRound;
import player.PlayersList;

/**
 * The command pattern: Classe responsável pelo comando All In no poker{@link player.Player#allIn()}.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class AllIn implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	private int bet;

	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada{@link game.InfoRound}
	 */
	public AllIn(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.bet = this.playersList.selectPlayer(0).allIn();
		if (this.bet > this.infoRound.getMinimumBet())
			this.infoRound.setMinimumBet(this.bet);
	}

}
