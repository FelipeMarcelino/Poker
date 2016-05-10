package gameCommand;

import player.PlayersList;

public class Fold implements GameCommand {

	private PlayersList playersList;

	public Fold(PlayersList playersList) {
		this.playersList = playersList;

	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(0).fold();
	}

}
