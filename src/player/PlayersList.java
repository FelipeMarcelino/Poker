package player;

import java.util.ArrayList;

public class PlayersList {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private int totalPlayersInGame;
	private int whoWins;
	
	public void generatePlayers(ArrayList<String> playersNames,int initChips){
		for(String name : playersNames){
			this.players.add(new Player(name,players.size() + 1,initChips));
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
	
	public boolean readyForNextTurn(int betPerPlayer){
		for(int i = 0; i < this.players.size(); i++){
			if(this.players.get(i).isFold() != false){
				if(this.players.get(i).getTotalBet() != betPerPlayer){
					if(this.players.get(i).isAllIn() != true) return false;
				}
			}
		}
		
		return true;
	}
	
	public int playersInGame(){
		
		this.totalPlayersInGame = 0;
		
		for(int i = 0; i < this.players.size(); i++){
			if(this.players.get(i).inGame() == true) this.totalPlayersInGame += 1;
		}
		
		
		return this.totalPlayersInGame;
		
	}
	
	public int getWhoWins(){
		for(int i = 0; i < this.players.size(); i++){
			if(this.players.get(i).inGame() == true) {
				this.whoWins = i + 1;
				break;
			}
		}
		
		return this.whoWins;
		
	}
	
	public void eliminatePlayers(){
		for(int i = 0; i < this.players.size(); i++){
			if(this.players.get(i).getChips() == 0) this.players.get(i).outGame();
		}
	}
	
}
