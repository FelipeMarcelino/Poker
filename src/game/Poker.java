package game;

import java.util.ArrayList;
import java.util.Arrays;
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
	private int option;
	private static int currentPlayer = 0;
	private int totalBetPerRound;
	private int totalBetPerTurn;
	private String name;
	private String input;
	private double dTotalPlayers;
	private boolean[] avaliableOptions = new boolean[5];
	
	

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
			this.input = reader.next();
			if(isNumeric(input) == true){
				this.dTotalPlayers = Double.parseDouble(input);
				this.totalPlayers = (int) Math.round(this.dTotalPlayers);
				if(this.totalPlayers != this.dTotalPlayers) System.out.println("Numero double, tente outro valor");
				else{
					if(this.totalPlayers < 2 || this.totalPlayers > 10) System.out.println("Fora do limite de jogadores");
					else break;
				}
			}
			else{
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
	
	public void preFlop(){
		
		this.shuffleDeck.execute();
		this.drawCardFromDeck.execute();
		this.readyPlayer.execute();
		
		this.infoRound.initTotalBetRound();
		this.infoRound.initTotalBetTurn();
		
		this.idPlayerDealer = this.playersList.selectPlayer(currentPlayer).getId();
		
		this.totalBetPerRound = 0;
		
		System.out.println("Inicio Pre-Flop");
		
		//Small Blind (5%)
		this.rotatePlayersList.execute();
		System.out.println("Player: " + this.playersList.selectPlayer(currentPlayer).getName());
		System.out.println("Aposta automatica do small blind");
		this.infoRound.setMinimumBet((int ) Math.round(this.playersList.getInitChips() * 0.05));
		this.call.execute();
		System.out.println("");
		//Big Blind (10%)
		this.rotatePlayersList.execute();
		System.out.println("Player: " + this.playersList.selectPlayer(currentPlayer).getName());
		System.out.println("Aposta automatica do big blind");
		this.infoRound.setMinimumBet((int ) Math.round(this.playersList.getInitChips() * 0.1));
		this.call.execute();
		this.idPlayerBigBlind = this.playersList.selectPlayer(currentPlayer).getId();
		System.out.println("");
		//Next player after Big Blind
		
		this.rotatePlayersList.execute();
		
		while(true){
			if(this.playersList.selectPlayer(currentPlayer).isFold() == false && 
					this.playersList.selectPlayer(currentPlayer).inGame() == true){
				
				System.out.print("Player: " + this.playersList.selectPlayer(currentPlayer).getName());
				System.out.println("->(Fichas disponiveis: "+ this.playersList.selectPlayer(currentPlayer).getChips() + ")");
				System.out.println("Fichas apostadas nesse turno: " + this.playersList.selectPlayer(currentPlayer).getTotalBet());
				System.out.println("Aposta minima: " + this.infoRound.getMinimumBet());
				this.showHandPlayer.execute();
				
				Arrays.fill(this.avaliableOptions, Boolean.FALSE);
				//Check avaliable
				if(this.playersList.selectPlayer(currentPlayer).isCheck() == false){
					this.avaliableOptions[0] = true;
				}else{
					if(this.playersList.selectPlayer(currentPlayer).isAllIn() == true) this.avaliableOptions[0] = true;
				}
				//Call avaliable
				if(this.playersList.selectPlayer(currentPlayer).getChips() >= (this.infoRound.getMinimumBet() - 
						this.playersList.selectPlayer(currentPlayer).getTotalBet())){
					this.avaliableOptions[1] = true;
					if(this.playersList.selectPlayer(currentPlayer).getTotalBet() == this.infoRound.getMinimumBet())
						this.avaliableOptions[1] = false;
					if(this.playersList.selectPlayer(currentPlayer).getChips() == (this.infoRound.getMinimumBet()
							- this.playersList.selectPlayer(currentPlayer).getTotalBet()))
						this.avaliableOptions[1] = false;
				}
				
				//Bet avaliable
				if(this.playersList.selectPlayer(currentPlayer).getChips() >= (this.infoRound.getMinimumBet() - 
						this.playersList.selectPlayer(currentPlayer).getTotalBet())){
					this.avaliableOptions[2] = true;
					if(this.playersList.selectPlayer(currentPlayer).isAllIn() == true) this.avaliableOptions[2] = false;
					if(this.playersList.selectPlayer(currentPlayer).getChips() == (this.infoRound.getMinimumBet()
							- this.playersList.selectPlayer(currentPlayer).getTotalBet()))
						this.avaliableOptions[2] = false;
				}
				
				//All in avaliable
				if(this.playersList.selectPlayer(currentPlayer).isAllIn() == false ) {
					this.avaliableOptions[3] = true;
				}
				
				//Fold avaliable
				this.avaliableOptions[4] = true;
				
				
				System.out.println("Opções que pode ser escolhidas");
				if(this.avaliableOptions[0] == true) System.out.print("Check(0)-");
				if(this.avaliableOptions[1] == true) System.out.print("Call(1)-");
				if(this.avaliableOptions[2] == true) System.out.print("Bet(2)-");
				if(this.avaliableOptions[3] == true) System.out.print("AllIn(3)-");
				if(this.avaliableOptions[4] == true) System.out.println("Fold(4)");
				
				while(true){
					while(true){
						input = reader.next();
						if(isNumeric(input) == true) break;
						else{
							System.out.println("N�o � um n�mero, coloque outro valor");
						}
					}
					
					this.option = Integer.parseInt(input);
					
					if(this.option > 4 || this.option < 0) System.out.println("Opcão fora do escopo aceitável");
					else{
						if(this.avaliableOptions[this.option] != true) System.out.println("Opcao não disponível");
						else break;
					}
					
				}
				
				if(this.option == 0) this.check.execute();
				else if(this.option == 1) this.call.execute();
				else if(this.option == 2) this.bet.execute();
				else if(this.option == 3) this.allIn.execute();
				else if(this.option == 4) this.fold.execute();
				
				
			}else {
				System.out.println(this.playersList.selectPlayer(currentPlayer).getName() +" -> Fold ou fora do game");
			}
			System.out.println("");
			if(this.playersList.selectPlayer(currentPlayer).getId() == this.idPlayerBigBlind){
				this.isNextTurn.execute();
				if(this.infoRound.isNextTurn() == true) {
					this.idCurrentPlayer = -1;
					while(true){ 
						if(this.playersList.selectPlayer(currentPlayer).getId() == this.idPlayerDealer) break;
						this.rotatePlayersList.execute();
					}
					break;
				}
			}
			this.rotatePlayersList.execute();
		}
		
		
		this.totalBetPerTurn = 0;
		for(int i = 0; i < playersList.getSizeList(); i++){
			this.totalBetPerTurn += playersList.selectPlayer(i).getTotalBet();
		}
		this.totalBetPerRound += this.totalBetPerTurn;
		System.out.println("");
		System.out.println("Total de aposta no Pre-Flop: "+ this.totalBetPerTurn);
		System.out.println("Total de aposta no Round: "+ this.totalBetPerRound);
		System.out.println("Saiu do flop");
		
	}
	
	public void flop(){
		System.out.println("Inicio Flop");
		this.infoRound.initTotalBetTurn();
		this.readyPlayer.execute();
		this.rotatePlayersList.execute();
		
		
		
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
