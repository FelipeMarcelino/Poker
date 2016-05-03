package player;

import java.util.ArrayList;

import deck.Card;

public class Player {
	
	private String name;
	private int id;
	private double chips;
	private boolean isFold = false;
	private int powerHand;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> bestFive = new ArrayList<Card>();
	
	
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
	
	public int getPowerHand() {
		return powerHand;
	}

	public void setPowerHand(int powerHand) {
		this.powerHand = powerHand;
	}

	public void receiveCard(Card card){
		this.hand.add(card);
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	
	public ArrayList<Card> setBestFive(){
		return this.bestFive;
	}
	
	public ArrayList<Card> getBestFive(){
		return this.bestFive;
	}
	
	public void folding(){
		this.isFold = true;
	}
	
	public boolean isFold(){
		return this.isFold;
	}
	
	

}
