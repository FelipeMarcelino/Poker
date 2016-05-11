package game;

import java.util.Scanner;

import pokerCommand.PokerGenerate;
import pokerCommand.PokerTurns;
import pokerCommand.PokerWhoWinsGame;
/**
 * Classe StartGame: Classe irá inicializar o game ou um restar caso seja desejo dos jogadores.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class StartGame {
	/**
	 * Método que controla-rá toda dinâmica do jogo. Game loop.
	 * @param pokerGenerate Comando para geração de jogadres e carta.
	 * @param pokerTurns Comando para administrar os turnos do jogo.
	 * @param pokerWhoWinsGame Comando para buscar quem foi o ganhador.
	 * @param stopLoopGame Instância responsável por parar o loop quando o jogo acabar.
	 */
	public static void startGame(PokerGenerate pokerGenerate, PokerTurns pokerTurns, PokerWhoWinsGame pokerWhoWinsGame,
			StopLoopGame stopLoopGame) {

		Scanner restart = new Scanner(System.in);
		String strOption = null;
		
		

		while (true) {
			pokerGenerate.execute();

			while (true) {
				pokerTurns.execute();
				pokerTurns.execute();
				pokerTurns.execute();
				pokerTurns.execute();
				if (stopLoopGame.isStopLoopGame() == true)
					break;
			}

			pokerWhoWinsGame.execute();

			System.out.print("Gostaria de jogar novamente?: Digite 'Sim' ou 'Nao' ");
			while (true) {
				strOption = restart.nextLine();
				if(strOption.equalsIgnoreCase("Sim") == true) break;
				if(strOption.equalsIgnoreCase("Nao") == true) break;
			}
			
			if(strOption.equalsIgnoreCase("Nao") == true) break;
			
		}
	}

}
