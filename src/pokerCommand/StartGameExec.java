package pokerCommand;

import game.StartGame;

public class StartGameExec implements PokerCommand {

	private StartGame startGame;
	
	public StartGameExec(StartGame StartGame){
		this.startGame = StartGame;
	}

	@Override
	public void execute() {
		this.startGame.playing();
	}
	
	
}
