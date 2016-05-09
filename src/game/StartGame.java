package game;


import pokerCommand.PokerGenerate;
import pokerCommand.PokerTurns;
import pokerCommand.PokerWhoWinsGame;
import pokerCommand.PokerWhoWinsRound;

public class StartGame {

	public static void startGame(PokerGenerate pokerGenerate,PokerTurns pokerTurns,
			PokerWhoWinsGame pokerWhoWinsGame,PokerWhoWinsRound pokerWhoWinsRound){
		
		pokerGenerate.execute();
		
		//Some code here: while//
		pokerTurns.execute();
		
		
		//Finish while, decide who win game//
		
		
	}
	
}
