package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import auxCommand.ShowHandPlayer;
import deck.Card;
import gameCommand.AllIn;
import gameCommand.Bet;
import gameCommand.Call;
import gameCommand.Check;
import gameCommand.Fold;
import player.PlayersList;

/**
 * Classe InfoRound: Responsável por guardar todas informações 
 * de cada rodada do Jogo. Como por exemplo, valor mínimo {@link #minimumBet},
 * qual é o turno{@link #turn} atual da rodada e o total de apostas na rodada {@link #totalRoundBet}.
 * 
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class InfoRound {

	private int minimumBet;
	private int whoWinsGame;
	private int playersInTurn;
	private int playersInGame;
	private int option;
	private int turn;
	private int totalRoundBet;
	private int indexShowBoardCard = 3;
	private static int currentPlayer = 0;
	private boolean nextTurn;
	private boolean[] avaliableOptions = new boolean[5];
	private String input;
	private Scanner reader = new Scanner(System.in);

	/**
	 * Retorna a menor aposta possível.
	 * @return
	 */
	public int getMinimumBet() {
		return this.minimumBet;
	}

	/**
	 * Seta a menor aposta possíveçl
	 * @param minimumBet
	 */
	public void setMinimumBet(int minimumBet) {
		this.minimumBet = minimumBet;
	}

	/**
	 * @return Se <code> true </code> está pronto para o próximo turno
	 * caso contrário , permanece no turno.
	 */
	public boolean isNextTurn() {
		return this.nextTurn;
	}

	/**
	 * Seta {@link #nextTurn}
	 * @param nextTurn <code> True </code> ou <code> False</code>
	 */
	public void setNextTurn(boolean nextTurn) {
		this.nextTurn = nextTurn;
	}

	/**
	 * Seta {@link #totalRoundBet}
	 * @param totalRoundBet Total de apostas no round.
	 */
	public void setTotalBet(int totalRoundBet) {
		this.totalRoundBet = totalRoundBet;
	}

	/**
	 * Retorna {@link #totalRoundBet}
	 * @return Total de apostas feita no round.
	 */
	public int getTotalBet() {
		return this.totalRoundBet;
	}

	/**
	 * Retorna {@link #playersInTurn}
	 * @return Retorna o total de jogadores no turno.
	 */
	public int getPlayersInTurn() {
		return this.playersInTurn;
	}

	
	public void setPlayersInTurn() {
		this.playersInTurn = 0;
	}

	/**
	 * Seta {@link #playersInGame}
	 * @param playersInGame Seta o total de jogadores no game
	 */
	public void setPlayersInGame(int playersInGame) {
		this.playersInGame = playersInGame;

	}

	/**
	 * Retorna {@link #playersInGame}
	 * @return O total de jogadores no turno.
	 */
	public int getPlayersInGame() {
		return this.playersInGame;
	}

	
	public void sumPlayersInTurn() {
		this.playersInTurn += 1;
	}

	/**
	 * Seta {@link #whoWinsGame}
	 * @param whoWins Recebe quem foi o vencedor do game.
	 */
	public void setWhoWins(int whoWins) {
		this.whoWinsGame = whoWins;

	}

	/**
	 * Retorna {@link #whoWinsGame}
	 * @return Retorna quem ganhou o game.
	 */
	public int getWhoWins() {
		return this.whoWinsGame;
	}

	/**
	 * Seta {@link #turn}
	 * @param turn Estabelece em qual turno a rodada está.
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/**
	 * Imprime na tela quais são as cartas da mesa.
	 * @param board Recebe as cartas da mesa.
	 */
	public void showBoardCard(ArrayList<Card> board) {
		if (this.turn == 1)
			this.indexShowBoardCard = 3;
		if (this.turn == 2)
			this.indexShowBoardCard = 4;
		if (this.turn == 3)
			this.indexShowBoardCard = 5;

		for (int i = 0; i < this.indexShowBoardCard; i++) {
			System.out.println(Poker.ranks[board.get(i).getRank()] + " of " + Poker.suits[board.get(i).getSuit()]);
		}

	}

	/**
	 * Mostra para o jogador quais são as opções que ele tem disponível naquela jogada.
	 * @param playersList Lista de jogadores
	 * @param showHandPlayer Comando para exibir a mão do jogador.
	 * @param check Comando check.
	 * @param bet Comando bet.
	 * @param allIn Comandl allIn.
	 * @param call Comando Call.
	 * @param fold Comando fold.
	 */
	public void showAvaliableCommands(PlayersList playersList, ShowHandPlayer showHandPlayer, Check check, Bet bet,
			AllIn allIn, Call call, Fold fold) {
		System.out.print("Player: " + playersList.selectPlayer(currentPlayer).getName());
		System.out.println("->(Fichas disponiveis: " + playersList.selectPlayer(currentPlayer).getChips() + ")");
		System.out.println("Fichas apostadas nesse turno: " + playersList.selectPlayer(currentPlayer).getTotalBet());
		System.out.println("Aposta minima: " + this.minimumBet);
		showHandPlayer.execute();

		Arrays.fill(this.avaliableOptions, Boolean.FALSE);
		// Check avaliable
		if (playersList.selectPlayer(currentPlayer).isCheck() == false) {
			this.avaliableOptions[0] = true;
		} else {
			if (playersList.selectPlayer(currentPlayer).isAllIn() == true)
				this.avaliableOptions[0] = true;
		}
		// Call avaliable
		if (playersList.selectPlayer(currentPlayer)
				.getChips() >= (this.minimumBet - playersList.selectPlayer(currentPlayer).getTotalBet())) {
			this.avaliableOptions[1] = true;
			if (playersList.selectPlayer(currentPlayer).getTotalBet() == this.minimumBet)
				this.avaliableOptions[1] = false;
			if (playersList.selectPlayer(currentPlayer)
					.getChips() == (this.minimumBet - playersList.selectPlayer(currentPlayer).getTotalBet()))
				this.avaliableOptions[1] = false;
		}

		// Bet avaliable
		if (playersList.selectPlayer(currentPlayer)
				.getChips() >= (this.minimumBet - playersList.selectPlayer(currentPlayer).getTotalBet())) {
			this.avaliableOptions[2] = true;
			if (playersList.selectPlayer(currentPlayer).isAllIn() == true)
				this.avaliableOptions[2] = false;
			if (playersList.selectPlayer(currentPlayer)
					.getChips() == (this.minimumBet - playersList.selectPlayer(currentPlayer).getTotalBet()))
				this.avaliableOptions[2] = false;
		}

		// All in avaliable
		if (playersList.selectPlayer(currentPlayer).isAllIn() == false) {
			this.avaliableOptions[3] = true;
		}

		// Fold avaliable
		this.avaliableOptions[4] = true;

		System.out.println("\nOpcoes que podem ser escolhidas:");
		if (this.avaliableOptions[0] == true)
			System.out.print("Check(0)-");
		if (this.avaliableOptions[1] == true)
			System.out.print("Call(1)-");
		if (this.avaliableOptions[2] == true)
			System.out.print("Bet(2)-");
		if (this.avaliableOptions[3] == true)
			System.out.print("AllIn(3)-");
		if (this.avaliableOptions[4] == true)
			System.out.println("Fold(4)");

		while (true) {
			while (true) {
				this.input = this.reader.next();
				if (Poker.isNumeric(this.input) == true)
					break;
				else {
					System.out.println("Nao e um numero, escolha outro valor");
				}
			}

			this.option = Integer.parseInt(this.input);

			if (this.option > 4 || this.option < 0)
				System.out.println("Opcao fora do escopo aceitavel");
			else {
				if (this.avaliableOptions[this.option] != true)
					System.out.println("Opcao nao disponivel");
				else
					break;
			}

		}

		if (this.option == 0)
			check.execute();
		else if (this.option == 1)
			call.execute();
		else if (this.option == 2)
			bet.execute();
		else if (this.option == 3)
			allIn.execute();
		else if (this.option == 4)
			fold.execute();
		
		System.out.println("---------------------------\n");

	}

}
