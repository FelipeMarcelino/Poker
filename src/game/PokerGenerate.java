package game;

import java.util.Scanner;

import generateCommand.GenerateDeck;
import generateCommand.GeneratePlayers;

public class PokerGenerate extends Poker {

	private int totalPlayers;
	private String name;
	private Scanner reader = new Scanner(System.in);
	
	public void generate() {

		System.out.print("Escolha o total de jogadores(2 to 10): ");
		this.totalPlayers = reader.nextInt();

		while (this.totalPlayers < 2 || this.totalPlayers > 10) {
			System.out.print("Numero de jogadores fora do limite, entre com um novo numero(2 to 10): ");
			this.totalPlayers = reader.nextInt();
		}

		System.out.println("Insira o nome dos jogadores(Min = 1, Max = 20)");

		for (int i = 0; i < this.totalPlayers; i++) {
			while (true) {
				this.name = reader.next();
				if (this.name.length() >= 1 && this.name.length() <= 20)
					break;
				else
					System.out.println("Nome fora dos padrões(Min = 1, Max = 20)");
			}

			playersNames.add(this.name);
		}

		generatePlayers.execute();
		generateDeck.execute();

	}

}

