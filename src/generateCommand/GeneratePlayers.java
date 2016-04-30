package generateCommand;

import java.util.ArrayList;

import Player.PlayersList;

public class GeneratePlayers implements GenerateCommand{

	private PlayersList playerList;
	private ArrayList<String> playersNames;
	
	public GeneratePlayers(PlayersList playerList,ArrayList<String> playersNames){
		this.playerList = playerList;
		this.playersNames = playersNames;
	}
	
	@Override
	public void execute() {
		this.playerList.generatePlayers(this.playersNames);
		
	}

	
	
}
