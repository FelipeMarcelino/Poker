package auxCommand;

import game.InfoRound;
import player.PlayersList;

public class ReadyPlayer implements AuxCommand {

	private PlayersList playersList;
	private InfoRound infoRound;

	public ReadyPlayer(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.infoRound.setPlayersInTurn();
		for (int i = 0; i < playersList.getSizeList(); i++) {
			if (playersList.selectPlayer(i).readyPlayer() == true) {
				this.infoRound.sumPlayersInTurn(1);
			}
		}
	}

}
