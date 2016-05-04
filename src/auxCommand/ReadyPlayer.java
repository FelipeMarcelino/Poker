package auxCommand;

import player.PlayersList;

public class ReadyPlayer implements AuxCommand {
	
	private PlayersList playersList;
	
	public ReadyPlayer(PlayersList playersList){
		this.playersList = playersList;
	}

	@Override
	public void execute() {
		for(int i = 0; i < playersList.getSizeList(); i++){
			playersList.selectPlayer(i).readyPlayer();
		}
	}
	
	
	
}
