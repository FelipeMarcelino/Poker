package gameCommand;

import game.InfoRound;
import player.PlayersList;

public class AllIn implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	private int bet;

	public AllIn(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.bet = this.playersList.selectPlayer(0).allIn();
		if (this.bet > this.infoRound.getMinimumBet())
			this.infoRound.setMinimumBet(this.bet);
	}

}
