package gameCommand;

import player.PlayersList;

/**
 * The command pattern: Classe responsável pelo comando Check no poker{@link player.Player#check()}.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class Check implements GameCommand {

	private PlayersList playersList;

	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 */
	public Check(PlayersList playersList) {
		this.playersList = playersList;

	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(0).check();
	}

}
