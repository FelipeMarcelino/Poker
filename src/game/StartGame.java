package game;

import pokerCommand.PokerGenerate;
import pokerCommand.PokerTurns;
import pokerCommand.PokerWhoWinsGame;

public class StartGame {

	public static void startGame(PokerGenerate pokerGenerate, PokerTurns pokerTurns, PokerWhoWinsGame pokerWhoWinsGame,
			StopLoopGame stopLoopGame) {

		pokerGenerate.execute();

		while (true) {
			pokerTurns.execute();
			pokerTurns.execute();
			pokerTurns.execute();
			pokerTurns.execute();
			if (stopLoopGame.isStopLoopGame() == true)
				break;
		}

		pokerWhoWinsGame.execute();

	}

}
