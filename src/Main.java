import java.util.ArrayList;
import java.util.LinkedList;

import command.GeneratePlayers;
import command.ClearHandPlayers;
import command.DrawCardFromDeck;
import command.GetDeck;
import command.RotateDealer;
import command.ShuffleDeck;
import deck.Card;
import player.Player;

public class Main {

	public static void main(String[] args) {
		
		
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Card> deck = new ArrayList<Card>();
		GetDeck getDeck = new GetDeck(deck);
		ShuffleDeck shuffleDeck;
		DrawCardFromDeck drawCardFromDeck;
		RotateDealer rotateDealer;
		ClearHandPlayers clearHandPlayers;
		
		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");
		
		GeneratePlayers generatePlayers = new GeneratePlayers(names,players);
		
		generatePlayers.execute();
		
		getDeck.execute();
		
		rotateDealer = new RotateDealer(players);
		
		clearHandPlayers = new ClearHandPlayers(players);
		
		shuffleDeck = new ShuffleDeck(deck);
		
		shuffleDeck.execute();
		
		
		drawCardFromDeck = new DrawCardFromDeck(players,deck);
		
		drawCardFromDeck.execute();		
		rotateDealer.execute();
		System.out.println(players.get(0).getName());
		rotateDealer.execute();
		rotateDealer.execute();
		
		System.out.println("Oie");
		
		clearHandPlayers.execute();
		
	}

}
