package generateCommand;

import deck.Deck;

/**
 * The command pattern: Classe responsável pelo comando de geração do Deck {@link deck.Deck#generateDeck()}.
 * @author Felie Glicério Gomes Marcelino
 *
 */
public class GenerateDeck implements GenerateCommand {
	private Deck deck;

	public GenerateDeck(Deck deck) {
		this.deck = deck;
	}

	@Override
	public void execute() {
		deck.generateDeck();
	}

}
