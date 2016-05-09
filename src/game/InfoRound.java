package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import auxCommand.ShowHandPlayer;
import deck.Card;
import gameCommand.AllIn;
import gameCommand.Bet;
import gameCommand.Call;
import gameCommand.Check;
import gameCommand.Fold;
import player.PlayersList;

public class InfoRound {

	private int minimumBet;
	private int whoWinsRound;
	private int whoWinsTurn;
	private int totalBetTurn;
	private int totalBetRound;
	private int option;
	private int indexShowBoardCard = 3;
	private static int currentPlayer = 0;
	private boolean nextTurn;
	private boolean[] avaliableOptions = new boolean[5];
	private String input;
	private Scanner reader = new Scanner(System.in);

	
	public int getTotalBetTurn() {
		return totalBetTurn;
	}

	public void sumTotalBetTurn(int totalBetTurn) {
		this.totalBetTurn += totalBetTurn;
	}

	public int getTotalBetRound() {
		return totalBetRound;
	}

	public void sumTotalBetRound(int totalBetRound) {
		this.totalBetRound += totalBetRound;
	}	

	
	public int getWhoWinsRound() {
		return whoWinsRound;
	}

	public void setWhoWinsRound(int whoWinsRound) {
		this.whoWinsRound = whoWinsRound;
	}

	public int getWhoWinsTurn() {
		return whoWinsTurn;
	}

	public void setWhoWinsTurn(int whoWinsTurn) {
		this.whoWinsTurn = whoWinsTurn;
	}

	public int getMinimumBet() {
		return minimumBet;
	}
	public void setMinimumBet(int minimumBet) {
		this.minimumBet = minimumBet;
	}
	

	public boolean isNextTurn() {
		return nextTurn;
	}

	public void setNextTurn(boolean nextTurn) {
		this.nextTurn = nextTurn;
	}
	
	public void initTotalBetRound(){
		this.totalBetRound = 0;
	}
	
	public void initTotalBetTurn(){
		this.totalBetTurn = 0;
	}
	
	public void showBoardCard(ArrayList<Card> board){
		for(int i = 0; i < this.indexShowBoardCard; i++){
			System.out.println(Poker.ranks[board.get(i).getRank()] + " of " + Poker.suits[board.get(i).getSuit()]);
		}
		this.indexShowBoardCard ++;
		if(this.indexShowBoardCard == 6) this.indexShowBoardCard = 0;
	}
	
	public void showAvaliableCommands(PlayersList playersList,ShowHandPlayer showHandPlayer,Check check,Bet bet,
			AllIn allIn,Call call,Fold fold){
		System.out.print("Player: " + playersList.selectPlayer(currentPlayer).getName());
		System.out.println("->(Fichas disponiveis: "+ playersList.selectPlayer(currentPlayer).getChips() + ")");
		System.out.println("Fichas apostadas nesse turno: " + playersList.selectPlayer(currentPlayer).getTotalBet());
		System.out.println("Aposta minima: " + this.minimumBet);
		showHandPlayer.execute();
		
		Arrays.fill(avaliableOptions, Boolean.FALSE);
		//Check avaliable
		if(playersList.selectPlayer(currentPlayer).isCheck() == false){
			avaliableOptions[0] = true;
		}else{
			if(playersList.selectPlayer(currentPlayer).isAllIn() == true) avaliableOptions[0] = true;
		}
		//Call avaliable
		if(playersList.selectPlayer(currentPlayer).getChips() >= (this.minimumBet - 
				playersList.selectPlayer(currentPlayer).getTotalBet())){
			avaliableOptions[1] = true;
			if(playersList.selectPlayer(currentPlayer).getTotalBet() == this.minimumBet)
				avaliableOptions[1] = false;
			if(playersList.selectPlayer(currentPlayer).getChips() == (this.minimumBet
					- playersList.selectPlayer(currentPlayer).getTotalBet()))
				avaliableOptions[1] = false;
		}
		
		//Bet avaliable
		if(playersList.selectPlayer(currentPlayer).getChips() >= (this.minimumBet - 
				playersList.selectPlayer(currentPlayer).getTotalBet())){
			avaliableOptions[2] = true;
			if(playersList.selectPlayer(currentPlayer).isAllIn() == true) avaliableOptions[2] = false;
			if(playersList.selectPlayer(currentPlayer).getChips() == (this.minimumBet
					- playersList.selectPlayer(currentPlayer).getTotalBet()))
				avaliableOptions[2] = false;
		}
		
		//All in avaliable
		if(playersList.selectPlayer(currentPlayer).isAllIn() == false ) {
			avaliableOptions[3] = true;
		}
		
		//Fold avaliable
		avaliableOptions[4] = true;
		
		
		System.out.println("Opções que pode ser escolhidas");
		if(avaliableOptions[0] == true) System.out.print("Check(0)-");
		if(avaliableOptions[1] == true) System.out.print("Call(1)-");
		if(avaliableOptions[2] == true) System.out.print("Bet(2)-");
		if(avaliableOptions[3] == true) System.out.print("AllIn(3)-");
		if(avaliableOptions[4] == true) System.out.println("Fold(4)");
		
		while(true){
			while(true){
				this.input = reader.next();
				if(Poker.isNumeric(input) == true) break;
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
		
		if(this.option == 0) check.execute();
		else if(this.option == 1) call.execute();
		else if(this.option == 2) bet.execute();
		else if(this.option == 3) allIn.execute();
		else if(this.option == 4) fold.execute();

	}
	
	
}
