package gameCommand;

import player.PlayersList;

/**
 * The command pattern: Classe responsável pelo comando Fold no poker{@link player.Player#fold()}.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class Fold implements GameCommand {

	private PlayersList playersList;

	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 */
	public Fold(PlayersList playersList) {
		this.playersList = playersList;

	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(0).fold();
	}

}
