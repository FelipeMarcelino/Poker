package command;

import java.util.ArrayList;

import player.Player;

public class GeneratePlayers implements Command<Void>{

	private ArrayList<String> names;
	private ArrayList<Player> players;
	
	public GeneratePlayers(ArrayList<String> names,ArrayList<Player> players){
		
		this.names = names;
		this.players = players;

		
	}

	@Override
	public Void execute() {
		
		for(int i = 0; i < this.names.size(); i++){
			this.players.add(new Player(this.names.get(i),i+1));
		}
		
		System.out.println("oie");
		
		
		
		return null;
	}
		
}
