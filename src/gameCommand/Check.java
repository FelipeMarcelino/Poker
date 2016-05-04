package gameCommand;

import game.InfoRound;
import player.PlayersList;

public class Check implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	
	public Check(PlayersList playersList, InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		//this.playersList.selectPlayer(this.whoCommand).check();
	}

}
