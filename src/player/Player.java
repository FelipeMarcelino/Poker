package player;

import java.util.ArrayList;
import java.util.Scanner;

import deck.Card;
import game.Poker;

public class Player {

	private String name;
	private int id;
	private int chips;
	private int resetFold;
	private boolean inGame;
	private boolean isFold;
	private boolean isCheck;
	private boolean allIn;
	private int powerHand;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> bestFive = new ArrayList<Card>();
	private Scanner reader = new Scanner(System.in);
	private int bet;
	private int totalBet;
	private double dBet;
	private String input;

	public Player(String name, int id, int chips) {
		this.name = name;
		this.id = id;
		this.chips = chips;
		this.isFold = false;
		this.isCheck = false;
		this.allIn = false;
		this.inGame = true;
		this.resetFold = 0;
	}

	public boolean readyPlayer() {
		if (this.resetFold == 0 && this.inGame == true) {
			this.isFold = false;
			this.hand.clear();
		}

		this.resetFold++;
		if (this.resetFold == 4)
			this.resetFold = 0;

		if (this.inGame == true && this.isFold == false) {
			this.isCheck = false;
			this.totalBet = 0;
			this.isFold = false;
			return true;
		} else
			return false;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public boolean inGame() {
		return this.inGame;
	}

	public void outGame() {
		this.inGame = false;
		this.isFold = true;
	}

	public int getChips() {
		return this.chips;
	}

	public int getPowerHand() {
		return powerHand;
	}

	public void setPowerHand(int powerHand) {
		this.powerHand = powerHand;
	}

	public void receiveCard(Card card) {
		this.hand.add(card);
	}

	public ArrayList<Card> getHand() {
		return this.hand;
	}

	public ArrayList<Card> setBestFive() {
		return this.bestFive;
	}

	public ArrayList<Card> getBestFive() {
		return this.bestFive;
	}

	public int getTotalBet() {
		return this.totalBet;
	}

	public void fold() {

		this.isFold = true;
	}

	public boolean isFold() {
		return this.isFold;
	}

	public void check() {
		this.isCheck = true;
	}

	public boolean isCheck() {
		return this.isCheck;
	}

	public boolean isAllIn() {
		return allIn;
	}

	public void showHand() {
		System.out.println(Poker.ranks[this.hand.get(0).getRank()] + " Of " + Poker.suits[this.hand.get(0).getSuit()]);
		System.out.println(Poker.ranks[this.hand.get(1).getRank()] + " Of " + Poker.suits[this.hand.get(1).getSuit()]);
	}

	public void winner(int totalRoundBet) {
		this.chips += totalRoundBet;
	}

	public void showBestFive() {
		if (this.bestFive.size() > 0) {
			System.out.println("Melhores 5 cartas");
			for (int i = 0; i < 5; i++) {
				System.out.println(Poker.ranks[this.bestFive.get(i).getRank()] + " Of "
						+ Poker.suits[this.bestFive.get(i).getSuit()]);
			}
		}
	}

	public int bet(int minimumBet) {
		if (minimumBet - this.totalBet != 0)
			minimumBet -= this.totalBet;

		System.out.println("Aposta minima (Valores double serao arredondados) -> " + minimumBet);
		while (true) {
			while (true) {
				input = reader.next();
				if (Poker.isNumeric(input) == true) {
					this.dBet = Double.parseDouble(input);
					this.bet = (int) Math.round(this.dBet);
					break;
				} else {
					System.out.println("Nao e um numero, coloque outro valor");
				}
			}

			if (this.bet < minimumBet || this.bet > this.chips)
				System.out.println("Valor fora do limite de apostas");
			else
				break;

		}
		this.chips -= this.bet;
		this.totalBet += this.bet;
		return this.bet + minimumBet;

	}

	public int allIn() {
		System.out.print("Todas as fichas apostadas!(");
		this.bet = this.chips;
		this.chips = 0;
		this.allIn = true;
		this.totalBet += this.bet;
		System.out.println(this.bet + ")");
		return this.totalBet;
	}

	public int call(int minimumBet) {

		this.bet = minimumBet - this.totalBet;
		this.totalBet += this.bet;
		System.out.println("Sua aposta e: " + this.bet);
		this.chips -= this.bet;
		return this.bet;

	}

}
