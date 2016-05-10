package gameCommand;

import game.InfoRound;
import player.PlayersList;

public class Bet implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	private int bet;

	public Bet(PlayersList playersList, InfoRound infoRound) {
		this.playersList = playersList;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.bet = this.playersList.selectPlayer(0).bet(this.infoRound.getMinimumBet());
		if (this.bet > this.infoRound.getMinimumBet())
			this.infoRound.setMinimumBet(this.bet);
	}

}
