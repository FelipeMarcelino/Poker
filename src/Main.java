import java.util.ArrayList;

import command.DrawCardFromDeck;
import command.GetDeck;
import command.RotateDealer;
import command.ShuffleDeck;
import deck.Card;
import player.Player;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Player> players = new ArrayList<Player>();
		GetDeck getDeck = new GetDeck();
		ShuffleDeck shuffleDeck;
		DrawCardFromDeck drawCardFromDeck;
		RotateDealer rotateDealer;
		
		players.add(new Player("A"));
		players.add(new Player("B"));
		
		rotateDealer = new RotateDealer(players);
		
		ArrayList<Card> deck = getDeck.execute();
		
		shuffleDeck = new ShuffleDeck(deck);
		
		shuffleDeck.execute();
		
		drawCardFromDeck = new DrawCardFromDeck(players,deck);
		
		drawCardFromDeck.execute();
		
		rotateDealer.execute();
		
		System.out.println(players.get(0).getName());
		
		System.out.println("Oie");
	}

}
