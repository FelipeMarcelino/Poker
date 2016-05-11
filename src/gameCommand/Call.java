package gameCommand;

import game.InfoRound;
import player.PlayersList;


/**
 * The command pattern: Classe responsável pelo comando Call no poker{@link player.Player#call()}.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class Call implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	private int bet;

	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada{@link game.InfoRound}
	 */
	public Call(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.bet = this.playersList.selectPlayer(0).call(infoRound.getMinimumBet());
		if (this.bet > this.infoRound.getMinimumBet())
			this.infoRound.setMinimumBet(this.bet);
	}

}
