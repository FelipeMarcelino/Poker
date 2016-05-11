package auxCommand;

import game.InfoRound;
import player.PlayersList;

/**
 * The command pattern: Comando que irá verificar se os jogadores já estãom
 * prontos para o próximo turno.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class IsNextTurn implements AuxCommand {
	private PlayersList playersList;
	private InfoRound infoRound;
	
	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada{@link game.InfoRound}
	 */

	public IsNextTurn(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.infoRound.setNextTurn(this.playersList.readyForNextTurn(this.infoRound.getMinimumBet()));
	}
}
