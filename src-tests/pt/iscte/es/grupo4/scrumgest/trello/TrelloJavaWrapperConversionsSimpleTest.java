package pt.iscte.es.grupo4.scrumgest.trello;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class TrelloJavaWrapperConversionsSimpleTest {

	@Test
	void test() {
		final String trelloKey = System.getProperty("trello-key");
		final String trelloAccessToken = System.getProperty("trello-access-token");

		final Supplier<TrelloAPI> defaultTrelloAPISupplier = new DefaultTrelloAPISupplier(trelloKey, trelloAccessToken);
		final TrelloAPI trelloApi = defaultTrelloAPISupplier.get();
		
		final Board board = trelloApi.getBoard("uZFHCkJo");
		for (final BoardList boardList : board.lists) {
			for (final BoardCard boardCard : boardList.cards) {
				System.out.println(boardCard);				
			}
		}
	}

}
