package player;

import java.util.ArrayList;
import java.util.Scanner;

import deck.Card;
import game.Poker;

public class Player {
	
	private String name;
	private int id;
	private int chips;
	private boolean inGame;
	private boolean isFold ;
	private boolean isCheck;
	private boolean allIn ;
	private int powerHand;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> bestFive = new ArrayList<Card>();
	private Scanner reader = new Scanner(System.in);
	private int bet;
	private int totalBet;
	
	
	

	
	public Player(String name,int id,int chips){
		this.name = name;
		this.id = id;
		this.chips = chips;
		this.isFold = false;
		this.isCheck = false;
		this.allIn = false;
		this.inGame = true;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getId(){
		return this.id;
	}
	
	public boolean inGame(){
		return this.inGame;
	}
	
	public void outGame(){
		this.inGame = false;
	}
	
	public int getChips(){
		return this.chips;
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
	
	public int getTotalBet(){
		return this.totalBet;
	}
	
	public void fold(){
		
		this.isFold = true;
	}
	
	public boolean isFold(){
		return this.isFold;
	}
	
	public void check(){
		this.isCheck = true;
	}
	
	public boolean isCheck(){
		return this.isCheck;
	}
	

	public boolean isAllIn() {
		return allIn;
	}
	
	public void showHand(){
		System.out.println(Poker.ranks[this.hand.get(0).getRank()] + "Of" + Poker.suits[this.hand.get(0).getSuit()]);
		System.out.println(Poker.ranks[this.hand.get(1).getRank()] + "Of" + Poker.suits[this.hand.get(1).getSuit()]);
	}

	
	public int bet(int minimumBet){
		minimumBet -= this.totalBet;
		this.bet = -1;
		System.out.println("Aposta minima ->" + minimumBet + "(Se voce nao tiver fichas suficientes, "
				+ ",ou caso aposte mais do que tenha, todas serão apostadas) : ");
		while(this.bet < 0 ){
			this.bet = reader.nextInt();
			if(this.bet < 0) System.out.println("Sua aposta nao pode ser negativa, tente outra vez");
			else if(this.bet < minimumBet && this.chips > this.bet){
				System.out.println("Sua aposta é menor que a aposta minima, porem você tem"
						+ "fichas suficiente, logo sera apostado a aposta minima! Escolha outra aposta");
				this.bet = -1;
			
			}else break;
		}
		this.bet = reader.nextInt();
		if(this.bet >= minimumBet  && this.bet < this.chips){
			this.totalBet+= this.bet;
			this.chips -= this.bet;
			return this.bet;
		}else {
			this.bet = this.chips;
			this.chips = 0;
			this.allIn = true;
			this.totalBet += this.bet;
			return this.bet;
		}
		
		
	}
	
	public int allIn(){
		System.out.println("Todas as fichas apostadas!");
		this.bet = this.chips;
		this.chips = 0;
		this.allIn = true;
		this.totalBet = this.bet;
		return this.bet;
	}
	
	
	public int call(int minimumBet){
		if(minimumBet <= this.chips ){
			this.bet = minimumBet - this.totalBet;
			this.totalBet += this.bet;
			System.out.println("Sua aposta e: " + this.bet);
			return this.bet;
		}else{
			this.bet = this.chips;
			this.totalBet += this.bet;
			this.allIn = true;
			System.out.println("Fichas insuficientes para Call, aposta todas as fichas" + this.bet);
			return this.bet;
		}
	}
	
	public void readyPlayer(){
		if(this.isFold != true && this.inGame != false){
			this.isCheck = false;
			this.totalBet = 0;
		}
	}

}
