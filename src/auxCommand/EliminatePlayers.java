package auxCommand;

import player.PlayersList;

/**
 * The command pattern: Comando para eliminar os jogadores 
 * sem ficha
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class EliminatePlayers implements AuxCommand {
	private PlayersList playersList;

	/**
	 * 
	 * @param playersList Objeto contendo lista de jogadares {@link player.PlayersList}
	 */
	
	public EliminatePlayers(PlayersList playersList) {
		this.playersList = playersList;
	}

	@Override
	public void execute() {
		this.playersList.eliminatePlayers();
		;
	}

}
