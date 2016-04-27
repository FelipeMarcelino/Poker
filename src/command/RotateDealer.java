package command;

import java.util.ArrayList;

import player.Player;

public class RotateDealer implements Command<Void> {

	private ArrayList<Player> players;
	
	public RotateDealer(ArrayList<Player> players){
		this.players = players;
	}
	
	@Override
	public Void execute() {
		
		players.add(players.remove(0));

		
		return null;
	}

}
