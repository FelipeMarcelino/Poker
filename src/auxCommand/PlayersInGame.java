package auxCommand;

import game.InfoRound;
import player.PlayersList;

public class PlayersInGame implements AuxCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	
	public PlayersInGame(PlayersList playersList,InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}
	
	@Override
	public void execute() {
		//this.infoRound.setPlayersInGame(this.playersList.playersInGame());
	}

}
