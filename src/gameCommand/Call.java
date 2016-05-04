package gameCommand;

import game.InfoRound;
import player.PlayersList;

public class Call implements GameCommand {

	private PlayersList playersList;
	private InfoRound infoRound;
	private int bet;
	
	public Call(PlayersList playersList,InfoRound infoRound){
		this.playersList = playersList;
		this.infoRound = infoRound;
	}
	
	@Override
	public void execute() {
		this.bet = this.playersList.selectPlayer(0).call(infoRound.getMinimumBet());	
		this.infoRound.sumTotalBetRound(this.bet);
		this.infoRound.sumTotalBetTurn(this.bet);
	}

}
