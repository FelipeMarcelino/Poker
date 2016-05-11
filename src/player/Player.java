package player;

import java.util.ArrayList;
import java.util.Scanner;

import deck.Card;
import game.Poker;

/**
 * Classe Player: Classe responsável por guardar todas as informações do jogadores.
 * @author Felie Glicério Gomes Marcelino
 *
 */

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

	/**
	 * Construtor player
	 * @param name Nome do jogador
	 * @param id Identificação do jogador
	 * @param chips Fichas do jogador
	 */
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
	/**
	 * 
	 * @return <code> true </code> se o jogador está pronto, <code> false </false> caso contrário.
	 */
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

	/**
	 * Retorna {@link #name}
	 * @return Retorna o nome do jogador
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Retorna {@link #id}
	 * @return Retorna o id do jogador
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Retorna {@link #inGame}
	 * @return Retorna  <code> true </code>  se o jgador está no jogo, <code> false</code> caso contrário.
	 */
	public boolean inGame() {
		return this.inGame;
	}

	/**
	 * Retira o jogador do game.
	 */
	public void outGame() {
		this.inGame = false;
		this.isFold = true;
	}

	/**
	 * Retorna {@link #chips}
	 * @return Retorna o total de fichas do jogador.
	 */
	public int getChips() {
		return this.chips;
	}

	/**
	 * Retorna {@link #powerHand}
	 * @return Retorna qual a força da mão do jogador. 8 - StraightFlush...1- one pair.
	 */
	public int getPowerHand() {
		return powerHand;
	}

	/**
	 * Seta {@link #powerHand}
	 * @param powerHand Atribui a força da mão do jogador.
	 */
	public void setPowerHand(int powerHand) {
		this.powerHand = powerHand;
	}

	/**
	 * Seta {@link #hand}
	 * @param card Recebe carta do Croupier.
	 */
	public void receiveCard(Card card) {
		this.hand.add(card);
	}

	/**
	 * Return {@link #hand}
	 * @return Retorna mão do jogador
	 */
	public ArrayList<Card> getHand() {
		return this.hand;
	}

	/**
	 * Seta {@link #bestFive}
	 * @return Atribui as 5 melhores cartas do jogador.
	 */
	public ArrayList<Card> setBestFive() {
		return this.bestFive;
	}

	/**
	 * Retorna {@link #bestFive}
	 * @return Retorna as 5 melhores cartas do jogador.
	 */
	public ArrayList<Card> getBestFive() {
		return this.bestFive;
	}

	/**
	 * Retorna {@link #totalBet}
	 * @return Retorna o total que o jogador apostou em um turno.
	 */
	public int getTotalBet() {
		return this.totalBet;
	}

	/**
	 * Coloca o jogador em estado Fold.
	 */
	public void fold() {

		this.isFold = true;
	}

	/**
	 * Retorna {@link #isFold}
	 * @return Retorna <code> true</code> se o jogador está em fold.
	 */
	public boolean isFold() {
		return this.isFold;
	}

	/**
	 * Coloca o jogador em estado Check.
	 */
	public void check() {
		this.isCheck = true;
	}

	/**
	 * retorna {@link #isCheck}
	 * @return Retorna <code> true </code> se o jogador já utilizou check.
	 */
	public boolean isCheck() {
		return this.isCheck;
	}

	/**
	 * Retorna {@link #allIn}
	 * @return Retorna <code> true</true> se o jogador está em All In.
	 */
	public boolean isAllIn() {
		return allIn;
	}

	/**
	 * Mostra a mão do jogador.
	 */
	public void showHand() {
		System.out.println("");
		System.out.println(Poker.ranks[this.hand.get(0).getRank()] + " Of " + Poker.suits[this.hand.get(0).getSuit()]);
		System.out.println(Poker.ranks[this.hand.get(1).getRank()] + " Of " + Poker.suits[this.hand.get(1).getSuit()]);
	}

	/**
	 * Sum {@link #chips}
	 * @param totalRoundBet Valor que será somado a ficha do jogador.
	 */
	public void winner(int totalRoundBet) {
		this.chips += totalRoundBet;
	}

	/**
	 * Mostra as melhores 5 cartas do jogador.
	 */
	public void showBestFive() {
		if (this.bestFive.size() > 0) {
			System.out.println("Melhores 5 cartas");
			for (int i = 0; i < 5; i++) {
				System.out.println(Poker.ranks[this.bestFive.get(i).getRank()] + " Of "
						+ Poker.suits[this.bestFive.get(i).getSuit()]);
			}
		}
	}

	/**
	 * Retorna {@link #bet}
	 * @param minimumBet Valor mínimo que o jogador tem que aposta.
	 * @return Retorna qual foi a aposta do jogador.
	 */
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

	/**
	 * Seta {@link #allIn}
	 * @return Retorna todas as fichas do jogador como aposta.
	 */
	public int allIn() {
		System.out.print("Todas as fichas apostadas!(");
		this.bet = this.chips;
		this.chips = 0;
		this.allIn = true;
		this.totalBet += this.bet;
		System.out.println(this.bet + ")");
		return this.totalBet;
	}

	/**
	 * 
	 * @param minimumBet Iguala a aposta do jogador à aposta mínima
	 * @return Retorna á aposta do jogador
	 */
	public int call(int minimumBet) {

		this.bet = minimumBet - this.totalBet;
		this.totalBet += this.bet;
		System.out.println("Sua aposta e: " + this.bet);
		this.chips -= this.bet;
		return this.bet;

	}

}
