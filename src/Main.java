import game.Poker;
import game.PokerGenerate;
import pokerCommand.PokerGenerateExec;

public class Main {

	public static void main(String[] args) {
		
		PokerGenerate pokerGenerate = new PokerGenerate();
		PokerGenerateExec pokerGenerateExec = new PokerGenerateExec(pokerGenerate);
		
		pokerGenerateExec.execute();
		
		/*
		generateDeck.execute();
		generatePlayers.execute();
		shuffleDeck.execute();
		rotatePlayersList.execute();
		drawCardFromDeck.execute();
		setPokerHand.execute();
		
		
	
		
		
		
		for(int p = 0; p < 5; p++){
			System.out.println(board.get(p).getRank() + " " + board.get(p).getSuit());
		}
		
		for(int i = 0; i < 4; i++){
			System.out.println(i);
			System.out.println(playersList.selectPlayer(i).getPowerHand());
			for(int k = 0; k < 2; k++){
				System.out.println(playersList.selectPlayer(i).getHand().get(k).getRank() + " " + playersList.selectPlayer(i).getHand().get(k).getSuit());
			}
			System.out.println("Melhor mão");
			for(int k = 0; k < playersList.selectPlayer(i).getBestFive().size(); k++){
				System.out.println(playersList.selectPlayer(i).getBestFive().get(k).getRank() + " " + playersList.selectPlayer(i).getBestFive().get(k).getSuit());
			}
			
			System.out.println("\n");
			
		}
		
		
		compareHands.execute();		
		*/
	}

}
