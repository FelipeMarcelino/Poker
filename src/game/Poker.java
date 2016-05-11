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
		this.deck = new Deck();
		this.playersList = new PlayersList();
		this.pokerHand = new PokerHand();
		this.board = new ArrayList<Card>();
		this.playersNames = new ArrayList<String>();
		this.infoRound = new InfoRound();
		this.reader = new Scanner(System.in);
		this.generateDeck = new GenerateDeck(this.deck);
		this.shuffleDeck = new ShuffleDeck(this.deck);
		this.generatePlayers = new GeneratePlayers(this.playersList, this.playersNames);
		this.rotatePlayersList = new RotatePlayersList(this.playersList);
		this.drawCardFromDeck = new DrawCardFromDeck(this.playersList, this.deck, this.board);
		this.setPokerHand = new SetPokerHand(this.playersList, this.pokerHand, this.board);
		this.compareHands = new CompareHands(this.playersList, this.pokerHand, this.infoRound);
		this.allIn = new AllIn(this.playersList, this.infoRound);
		this.bet = new Bet(this.playersList, this.infoRound);
		this.call = new Call(this.playersList, this.infoRound);
		this.check = new Check(this.playersList);
		this.fold = new Fold(this.playersList);
		this.playersInGame = new PlayersInGame(this.playersList, this.infoRound);
		this.getWhoWins = new GetWhoWins(this.playersList, this.infoRound);
		this.eliminatePlayers = new EliminatePlayers(this.playersList);
		this.isNextTurn = new IsNextTurn(this.playersList, this.infoRound);
		this.readyPlayer = new ReadyPlayer(this.playersList, this.infoRound);
		this.showHandPlayer = new ShowHandPlayer(this.playersList);
		this.showBoardCards = new ShowBoardCards(this.board, this.infoRound);
		this.showAvaliableCommands = new ShowAvaliableCommands(this.playersList, this.infoRound, this.showHandPlayer, this.bet, this.call, this.fold,
				this.check, this.allIn);
		this.stopLoopGame = stopLoopGame;

		this.idPlayerDealer = -1;
	}

	public void generate() {

		System.out.print("Escolha o total de jogadores(2 to 10): ");

		while (true) {
			this.input = this.reader.next();
			if (isNumeric(this.input) == true) {
				this.dTotalPlayers = Double.parseDouble(this.input);
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
				this.name = this.reader.next();
				if (this.name.length() >= 1 && this.name.length() <= 20)
					break;
				else
					System.out.println("Nome fora dos padroes(Min = 1, Max = 20)");
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
		} else if (this.turn == 1 && this.infoRound.getPlayersInTurn() > 1) {
			System.out.println("------Inicio Flop------");
			System.out.println("Cartas da mesa:\n");
			this.showBoardCards.execute();
			System.out.println("");
			this.idPlayerBigBlind = this.idPlayerDealer;
			this.infoRound.setMinimumBet(0);
			// Some code here//
		} else if (this.turn == 2 && this.infoRound.getPlayersInTurn() > 1) {
			System.out.println("------Inicio Turn------");
			System.out.println("Cartas da mesa:\n");
			this.showBoardCards.execute();
			System.out.println("");
			this.idPlayerBigBlind = this.idPlayerDealer;
			this.infoRound.setMinimumBet(0);
			// some code here//
		} else if (this.turn == 3 && this.infoRound.getPlayersInTurn() > 1) {
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
			for (int i = 0; i < this.playersList.getSizeList(); i++) {
				this.totalBetPerTurn += this.playersList.selectPlayer(i).getTotalBet();
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
