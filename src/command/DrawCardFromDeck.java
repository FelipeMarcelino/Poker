package command;

import java.util.ArrayList;

import deck.Card;
import player.Player;

public class DrawCardFromDeck implements Command<Void>{

	private ArrayList<Player> players;
	private ArrayList<Card> deck;
	
	public DrawCardFromDeck(ArrayList<Player> players,ArrayList<Card> deck){
		this.players = players;
		this.deck = deck;
	}
	
	@Override
	public Void execute() {
		
		for(int i = 0; i < players.size() * 2; i++){
			System.out.println(this.deck.get(i).getRank() + " " + this.deck.get(i).getSuit());
		}
		
		return null;
	}

	
	
}
