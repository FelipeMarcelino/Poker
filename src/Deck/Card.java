package Deck;

public class Card {

	private static int[] suits = {0,1,2,3};
	private static int[] ranks = {0,1,2,3,4,5,6,7,8,9,10,11,12};
	private int indexSuit;
	private int indexRank;
	
	public Card(int indexSuit,int indexRank){
		this.indexRank = indexRank;
		this.indexSuit = indexSuit;
	}
	
	public int getSuit(){
		return this.suits[indexSuit];
	}
	
	public int getRank(){
		return this.ranks[indexRank];
	}
	
	
}
