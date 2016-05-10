package gameCommand;

import player.PlayersList;

public class Check implements GameCommand {

	private PlayersList playersList;

	public Check(PlayersList playersList) {
		this.playersList = playersList;

	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(0).check();
	}

}
