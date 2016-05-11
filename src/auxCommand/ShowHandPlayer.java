package auxCommand;

import player.PlayersList;

/**
 * The command pattern: Comando que irá exibir as cartas dos jogadores.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class ShowHandPlayer implements AuxCommand {

	private PlayersList playersList;

	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 */
	public ShowHandPlayer(PlayersList playersList) {
		this.playersList = playersList;
	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(0).showHand();
	}

}
