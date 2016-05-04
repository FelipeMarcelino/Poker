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
	
	public static String[] suits = {"Hearts","Diamonds","Spade","Clubs"};
	public static String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queens","King"};
	
	private  Deck deck;
	private  PlayersList playersList;
	private  PokerHand pokerHand;
	private  ArrayList<Card> board;
	private  ArrayList<String> playersNames;		
	private  InfoRound infoRound;
	private Scanner reader;
	private int totalPlayers;
	private int idPlayerBigBlind;
	private int idPlayerDealer;
	private int idCurrentPlayer;
	private String name;
	private String input;
	
	

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
	private ReadyPlayer readyPlayer;
	private ShowHandPlayer showHandPlayer;
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
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
		readyPlayer = new ReadyPlayer(playersList);
		showHandPlayer = new ShowHandPlayer(playersList);
	}
	
	public void generate() {

		System.out.print("Escolha o total de jogadores(2 to 10): ");
		
		while(true){
			input = reader.next();
			if(isNumeric(input) == true) break;
			else{
				System.out.println("Não é um número, coloque outro valor");
			}
		}
		this.totalPlayers = Integer.parseInt(input);

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
		
		this.shuffleDeck.execute();
		this.drawCardFromDeck.execute();
		this.readyPlayer.execute();
		
		this.infoRound.initTotalBetRound();
		this.infoRound.initTotalBetTurn();
		
		this.idPlayerDealer = this.playersList.selectPlayer(0).getId();
		
		//Small Blind (5%)
		this.rotatePlayersList.execute();
		System.out.println("Player: " + this.playersList.selectPlayer(0).getName());
		System.out.println("Aposta automatica do small blind");
		this.infoRound.setMinimumBet((int ) Math.round(this.playersList.getInitChips() * 0.05));
		this.call.execute();
		//Big Blind (10%)
		this.rotatePlayersList.execute();
		System.out.println("Player: " + this.playersList.selectPlayer(0).getName());
		System.out.println("Aposta automatica do big blind");
		this.infoRound.setMinimumBet((int ) Math.round(this.playersList.getInitChips() * 0.1));
		this.call.execute();
		this.idPlayerBigBlind = this.playersList.selectPlayer(0).getId();
		
		//Next player after Big Blind
		
		this.rotatePlayersList.execute();
		
		
		
	
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
