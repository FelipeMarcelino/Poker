package auxCommand;

import player.PlayersList;

/**
 * The command pattern: Comando que irá rotacionar a mesa 
 * com os jogadores
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class RotatePlayersList implements AuxCommand {

	private PlayersList playerList;

	
	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 */
	public RotatePlayersList(PlayersList playerList) {
		this.playerList = playerList;

	}

	@Override
	public void execute() {
		this.playerList.rotatePlayersList();

	}
}
