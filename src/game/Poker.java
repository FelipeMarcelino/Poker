package game;

import java.util.ArrayList;
import java.util.Scanner;

import auxCommand.CompareHands;
import auxCommand.DrawCardFromDeck;
import auxCommand.EliminatePlayers;
import auxCommand.GetWhoWins;
import auxCommand.IsNextTurn;
import auxCommand.PlayersInGame;
import auxCommand.RotatePlayersList;
import auxCommand.SetPokerHand;
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
	
	private  Deck deck;
	private  PlayersList playersList;
	private  PokerHand pokerHand;
	private  ArrayList<Card> board;
	private  ArrayList<String> playersNames;		
	private  InfoRound infoRound;
	private Scanner reader;
	private int totalPlayers;
	private String name;
	

	//Comandos
	
	private GenerateDeck generateDeck;
	private  ShuffleDeck shuffleDeck;
	private GeneratePlayers generatePlayers;
	private  RotatePlayersList rotatePlayersList;
	private  DrawCardFromDeck drawCardFromDeck;
	private  SetPokerHand setPokerHand;
	private CompareHands compareHands;
	private AllIn allIn;
	private  Bet bet;
	private  Call call;
	private  Check check;
	private  Fold fold;
	private  PlayersInGame playersInGame;
	private GetWhoWins getWhoWins;
	private EliminatePlayers eliminatePlayers;
	private IsNextTurn isNextTurn;
	
	public Poker(){
		deck = new Deck();
		playersList = new PlayersList();
		pokerHand = new PokerHand();
		board = new ArrayList<Card>();
		playersNames = new ArrayList<String>();		
		infoRound = new InfoRound();
		reader = new Scanner(System.in);
		generateDeck = new GenerateDeck(deck);
		shuffleDeck = new ShuffleDeck(deck);
		generatePlayers = new GeneratePlayers(playersList,playersNames);
		rotatePlayersList = new RotatePlayersList(playersList);
		drawCardFromDeck = new DrawCardFromDeck(playersList,deck,board);
		setPokerHand = new SetPokerHand(playersList,pokerHand,board);
		compareHands = new CompareHands(playersList,pokerHand);
		allIn = new AllIn(playersList,infoRound);
		bet = new Bet(playersList,infoRound);
		call = new Call(playersList,infoRound);
		check = new Check(playersList,infoRound);
		fold = new Fold(playersList,infoRound);
		playersInGame = new PlayersInGame(playersList,infoRound);
		getWhoWins = new GetWhoWins(playersList,infoRound);
		eliminatePlayers = new EliminatePlayers(playersList,infoRound);
		isNextTurn =  new IsNextTurn(playersList,infoRound);
	}
	
	public void generate() {

		System.out.print("Escolha o total de jogadores(2 to 10): ");
		this.totalPlayers = reader.nextInt();

		while (this.totalPlayers < 2 || this.totalPlayers > 10) {
			System.out.print("Numero de jogadores fora do limite, entre com um novo numero(2 to 10): ");
			this.totalPlayers = reader.nextInt();
		}

		System.out.println("Insira o nome dos jogadores(Min = 1, Max = 20)");

		for (int i = 0; i < this.totalPlayers; i++) {
			while (true) {
				this.name = reader.next();
				if (this.name.length() >= 1 && this.name.length() <= 20)
					break;
				else
					System.out.println("Nome fora dos padrões(Min = 1, Max = 20)");
			}

			this.playersNames.add(this.name);
		}

		this.generatePlayers.execute();
		this.generateDeck.execute();

	}
	
	public void preFlop(){
		
	}
	
	public void flop(){
		
	}
	
	public void turn(){
		
	}
	
	public void river(){
		
	}
	
	public void whoWinsRound(){
		
	}
	
	public void whoWinsGame(){
		
	}
	
}
