package auxCommand;

import game.InfoRound;
import player.PlayersList;

/**
 * The command pattern: Comando que irá verificar quando jogadores
 * ainda estão no jogo.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class PlayersInGame implements AuxCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	
	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada{@link game.InfoRound}
	 */

	public PlayersInGame(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.infoRound.setPlayersInGame(this.playersList.playersInGame());
	}

}
