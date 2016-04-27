package deck;

public class Card {
	
	private static int[] suits = {0,1,2,3};
	private static int[] ranks = {0,1,2,3,4,5,7,8,9,10,11,12};
	private int indexSuit;
	private int indexRank;
	
	public Card(int indexSuit,int indexRank){
		this.indexSuit = indexSuit;
		this.indexRank = indexRank;
	}
	
	public int getSuit(){
		return this.suits[this.indexSuit];
	}
	
	public int getRank(){
		return this.ranks[this.indexRank];
	}

}
