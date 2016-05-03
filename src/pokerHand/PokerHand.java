package pokerHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import deck.Card;
import player.PlayersList;;

public class PokerHand {

	private HighCard highCard = HighCard.getInstance(); 
	private OnePair onePair = OnePair.getInstance();
	private TwoPair twoPair = TwoPair.getInstance();
	private ThreeOfAKind threeOfAKind = ThreeOfAKind.getInstance();
	private Straight straight = Straight.getInstance();
	private Flush flush = Flush.getInstance();
	private FullHouse fullHouse = FullHouse.getInstance();
	private FourOfAKind fourOfAKind = FourOfAKind.getInstance();
	private StraightFlush straightFlush = StraightFlush.getInstance();
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	
	private void ordenateHand(){
		Collections.sort(this.hand, new Comparator<Card>(){

			@Override
			public int compare(Card arg0, Card arg1) {
				
				return Card.values[arg0.getRank()] - Card.values[arg1.getRank()];
			}
			
		});
		
		Collections.reverse(this.hand);
		
	}
	
	public void GetPokerHand(PlayersList playersList,ArrayList<Card> board){
		for(int i = 0; i < playersList.getSizeList(); i++){
			if(playersList.selectPlayer(i).isFold() == false){
				this.hand.addAll(board);
				this.hand.addAll(playersList.selectPlayer(i).getHand());

				ordenateHand();
				
				
				
				if(straightFlush.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(8);
					break;
				}
				
				if(fourOfAKind.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(7);
					break;
				}
				
				if(fullHouse.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(6);
					break;
				}
				
				if(flush.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(5);
					break;
				}
				
				if(straight.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(4);
					break;
				}
				
				if(threeOfAKind.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(3);
					break;
				}
				
				if(twoPair.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(2);
					break;
				}
				
				if(onePair.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(1);
					break;
				}
				
				if(highCard.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(0);
					break;
				}
								
				
			}
			
			this.hand.clear();
			
		}
	}
	
	
	
}
