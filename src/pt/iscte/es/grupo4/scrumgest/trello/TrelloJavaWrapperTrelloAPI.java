package pt.iscte.es.grupo4.scrumgest.trello;

import java.util.function.Function;

import com.julienvey.trello.Trello;

public class TrelloJavaWrapperTrelloAPI implements TrelloAPI {

	private final Trello trello;
	private final Function<? super com.julienvey.trello.domain.Board, Board> boardConverter;

	public TrelloJavaWrapperTrelloAPI(final Trello trello,
			final Function<? super com.julienvey.trello.domain.Board, Board> boardConverter) {
		super();
		this.trello = trello;
		this.boardConverter = boardConverter;
	}

	@Override
	public Board getBoard(final String id) {
		final com.julienvey.trello.domain.Board board = trello.getBoard(id);
		
		// The API wrapper does not fetch these elements automatically
		board.setLists(trello.getBoardLists(board.getId()));
		board.getLists().forEach(list -> list.setCards(trello.getListCards(list.getId())));
		
		return boardConverter.apply(board);
	}

}
