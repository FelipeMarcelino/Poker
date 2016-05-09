import game.Poker;
import game.StartGame;
import pokerCommand.PokerGenerate;
import pokerCommand.PokerTurns;
import pokerCommand.PokerWhoWinsGame;
import pokerCommand.PokerWhoWinsRound;

public class Main {

	public static void main(String[] args) {
		
		Poker poker = new Poker();
		PokerGenerate pokerGenerate = new PokerGenerate(poker);
		PokerTurns pokerTurns= new PokerTurns(poker);
		PokerWhoWinsGame pokerWhoWinsGame = new PokerWhoWinsGame(poker);
		PokerWhoWinsRound pokerWhoWinsRound = new PokerWhoWinsRound(poker);
		
		StartGame.startGame(pokerGenerate, pokerTurns,pokerWhoWinsGame, pokerWhoWinsRound);
		
	}

}
