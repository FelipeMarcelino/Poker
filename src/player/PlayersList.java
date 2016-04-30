package player;

import java.util.ArrayList;

public class PlayersList {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public void generatePlayers(ArrayList<String> playersNames){
		for(String name : playersNames){
			players.add(new Player(name,players.size() + 1));
		}
		
	}
	
}
