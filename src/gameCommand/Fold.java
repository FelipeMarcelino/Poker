package gameCommand;

import game.InfoRound;
import player.PlayersList;

public class Fold implements GameCommand{

	private PlayersList playersList;
	private InfoRound infoRound;
	
	public Fold(PlayersList playersList, InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		//this.playersList.selectPlayer(this.whoCommand).fold();
	}
	
	
}
