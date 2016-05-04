package pokerCommand;

import game.Poker;
import game.PokerGenerate;

public class PokerGenerateExec implements PokerCommand{
	
	private PokerGenerate pokerGenerate;
	
	public PokerGenerateExec(PokerGenerate pokerGenerate){
		this.pokerGenerate = pokerGenerate;
	}

	@Override
	public void execute() {
		this.pokerGenerate.generate();
	}
	
	

}
