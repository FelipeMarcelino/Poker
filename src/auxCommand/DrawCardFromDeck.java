package auxCommand;

import deck.Deck;
import player.PlayersList;

public class DrawCardFromDeck implements AuxCommand{
	private PlayersList playersList;
	private Deck deck;
	private int playerIndex;
	
	public DrawCardFromDeck(PlayersList playersList,Deck deck){
		this.playersList = playersList;
		this.deck = deck;
	}
	
	@Override
	public void execute() {
		this.playerIndex = -1;
		for(int i = 0; i < this.playersList.getSizeList() * 2; i++){
			if(i % 2 == 0) this.playerIndex++;
			this.playersList.selectPlayer(this.playerIndex).receiveCard(this.deck.drawCardFromDeck(i));
		}
	}
}
