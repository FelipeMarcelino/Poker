package pokerCommand;

import game.Poker;

/**
 * The command pattern: Classe de comando responsável por executar o {@link game.Poker#whoWinsGame()}
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class PokerWhoWinsGame implements PokerCommand {
	private Poker poker;

	/**
	 * 
	 * @param poker Instância da classe Poker {@link game.Poker#} responsável por administrar o game.
	 */
	public PokerWhoWinsGame(Poker poker) {
		this.poker = poker;
	}

	@Override
	public void execute() {
		poker.whoWinsGame();

	}
}
