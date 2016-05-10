package auxCommand;

import game.InfoRound;
import player.PlayersList;

public class IsNextTurn implements AuxCommand {
	private PlayersList playersList;
	private InfoRound infoRound;

	public IsNextTurn(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.infoRound.setNextTurn(this.playersList.readyForNextTurn(this.infoRound.getMinimumBet()));
	}
}
