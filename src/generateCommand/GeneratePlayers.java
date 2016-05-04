package generateCommand;

import java.util.ArrayList;
import java.util.Scanner;

import player.PlayersList;

public class GeneratePlayers implements GenerateCommand{

	private PlayersList playerList;
	private ArrayList<String> playersNames;
	private int initChips;
	private Scanner reader = new Scanner(System.in);
	
	public GeneratePlayers(PlayersList playerList,ArrayList<String> playersNames){
		this.playerList = playerList;
		this.playersNames = playersNames;
		System.out.print ("Insira o total de fichas que cada jogador começacará: " );
		this.initChips = this.reader.nextInt();
	}
	
	@Override
	public void execute() {
		this.playerList.generatePlayers(this.playersNames,this.initChips);
		
	}

	
	
}
