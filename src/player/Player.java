package player;

import java.util.ArrayList;

import deck.Card;

public class Player {
	
	private static String name;
	private static int id;
	private static double chips;
	private static ArrayList<Card> hand;
	
	public Player(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
