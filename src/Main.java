import java.util.ArrayList;

import Deck.Deck;
import Player.PlayersList;
import gameCommand.ShuffleDeck;
import generateCommand.GenerateDeck;
import generateCommand.GeneratePlayers;

public class Main {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		PlayersList playersList = new PlayersList();
		GenerateDeck generateDeck = new GenerateDeck(deck);
		ShuffleDeck shuffleDeck = new ShuffleDeck(deck);
		ArrayList<String> playersNames = new ArrayList<String>();
		playersNames.add("A");
		playersNames.add("B");
		playersNames.add("C");
		playersNames.add("D");
		
		GeneratePlayers generatePlayers = new GeneratePlayers(playersList,playersNames);
		
		
		generateDeck.execute();
		generatePlayers.execute();
		shuffleDeck.execute();
		
		
		System.out.println("Oie");
		
	}

}
