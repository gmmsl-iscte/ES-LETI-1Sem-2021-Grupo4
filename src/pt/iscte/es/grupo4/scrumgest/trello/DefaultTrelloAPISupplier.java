package pt.iscte.es.grupo4.scrumgest.trello;

import java.util.function.Function;
import java.util.function.Supplier;

import com.julienvey.trello.Trello;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;

import pt.iscte.es.grupo4.scrumgest.trello.conversions.TrelloJavaWrapperBoardConverter;
import pt.iscte.es.grupo4.scrumgest.trello.conversions.TrelloJavaWrapperCardConverter;
import pt.iscte.es.grupo4.scrumgest.trello.conversions.TrelloJavaWrapperTListConverter;

public class DefaultTrelloAPISupplier implements Supplier<TrelloAPI> {

	private final String trelloKey;
	private final String trelloAccessToken;

	public DefaultTrelloAPISupplier(final String trelloKey, final String trelloAccessToken) {
		this.trelloKey = trelloKey;
		this.trelloAccessToken = trelloAccessToken;
	}

	@Override
	public TrelloAPI get() {
		final Trello javaWrapperApiTrello = javaWrapperApiTrello();
		final Function<? super com.julienvey.trello.domain.Board, Board> boardConverterFunction = boardConverterFunction();

		return new TrelloJavaWrapperTrelloAPI(javaWrapperApiTrello, boardConverterFunction);
	}

	private Trello javaWrapperApiTrello() {
		return new TrelloImpl(trelloKey, trelloAccessToken, new ApacheHttpClient());
	}

	private Function<? super com.julienvey.trello.domain.Board, Board> boardConverterFunction() {
		return new TrelloJavaWrapperBoardConverter(
				new TrelloJavaWrapperTListConverter(new TrelloJavaWrapperCardConverter()));
	}

}
