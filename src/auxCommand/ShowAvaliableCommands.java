package auxCommand;

import game.InfoRound;
import gameCommand.AllIn;
import gameCommand.Bet;
import gameCommand.Call;
import gameCommand.Check;
import gameCommand.Fold;
import player.PlayersList;

public class ShowAvaliableCommands implements AuxCommand {
	
	private InfoRound infoRound;
	private PlayersList playersList;
	private ShowHandPlayer showHandPlayer;
	private Check check;
	private Bet bet;
	private Fold fold;
	private AllIn allIn;
	private Call call;
	
	
	
	public ShowAvaliableCommands(PlayersList playersList, InfoRound infoRound, ShowHandPlayer showHandPlayer,Bet bet,Call call,
			Fold fold,Check check, AllIn allIn) {
		this.infoRound = infoRound;
		this.playersList = playersList;
		this.showHandPlayer = showHandPlayer;
		this.fold = fold;
		this.check = check;
		this.bet = bet;
		this.call = call;
		this.allIn = allIn;
	}


	@Override
	public void execute() {
		this.infoRound.showAvaliableCommands(this.playersList,this.showHandPlayer, this.check, this.bet, 
				this.allIn, this.call, this.fold);
		
	}

}
