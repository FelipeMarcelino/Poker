package command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import deck.Card;

public class ShuffleDeck implements Command<Void>{

	private ArrayList<Card> deck;
	private long seed;
	
	public ShuffleDeck(ArrayList<Card> deck){
		this.deck = deck;
	}
	
	@Override
	public Void execute() {
		this.seed = System.nanoTime();
		
		Collections.shuffle(this.deck,new Random(seed));
		
		return null;
	}

	
	
}
