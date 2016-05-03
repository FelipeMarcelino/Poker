package gameCommand;

import game.StateRound;
import player.PlayersList;

public class AllIn implements GameCommand {

	private PlayersList playersList;
	private StateRound stateRound;
	private int whoCommand;
	private int minimumBet;
	
	public AllIn(PlayersList playersList,StateRound stateRound,int whoCommand){
		this.playersList = playersList;
		this.stateRound = stateRound;
		this.whoCommand = whoCommand;
	}

	@Override
	public void execute() {
		this.minimumBet =  this.playersList.selectPlayer(this.whoCommand).allIn();
		if(this.minimumBet > this.stateRound.getMinimumBet()) this.stateRound.setMinimumBet(this.minimumBet);
	}
	
}
