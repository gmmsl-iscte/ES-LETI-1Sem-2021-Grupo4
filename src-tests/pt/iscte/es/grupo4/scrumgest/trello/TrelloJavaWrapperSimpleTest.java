package pt.iscte.es.grupo4.scrumgest.trello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;

public class TrelloJavaWrapperSimpleTest {

	@Test
	void test() {
		final String trelloKey = System.getProperty("trello-key");
		final String trelloAccessToken = System.getProperty("trello-access-token");
		
		final Trello trello = new TrelloImpl(trelloKey, trelloAccessToken, new ApacheHttpClient());

		final Board board = trello.getBoard("uZFHCkJo");
		final String boardName = board.getName();
		
		Assertions.assertEquals("Projecto ES", boardName);
	}
	
}
