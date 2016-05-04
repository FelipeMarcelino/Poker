package auxCommand;

import game.InfoRound;
import player.PlayersList;

public class GetWhoWins implements AuxCommand {
	private PlayersList playersList;
	private InfoRound infoRound;
	
	public GetWhoWins(PlayersList playersList,InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}
	
	@Override
	public void execute() {
		//this.infoRound.setWhoWins(this.playersList.getWhoWins());
	}
}
