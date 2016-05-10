package game;

import java.util.ArrayList;
import java.util.Scanner;

import auxCommand.CompareHands;
import auxCommand.DrawCardFromDeck;
import auxCommand.EliminatePlayers;
import auxCommand.GetWhoWins;
import auxCommand.IsNextTurn;
import auxCommand.PlayersInGame;
import auxCommand.ReadyPlayer;
import auxCommand.RotatePlayersList;
import auxCommand.SetPokerHand;
import auxCommand.ShowAvaliableCommands;
import auxCommand.ShowBoardCards;
import auxCommand.ShowHandPlayer;
import auxCommand.ShuffleDeck;
import deck.Card;
import deck.Deck;
import gameCommand.AllIn;
import gameCommand.Bet;
import gameCommand.Call;
import gameCommand.Check;
import gameCommand.Fold;
import generateCommand.GenerateDeck;
import generateCommand.GeneratePlayers;
import player.PlayersList;
import pokerHand.PokerHand;

public class Poker {

	public static String[] suits = { "Hearts", "Diamonds", "Spade", "Clubs" };
	public static String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queens", "King" };

	private Deck deck;
	private PlayersList playersList;
	private PokerHand pokerHand;
	private ArrayList<Card> board;
	private ArrayList<String> playersNames;
	private InfoRound infoRound;
	private Scanner reader;
	private int totalPlayers;
	private int idPlayerBigBlind;
	private int idPlayerDealer;
	private int idCurrentPlayer;
	private static int currentPlayer = 0;
	private int totalBetPerRound;
	private int totalBetPerTurn;
	private int turn = 0;
	private String name;
	private String input;
	private double dTotalPlayers;

	// Comandos

	private GenerateDeck generateDeck;
	private ShuffleDeck shuffleDeck;
	private GeneratePlayers generatePlayers;
	private RotatePlayersList rotatePlayersList;
	private DrawCardFromDeck drawCardFromDeck;
	private SetPokerHand setPokerHand;
	private CompareHands compareHands;
	private AllIn allIn;
	private Bet bet;
	private Call call;
	private Check check;
	private Fold fold;
	private PlayersInGame playersInGame;
	private GetWhoWins getWhoWins;
	private EliminatePlayers eliminatePlayers;
	private IsNextTurn isNextTurn;
	private ReadyPlayer readyPlayer;
	private ShowHandPlayer showHandPlayer;
	private ShowBoardCards showBoardCards;
	private ShowAvaliableCommands showAvaliableCommands;
	private StopLoopGame stopLoopGame;

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public Poker(StopLoopGame stopLoopGame) {
		deck = new Deck();
		playersList = new PlayersList();
		pokerHand = new PokerHand();
		board = new ArrayList<Card>();
		playersNames = new ArrayList<String>();
		infoRound = new InfoRound();
		reader = new Scanner(System.in);
		generateDeck = new GenerateDeck(deck);
		shuffleDeck = new ShuffleDeck(deck);
		generatePlayers = new GeneratePlayers(playersList, playersNames);
		rotatePlayersList = new RotatePlayersList(playersList);
		drawCardFromDeck = new DrawCardFromDeck(playersList, deck, board);
		setPokerHand = new SetPokerHand(playersList, pokerHand, board);
		compareHands = new CompareHands(playersList, pokerHand, infoRound);
		allIn = new AllIn(playersList, infoRound);
		bet = new Bet(playersList, infoRound);
		call = new Call(playersList, infoRound);
		check = new Check(playersList);
		fold = new Fold(playersList);
		playersInGame = new PlayersInGame(playersList, infoRound);
		getWhoWins = new GetWhoWins(playersList, infoRound);
		eliminatePlayers = new EliminatePlayers(playersList);
		isNextTurn = new IsNextTurn(playersList, infoRound);
		readyPlayer = new ReadyPlayer(playersList, infoRound);
		showHandPlayer = new ShowHandPlayer(playersList);
		showBoardCards = new ShowBoardCards(board, infoRound);
		showAvaliableCommands = new ShowAvaliableCommands(playersList, infoRound, showHandPlayer, bet, call, fold,
				check, allIn);
		this.stopLoopGame = stopLoopGame;

		this.idPlayerDealer = -1;
	}

	public void generate() {

		System.out.print("Escolha o total de jogadores(2 to 10): ");

		while (true) {
			this.input = reader.next();
			if (isNumeric(input) == true) {
				this.dTotalPlayers = Double.parseDouble(input);
				this.totalPlayers = (int) Math.round(this.dTotalPlayers);
				if (this.totalPlayers != this.dTotalPlayers)
					System.out.println("Numero double, tente outro valor");
				else {
					if (this.totalPlayers < 2 || this.totalPlayers > 10)
						System.out.println("Fora do limite de jogadores");
					else
						break;
				}
			} else {
				System.out.println("Nao e um numero, coloque outro valor");
			}

		}

		System.out.println("Insira o nome dos jogadores(Min = 1, Max = 20)");

		for (int i = 0; i < this.totalPlayers; i++) {
			while (true) {
				this.name = reader.next();
				if (this.name.length() >= 1 && this.name.length() <= 20)
					break;
				else
					System.out.println("Nome fora dos padr�es(Min = 1, Max = 20)");
			}

			this.playersNames.add(this.name);
		}

		this.generatePlayers.execute();
		this.generateDeck.execute();

	}

	public void Turns() {

		this.readyPlayer.execute();
		this.infoRound.setTurn(this.turn);

		if (this.turn == 0) {
			this.shuffleDeck.execute();
			this.drawCardFromDeck.execute();
			this.totalBetPerRound = 0;
			for (int i = 0; i < this.playersList.getSizeList(); i++) {
				if ((this.idPlayerDealer != this.playersList.selectPlayer(i).getId())
						&& this.playersList.selectPlayer(i).isFold() == false) {
					this.idPlayerDealer = this.playersList.selectPlayer(i).getId();
					break;
				}

			}
			System.out.println("------Inicio Pre-Flop------");

			// Small Blind (5%)
			this.rotatePlayersList.execute();
			System.out.println("Player: " + this.playersList.selectPlayer(currentPlayer).getName());
			System.out.println("Aposta automatica do small blind");
			this.infoRound.setMinimumBet((int) Math.round(this.playersList.getInitChips() * 0.05));
			this.call.execute();
			System.out.println("");
			// Big Blind (10%)
			this.rotatePlayersList.execute();
			System.out.println("Player: " + this.playersList.selectPlayer(currentPlayer).getName());
			System.out.println("Aposta automatica do big blind");
			this.infoRound.setMinimumBet((int) Math.round(this.playersList.getInitChips() * 0.1));
			this.call.execute();
			this.idPlayerBigBlind = this.playersList.selectPlayer(currentPlayer).getId();
			System.out.println("");
			// Next player after Big Blind
		} else if (this.turn == 1 && infoRound.getPlayersInTurn() > 1) {
			System.out.println("------Inicio Flop------");
			System.out.println("Cartas da mesa:\n");
			this.showBoardCards.execute();
			System.out.println("");
			this.idPlayerBigBlind = this.idPlayerDealer;
			this.infoRound.setMinimumBet(0);
			// Some code here//
		} else if (this.turn == 2 && infoRound.getPlayersInTurn() > 1) {
			System.out.println("------Inicio Turn------");
			System.out.println("Cartas da mesa:\n");
			this.showBoardCards.execute();
			System.out.println("");
			this.idPlayerBigBlind = this.idPlayerDealer;
			this.infoRound.setMinimumBet(0);
			// some code here//
		} else if (this.turn == 3 && infoRound.getPlayersInTurn() > 1) {
			System.out.println("------Inicio River------");
			System.out.println("Cartas da mesa:\n");
			this.showBoardCards.execute();
			System.out.println("");
			this.idPlayerBigBlind = this.idPlayerDealer;
			this.infoRound.setMinimumBet(0);
			// some code here//
		}

		if (this.turn == 0 || this.infoRound.getPlayersInTurn() > 1) {

			this.rotatePlayersList.execute();

			while (true) {
				if (this.playersList.selectPlayer(currentPlayer).isFold() == false
						&& this.playersList.selectPlayer(currentPlayer).inGame() == true) {

					this.showAvaliableCommands.execute();

				} else {
					System.out.println(
							this.playersList.selectPlayer(currentPlayer).getName() + " -> Fold ou fora do game");
				}
				System.out.println("");
				if (this.playersList.selectPlayer(currentPlayer).getId() == this.idPlayerBigBlind) {
					this.isNextTurn.execute();
					if (this.infoRound.isNextTurn() == true) {
						this.idCurrentPlayer = -1;
						while (true) {
							if (this.playersList.selectPlayer(currentPlayer).getId() == this.idPlayerDealer)
								break;
							this.rotatePlayersList.execute();
						}
						break;
					}
				}
				this.rotatePlayersList.execute();
			}

			this.totalBetPerTurn = 0;
			for (int i = 0; i < playersList.getSizeList(); i++) {
				this.totalBetPerTurn += playersList.selectPlayer(i).getTotalBet();
			}
			this.totalBetPerRound += this.totalBetPerTurn;
			this.infoRound.setTotalBet(this.totalBetPerRound);
			if (this.turn == 0) {
				System.out.println("");
				System.out.println("Total de aposta no Pre-Flop: " + this.totalBetPerTurn);
				System.out.println("Total de aposta no Round: " + this.totalBetPerRound);
				System.out.println("Saiu do Pre-Flop\n");
			} else if (this.turn == 1) {
				System.out.println("");
				System.out.println("Total de aposta no Flop: " + this.totalBetPerTurn);
				System.out.println("Total de aposta no Round: " + this.totalBetPerRound);
				System.out.println("Saiu do Flop\n");
			} else if (this.turn == 2) {
				System.out.println("");
				System.out.println("Total de aposta no Turn: " + this.totalBetPerTurn);
				System.out.println("Total de aposta no Round: " + this.totalBetPerRound);
				System.out.println("Saiu do Turn\n");
			} else if (this.turn == 3) {
				System.out.println("");
				System.out.println("Total de aposta no River: " + this.totalBetPerTurn);
				System.out.println("Total de aposta no Round: " + this.totalBetPerRound);
				System.out.println("Saiu do River\n");

			}

		}

		this.turn++;
		if (this.turn == 4) {
			if (this.infoRound.getPlayersInTurn() > 1) {
				this.setPokerHand.execute();
			}
			this.compareHands.execute();
			this.rotatePlayersList.execute();
			this.eliminatePlayers.execute();
			this.playersInGame.execute();
			this.turn = 0;
			if (this.infoRound.getPlayersInGame() == 1)
				this.stopLoopGame.setStopLoopGame(true);
			else
				this.stopLoopGame.setStopLoopGame(false);
		}

	}

	public void whoWinsGame() {

		this.getWhoWins.execute();
		System.out.println("\n\n --->Ganhador do jogo: "
				+ this.playersList.selectPlayer(this.infoRound.getWhoWins()).getName() + "<---");
		System.out.println("****Fim do jogo****\n");

	}

}
