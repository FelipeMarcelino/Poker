package command;

import java.util.ArrayList;

import player.Player;

public class ClearHandPlayers implements Command<Void>{

	ArrayList<Player> players;
	
	public ClearHandPlayers(ArrayList<Player> players){
		this.players = players;
	}
	
	@Override
	public Void execute() {
		
		for(int i = 0; i < this.players.size(); i++){
			this.players.get(i).getHand().clear();
		}
		
		return null;
	}

}
