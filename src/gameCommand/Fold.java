package gameCommand;

import player.PlayersList;

public class Fold implements GameCommand{

	private PlayersList playersList;
	private int whoCommand;
	
	public Fold(PlayersList playersList,int whoCommand){
		this.playersList = playersList;
		this.whoCommand = whoCommand;
	}

	@Override
	public void execute() {
		this.playersList.selectPlayer(this.whoCommand).fold();
	}
	
	
}
