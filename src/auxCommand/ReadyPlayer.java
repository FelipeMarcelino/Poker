package auxCommand;

import game.InfoRound;
import player.PlayersList;

/**
 * The command pattern: Comando para preparar os jogadores para 
 * a próxima rodada.
 * @author Felie Glicério Gomes Marcelino
 *
 */


public class ReadyPlayer implements AuxCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	
	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada{@link game.InfoRound}
	 */

	public ReadyPlayer(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.infoRound.setPlayersInTurn();
		for (int i = 0; i < playersList.getSizeList(); i++) {
			if (playersList.selectPlayer(i).readyPlayer() == true) {
				this.infoRound.sumPlayersInTurn();
			}
		}
	}

}
