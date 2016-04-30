import java.util.ArrayList;

import auxCommand.DrawCardFromDeck;
import auxCommand.RotatePlayersList;
import auxCommand.ShuffleDeck;
import deck.Deck;
import generateCommand.GenerateDeck;
import generateCommand.GeneratePlayers;
import player.PlayersList;

public class Main {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		PlayersList playersList = new PlayersList();
		ArrayList<String> playersNames = new ArrayList<String>();			
		
		GenerateDeck generateDeck = new GenerateDeck(deck);
		ShuffleDeck shuffleDeck = new ShuffleDeck(deck);
		GeneratePlayers generatePlayers = new GeneratePlayers(playersList,playersNames);
		RotatePlayersList rotatePlayersList = new RotatePlayersList(playersList);
		DrawCardFromDeck drawCardFromDeck = new DrawCardFromDeck(playersList,deck);
		
		playersNames.add("A");
		playersNames.add("B");
		playersNames.add("C");
		playersNames.add("D");
		
		generateDeck.execute();
		generatePlayers.execute();
		shuffleDeck.execute();
		rotatePlayersList.execute();
		drawCardFromDeck.execute();
		
		
	}

}
