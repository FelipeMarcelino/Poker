package game;

import java.util.ArrayList;

import auxCommand.CompareHands;
import auxCommand.DrawCardFromDeck;
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

public abstract class Poker {
	
	private static  Deck deck = new Deck();
	private static 	PlayersList playersList = new PlayersList();
	private static  PokerHand pokerHand = new PokerHand();
	private static  ArrayList<Card> board = new ArrayList<Card>();
	protected static  ArrayList<String> playersNames = new ArrayList<String>();		
	protected static  InfoRound infoRound = new InfoRound();
	

	//Comandos
	
	protected static GenerateDeck generateDeck = new GenerateDeck(deck);
	protected static  ShuffleDeck shuffleDeck = new ShuffleDeck(deck);
	protected static GeneratePlayers generatePlayers = new GeneratePlayers(playersList,playersNames);
	protected static  RotatePlayersList rotatePlayersList = new RotatePlayersList(playersList);
	protected static  DrawCardFromDeck drawCardFromDeck = new DrawCardFromDeck(playersList,deck,board);
	protected static  SetPokerHand setPokerHand = new SetPokerHand(playersList,pokerHand,board);
	protected static CompareHands compareHands = new CompareHands(playersList,pokerHand);
	protected static AllIn allIn = new AllIn(playersList,infoRound);
	protected static  Bet bet = new Bet(playersList,infoRound);
	protected static  Call call = new Call(playersList,infoRound);
	protected static  Check check = new Check(playersList);
	protected static  Fold fold = new Fold(playersList);
	protected static  PlayersInGame playersInGame = new PlayersInGame(playersList,infoRound);
	
	


}
