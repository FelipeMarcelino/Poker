package gameCommand;

import game.InfoRound;
import player.PlayersList;

public class AllIn implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	private int whoCommand;
	private int minimumBet;
	
	public AllIn(PlayersList playersList,InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.minimumBet =  this.playersList.selectPlayer(this.whoCommand).allIn();
		if(this.minimumBet > this.infoRound.getMinimumBet()) this.infoRound.setMinimumBet(this.minimumBet);
	}
	
}
