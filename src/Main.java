import game.Poker;
import game.StartGame;
import game.StopLoopGame;
import pokerCommand.PokerGenerate;
import pokerCommand.PokerTurns;
import pokerCommand.PokerWhoWinsGame;

public class Main {

	public static void main(String[] args) {
		
		StopLoopGame stopLoopGame = new StopLoopGame();
		Poker poker = new Poker(stopLoopGame);
		PokerGenerate pokerGenerate = new PokerGenerate(poker);
		PokerTurns pokerTurns= new PokerTurns(poker);
		PokerWhoWinsGame pokerWhoWinsGame = new PokerWhoWinsGame(poker);
		
		StartGame.startGame(pokerGenerate, pokerTurns,pokerWhoWinsGame,stopLoopGame);
		
	}

}
