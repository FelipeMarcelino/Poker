package player;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe PlayersList: Classe responsável por guardar a lista des jogadores. E também responsável 
 * por fazer rotação na mesa de poker {@link #rotatePlayersList()} e preparar os jogadores para 
 * o próximo turno {@link #readyForNextTurn(int)}.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class PlayersList {

	private ArrayList<Player> players = new ArrayList<Player>();
	private int totalPlayersInGame;
	private int whoWins;
	private int initChips;

	/**
	 * Construtor da classe
	 * @param playersNames Nome dos jogadores
	 * @param initChips Fichas que cada jogador irá iniciar.
	 */
	public void generatePlayers(ArrayList<String> playersNames, int initChips) {
		for (String name : playersNames) {
			this.players.add(new Player(name, players.size() + 1, initChips));
		}

		this.initChips = initChips;
	}

	/**
	 * Método responsável por fazer rotação na lista.
	 */
	public void rotatePlayersList() {
		Collections.rotate(players, -1);
	}

	public int getInitChips() {
		return this.initChips;
	}

	public int getSizeList() {
		return this.players.size();
	}

	/**
	 *
	 * @param playerIndex Seleciona qual o próximo a jogar
	 * @return Retorna o player que irá jogar.
	 */
	public Player selectPlayer(int playerIndex) {
		return this.players.get(playerIndex);
	}

	/**
	 *
	 * @param betPerPlayer O valor que cada player teve que apostar no turno.
	 * @return Retorna <code> true </code> se o todos os jogadores tiver pronto, ou 
	 * em AllIn.
	 */
	public boolean readyForNextTurn(int betPerPlayer) {
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).isFold() == false) {
				if (this.players.get(i).getTotalBet() != betPerPlayer) {
					if (this.players.get(i).isAllIn() != true)
						return false;
				}
			}
		}

		return true;
	}

	/**
	 * Retorna {@link #totalPlayersInGame}
	 * @return Retorna o total de jogadores no Game
	 */
	public int playersInGame() {

		this.totalPlayersInGame = 0;

		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).inGame() == true)
				this.totalPlayersInGame += 1;
		}

		return this.totalPlayersInGame;

	}

	/**
	 * Retorna {@link #whoWins}
	 * @return Retorna o jogador vencedor.
	 */
	public int getWhoWins() {
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).inGame() == true) {
				this.whoWins = i;
				break;
			}
		}

		return this.whoWins;

	}

	/**
	 * Elimina players com fichas  = 0
	 */
	public void eliminatePlayers() {
		for (int i = 0; i < this.players.size(); i++) {
			if (this.players.get(i).getChips() == 0)
				this.players.get(i).outGame();
		}
	}

}
