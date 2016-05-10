package auxCommand;

import player.PlayersList;

public class EliminatePlayers implements AuxCommand {
	private PlayersList playersList;

	public EliminatePlayers(PlayersList playersList) {
		this.playersList = playersList;
	}

	@Override
	public void execute() {
		this.playersList.eliminatePlayers();
		;
	}

}
