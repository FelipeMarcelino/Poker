import game.Poker;
import game.PokerGenerate;
import game.StartGame;
import pokerCommand.PokerGenerateExec;
import pokerCommand.StartGameExec;

public class Main {

	public static void main(String[] args) {
		
		PokerGenerate pokerGenerate = new PokerGenerate();
		StartGame startGame =  new StartGame();
		PokerGenerateExec pokerGenerateExec = new PokerGenerateExec(pokerGenerate);
		StartGameExec startGameExec = new StartGameExec(startGame);
		
		pokerGenerateExec.execute();
		startGameExec.execute();
		
		
	}

}
