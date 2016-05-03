package pokerHand;

import java.util.ArrayList;
import java.util.Arrays;
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
	private boolean drawPlyers[];
	private int totalDraws;
	private int whoWins;
	private int indexCompCard;
	
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
					
				}else if(fourOfAKind.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(7);
				
				}else if(fullHouse.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(6);
					
				}
				
				else if(flush.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(5);
				}
				
				else if(straight.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(4);
					
				}
				
				else if(threeOfAKind.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(3);
					
				}
				
				else if(twoPair.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(2);
				
				}
				
				else if(onePair.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(1);
					
				}
				
				else if(highCard.testHand(this.hand, playersList.selectPlayer(i)) == true){
					playersList.selectPlayer(i).setPowerHand(0);
					
				}
								
				
			}
			this.hand.clear();
			
		}
	}
	
	public void comparePokerHand(PlayersList playersList){
		
		this.drawPlyers = new boolean[playersList.getSizeList()];
		Arrays.fill(this.drawPlyers, Boolean.FALSE);
		this.totalDraws = 0;
		this.whoWins = 0;
		this.indexCompCard = 0;
		
		for(int i = 1; i < playersList.getSizeList(); i++){
			if(playersList.selectPlayer(this.whoWins).getPowerHand() == 
					playersList.selectPlayer(i).getPowerHand()){
				this.drawPlyers[this.whoWins] = true;
				this.drawPlyers[i] = true;
				this.totalDraws += 1;
			}else if(playersList.selectPlayer(this.whoWins).getPowerHand() < 
					playersList.selectPlayer(i).getPowerHand()){
				this.whoWins = i;
				this.totalDraws = 0;
				Arrays.fill(this.drawPlyers, Boolean.FALSE);
			}
		}
		
		while(this.totalDraws != 0 && this.indexCompCard < 5){
			this.totalDraws = 0;
			
			for(int i = 1; i < playersList.getSizeList(); i++){
				if(this.drawPlyers[i] == true){
					if(playersList.selectPlayer(this.whoWins).getBestFive().get(this.indexCompCard).getRank() ==
							playersList.selectPlayer(i).getBestFive().get(this.indexCompCard).getRank()){
						
						this.totalDraws += 1;
		
						
					}else if(playersList.selectPlayer(this.whoWins).getBestFive().get(this.indexCompCard).getRank() >
							playersList.selectPlayer(i).getBestFive().get(this.indexCompCard).getRank()){
						
						this.drawPlyers[i] = false;
						
					}else if(playersList.selectPlayer(this.whoWins).getBestFive().get(this.indexCompCard).getRank() <
					playersList.selectPlayer(i).getBestFive().get(this.indexCompCard).getRank()){
						
						this.drawPlyers[this.whoWins] = false;
						this.whoWins = i;
						this.totalDraws = 0;
						
					}
				}
			}
			
			this.indexCompCard += 1;
			
		}
		
		
		if(this.totalDraws == 0){
			System.out.println("Winner: "  + playersList.selectPlayer(this.whoWins).getName());
		}else{
			System.out.println("Winners: ");
			for(int i = 0; i < playersList.getSizeList(); i++){
				if(this.drawPlyers[i] == true){
					System.out.println(playersList.selectPlayer(i).getName());
				}
			}
		}
		
	}
	
	
}