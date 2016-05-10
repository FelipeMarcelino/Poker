package auxCommand;

import player.PlayersList;

public class ShowHandPlayer implements AuxCommand {

	private PlayersList playersList;

	public ShowHandPlayer(PlayersList playersList) {
		this.playersList = playersList;
	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(0).showHand();
	}

}
