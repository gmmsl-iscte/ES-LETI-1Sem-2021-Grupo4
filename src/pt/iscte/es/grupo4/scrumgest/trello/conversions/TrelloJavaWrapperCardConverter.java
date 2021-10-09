package pt.iscte.es.grupo4.scrumgest.trello.conversions;

import java.util.function.Function;

import com.julienvey.trello.domain.Card;

import pt.iscte.es.grupo4.scrumgest.trello.BoardCard;

public class TrelloJavaWrapperCardConverter implements Function<Card, BoardCard> {

	@Override
	public BoardCard apply(final Card trelloJavaWrapperCard) {
		final String cardId = trelloJavaWrapperCard.getId();
		final String cardTitle = trelloJavaWrapperCard.getName();
		final String cardDescription = trelloJavaWrapperCard.getDesc();
		
		return new BoardCard(cardId, cardTitle, cardDescription);
	}

}
