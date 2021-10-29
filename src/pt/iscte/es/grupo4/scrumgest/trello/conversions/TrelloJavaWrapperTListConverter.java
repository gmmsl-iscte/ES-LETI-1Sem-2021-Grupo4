package pt.iscte.es.grupo4.scrumgest.trello.conversions;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.TList;

import pt.iscte.es.grupo4.scrumgest.trello.BoardCard;
import pt.iscte.es.grupo4.scrumgest.trello.BoardList;

public class TrelloJavaWrapperTListConverter implements Function<TList, BoardList> {

	private final Function<? super Card, ? extends BoardCard> cardConverter;
	
	public TrelloJavaWrapperTListConverter(Function<? super Card, ? extends BoardCard> cardConverter) {
		this.cardConverter = cardConverter;
	}

	@Override
	public BoardList apply(final TList tList) {
		final String boardListId = tList.getId();
		final String boardListName = tList.getName();
		
		final Iterable<BoardCard> boardListCards = tList.getCards().stream().map(cardConverter).collect(Collectors.toList());
		
		return new BoardList(boardListId, boardListName, boardListCards);
	}

}
