import game.Poker;
import game.StartGame;
import pokerCommand.PokerFlop;
import pokerCommand.PokerGenerate;
import pokerCommand.PokerPreFlop;
import pokerCommand.PokerRiver;
import pokerCommand.PokerTurn;
import pokerCommand.PokerWhoWinsGame;
import pokerCommand.PokerWhoWinsRound;

public class Main {

	public static void main(String[] args) {
		
		Poker poker = new Poker();
		PokerGenerate pokerGenerate = new PokerGenerate(poker);
		PokerPreFlop pokerPreFlop = new PokerPreFlop(poker);
		PokerFlop pokerFlop = new PokerFlop(poker);
		PokerTurn pokerTurn = new PokerTurn(poker);
		PokerRiver pokerRiver = new PokerRiver(poker);
		PokerWhoWinsGame pokerWhoWinsGame = new PokerWhoWinsGame(poker);
		PokerWhoWinsRound pokerWhoWinsRound = new PokerWhoWinsRound(poker);
		
		StartGame.startGame(pokerGenerate, pokerPreFlop, pokerFlop, pokerTurn, pokerRiver, pokerWhoWinsGame, pokerWhoWinsRound);
		
	}

}
