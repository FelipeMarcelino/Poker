package player;

import java.util.ArrayList;

import deck.Card;

public class Player {
	
	private String name;
	private int id;
	private double chips;
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public Player(String name,int id){
		this.name = name;
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void receiveCard(Card card){
		this.hand.add(card);
	}
	

}
