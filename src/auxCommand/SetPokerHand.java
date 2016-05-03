package auxCommand;

import java.util.ArrayList;

import deck.Card;
import player.PlayersList;
import pokerHand.PokerHand;

public class SetPokerHand implements AuxCommand{
	
	private PlayersList playersList;
	private ArrayList<Card> board;
	private PokerHand pokerHand;


	
	public SetPokerHand( PlayersList playersList,PokerHand pokerHand,ArrayList<Card> board){
		this.playersList = playersList;
		this.board = board;
		this.pokerHand = pokerHand;
	}



	@Override
	public void execute() {
		this.pokerHand.GetPokerHand(this.playersList,this.board);
	}
	
	
	
	
	
}
