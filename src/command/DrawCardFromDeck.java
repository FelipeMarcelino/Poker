package command;

import java.util.ArrayList;

import deck.Card;
import player.Player;

public class DrawCardFromDeck implements Command<Void>{

	private ArrayList<Player> players;
	private ArrayList<Card> deck;
	private int twoCardsPerPlayer;
	
	public DrawCardFromDeck(ArrayList<Player> players,ArrayList<Card> deck){
		this.players = players;
		this.deck = deck;
	}
	
	@Override
	public Void execute() {
		
		this.twoCardsPerPlayer = -1;
		
		for(int i = 0; i < players.size() * 2; i++){
			System.out.println(this.deck.get(i).getRank() + " " + this.deck.get(i).getSuit());
			if(i % 2 == 0){
				this.twoCardsPerPlayer ++;
			}
			
			this.players.get(this.twoCardsPerPlayer).receiveCard(this.deck.get(i));
			
		}
		
		return null;
	}

	
	
}
