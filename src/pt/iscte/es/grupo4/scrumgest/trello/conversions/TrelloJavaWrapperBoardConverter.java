package pt.iscte.es.grupo4.scrumgest.trello.conversions;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.julienvey.trello.domain.TList;

import pt.iscte.es.grupo4.scrumgest.trello.Board;
import pt.iscte.es.grupo4.scrumgest.trello.BoardList;

public class TrelloJavaWrapperBoardConverter implements Function<com.julienvey.trello.domain.Board, Board> {

	private final Function<? super TList, ? extends BoardList> boardListConverter;
	
	public TrelloJavaWrapperBoardConverter(Function<? super TList, ? extends BoardList> boardListConverter) {
		super();
		this.boardListConverter = boardListConverter;
	}


	@Override
	public Board apply(final com.julienvey.trello.domain.Board trelloJavaWrapperBoard) {
		
		final String boardId = trelloJavaWrapperBoard.getId();
		final String boardName = trelloJavaWrapperBoard.getName();
		
		final Iterable<BoardList> boardLists = trelloJavaWrapperBoard.getLists().stream().map(boardListConverter).collect(Collectors.toList());
		
		return new Board(boardId, boardName, boardLists);
	}

}
