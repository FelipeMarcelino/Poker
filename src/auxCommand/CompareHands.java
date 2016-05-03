package auxCommand;

import player.PlayersList;
import pokerHand.PokerHand;

public class CompareHands implements AuxCommand{

	private PlayersList playersList;
	private PokerHand pokerHand;
	
	public CompareHands(PlayersList playersList,PokerHand pokerHand){
		this.playersList = playersList;
		this.pokerHand = pokerHand;
	}
	
	@Override
	public void execute() {
		this.pokerHand.comparePokerHand(this.playersList);
	}

}
