package generateCommand;

import java.util.ArrayList;
import java.util.Scanner;

import game.Poker;
import player.PlayersList;
/**
 * The command pattern: Classe de comando responsável de gerar os jogadores{@link player.PlayersList#generatePlayers(ArrayList, int)}.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class GeneratePlayers implements GenerateCommand {

	private PlayersList playerList;
	private ArrayList<String> playersNames;
	private int initChips; //Valor inicial que cada jogador começará em fichas.
	private Scanner reader = new Scanner(System.in);
	private String input;
	private double dInitChips;

	/**
	 * 
	 * @param playersList Objeto da classe PlayerList contendo lista de jogadares {@link player.PlayersList}
	 * @param playersNames Nome dos jogadores
	 */
	public GeneratePlayers(PlayersList playerList, ArrayList<String> playersNames) {
		this.playerList = playerList;
		this.playersNames = playersNames;
		System.out.print(
				"Insira o total de fichas que cada jogador comecara(1000 to 10000): Caso seja double, sera arrendondado: ");
		while (true) {
			this.input = reader.next();
			if (Poker.isNumeric(this.input) == true) {
				this.dInitChips = Double.parseDouble(this.input);
				Math.round(this.dInitChips);
				this.initChips = (int) Math.round(this.dInitChips);
				if (this.initChips < 1000 || this.initChips > 10000)
					System.out.println("Numero fora do valor limitado");
				else
					break;
			} else {
				System.out.println("Nao e um numero, coloque outro valor");
			}
		}
		

	}

	@Override
	public void execute() {
		this.playerList.generatePlayers(this.playersNames, this.initChips);

	}

}
