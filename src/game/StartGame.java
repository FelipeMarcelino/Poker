package game;

import pokerCommand.PokerFlop;
import pokerCommand.PokerGenerate;
import pokerCommand.PokerPreFlop;
import pokerCommand.PokerRiver;
import pokerCommand.PokerTurn;
import pokerCommand.PokerWhoWinsGame;
import pokerCommand.PokerWhoWinsRound;

public class StartGame {

	public static void startGame(PokerGenerate pokerGenerate,PokerPreFlop pokerPreFlop,PokerFlop pokerFlop,PokerTurn pokerTurn,
	PokerRiver pokerRiver,PokerWhoWinsGame pokerWhoWinsGame,PokerWhoWinsRound pokerWhoWinsRound){
		
		pokerGenerate.execute();
		pokerPreFlop.execute();
		pokerFlop.execute();
		
		
	}
	
}
