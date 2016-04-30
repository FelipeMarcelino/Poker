package player;

import java.util.ArrayList;

public class PlayersList {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public void generatePlayers(ArrayList<String> playersNames){
		for(String name : playersNames){
			this.players.add(new Player(name,players.size() + 1));
		}
		
	}
	
	public void rotatePlayersList(){
		this.players.add(this.players.remove(0));
		
		for(int k = 0; k < this.players.size(); k++){
			System.out.println(this.players.get(k).getName());
		}
		
	}
	
	public int getSizeList(){
		return this.players.size();
	}
	
	public Player selectPlayer(int playerIndex){
		return this.players.get(playerIndex);
	}
	
	
}
