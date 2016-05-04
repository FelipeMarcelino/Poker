package gameCommand;

import game.InfoRound;
import player.PlayersList;

public class Call implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	private int whoCommand;
	
	public Call(PlayersList playersList,InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}
	
	@Override
	public void execute() {
		this.playersList.selectPlayer(this.whoCommand).allIn();	
	}

}
