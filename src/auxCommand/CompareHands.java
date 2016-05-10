package auxCommand;

import game.InfoRound;
import player.PlayersList;
import pokerHand.PokerHand;

public class CompareHands implements AuxCommand {

	private PlayersList playersList;
	private PokerHand pokerHand;
	private InfoRound infoRound;

	public CompareHands(PlayersList playersList, PokerHand pokerHand, InfoRound infoRound) {
		this.playersList = playersList;
		this.pokerHand = pokerHand;
		this.infoRound = infoRound;
	}

	@Override
	public void execute() {
		this.pokerHand.comparePokerHand(this.playersList, this.infoRound.getTotalBet());
	}

}
