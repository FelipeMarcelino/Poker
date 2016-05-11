package auxCommand;

import game.InfoRound;
import gameCommand.AllIn;
import gameCommand.Bet;
import gameCommand.Call;
import gameCommand.Check;
import gameCommand.Fold;
import player.PlayersList;

/**
 * The command pattern: Commando que irá mostrar para cada jogador
 * qual são suas opções de comando.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class ShowAvaliableCommands implements AuxCommand {

	private InfoRound infoRound;
	private PlayersList playersList;
	private ShowHandPlayer showHandPlayer;
	private Check check;
	private Bet bet;
	private Fold fold;
	private AllIn allIn;
	private Call call;
	
	 
	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param infoRound Objeto da classe InfoRound que guarda informações de cada rodada{@link game.InfoRound}
	 * @param showHandPlayer Objeto da classe ShowHandPlayer que irá fornecer as cartas que cada usuário tem{@link auxCommand.ShowHandPlayer}
	 * @param bet Objeto da classe ShowHandPlayer que irá executar o comando "Bet"{@link gameCommand.Bet}
	 * @param call Objeto da classe ShowHandPlayer que irá executar o comando "Check"{@link gameCommand.Check}
	 * @param fold Objeto da classe ShowHandPlayer que irá executar o comando "Fold"{@link gameCommand.Fold}
	 * @param check Objeto da classe ShowHandPlayer que irá executar o comando "Check"{@link gameCommand.Check}
	 * @param allIn Objeto da classe ShowHandPlayer que irá executar o comando "AllIn'{@link gameCommand.AllIn}
	 */
	public ShowAvaliableCommands(PlayersList playersList, InfoRound infoRound, ShowHandPlayer showHandPlayer, Bet bet,
			Call call, Fold fold, Check check, AllIn allIn) {
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
		this.infoRound.showAvaliableCommands(this.playersList, this.showHandPlayer, this.check, this.bet, this.allIn,
				this.call, this.fold);

	}

}
