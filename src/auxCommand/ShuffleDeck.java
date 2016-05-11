package auxCommand;

import deck.Deck;

/**
 * The command pattern: Comando que irá embaralhar as cartas.
 * @author Felie Glicério Gomes Marcelino
 *
 */

public class ShuffleDeck implements AuxCommand {
	private Deck deck;

	/**
	 * 
	 * @param deck Objeto contendo uma composição de objetos cartas{@link deck.Deck}
	 */
	public ShuffleDeck(Deck deck) {
		this.deck = deck;
	}

	@Override
	public void execute() {
		this.deck.shuffleDeck();
	}

}
