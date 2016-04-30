package auxCommand;

import java.util.ArrayList;

import player.PlayersList;

public class RotatePlayersList implements AuxCommand{

	
	private PlayersList playerList;
	
	public RotatePlayersList(PlayersList playerList){
		this.playerList = playerList;
		
	}
	
	@Override
	public void execute() {
		this.playerList.rotatePlayersList();
		
	}
}
