package gameCommand;

import player.PlayersList;

public class Check implements GameCommand {

	private PlayersList playersList;
	private int whoCommand;
	
	public Check(PlayersList playersList){
		this.playersList = playersList;
	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(this.whoCommand).check();
	}

}
