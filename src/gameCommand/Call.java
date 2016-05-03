package gameCommand;

import game.StateRound;
import player.PlayersList;

public class Call implements GameCommand {

	private PlayersList playersList;
	private StateRound stateRound;
	private int whoCommand;
	
	public Call(PlayersList playersList,StateRound stateRound,int whoCommand){
		this.playersList = playersList;
		this.stateRound = stateRound;
		this.whoCommand = whoCommand;
	}
	
	@Override
	public void execute() {
		this.playersList.selectPlayer(this.whoCommand).allIn();	
	}

}
