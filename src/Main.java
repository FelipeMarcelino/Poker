import java.util.ArrayList;

import auxCommand.CompareHands;
import auxCommand.DrawCardFromDeck;
import auxCommand.RotatePlayersList;
import auxCommand.SetPokerHand;
import auxCommand.ShuffleDeck;
import deck.Card;
import deck.Deck;
import generateCommand.GenerateDeck;
import generateCommand.GeneratePlayers;
import player.PlayersList;
import pokerHand.PokerHand;

public class Main {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		PlayersList playersList = new PlayersList();
		PokerHand pokerHand = new PokerHand();
		ArrayList<String> playersNames = new ArrayList<String>();		
		ArrayList<Card> board = new ArrayList<Card>();
		
		GenerateDeck generateDeck = new GenerateDeck(deck);
		ShuffleDeck shuffleDeck = new ShuffleDeck(deck);
		GeneratePlayers generatePlayers = new GeneratePlayers(playersList,playersNames);
		RotatePlayersList rotatePlayersList = new RotatePlayersList(playersList);
		DrawCardFromDeck drawCardFromDeck = new DrawCardFromDeck(playersList,deck,board);
		SetPokerHand setPokerHand = new SetPokerHand(playersList,pokerHand,board);
		CompareHands compareHands = new CompareHands(playersList,pokerHand);
		
		playersNames.add("A");
		playersNames.add("B");
		playersNames.add("C");
		playersNames.add("D");
		
		generateDeck.execute();
		generatePlayers.execute();
		shuffleDeck.execute();
		//rotatePlayersList.execute();
		drawCardFromDeck.execute();
		setPokerHand.execute();
		
		
	
		
		
		
		for(int p = 0; p < 5; p++){
			System.out.println(board.get(p).getRank() + " " + board.get(p).getSuit());
		}
		
		for(int i = 0; i < 4; i++){
			System.out.println(i);
			System.out.println(playersList.selectPlayer(i).getPowerHand());
			for(int k = 0; k < 2; k++){
				System.out.println(playersList.selectPlayer(i).getHand().get(k).getRank() + " " + playersList.selectPlayer(i).getHand().get(k).getSuit());
			}
			System.out.println("Melhor mão");
			for(int k = 0; k < playersList.selectPlayer(i).getBestFive().size(); k++){
				System.out.println(playersList.selectPlayer(i).getBestFive().get(k).getRank() + " " + playersList.selectPlayer(i).getBestFive().get(k).getSuit());
			}
			
			System.out.println("\n");
			
		}
		
		
		compareHands.execute();		
		
	}

}
