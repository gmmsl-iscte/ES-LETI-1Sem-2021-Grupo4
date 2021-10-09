package pt.iscte.es.grupo4.scrumgest.trello;

public class BoardList {

	public final String id;
	public final String name;
	public final Iterable<? extends BoardCard> cards;

	public BoardList(final String id, final String name, final Iterable<? extends BoardCard> cards) {
		this.id = id;
		this.name = name;
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "BoardList [id=" + id + ", name=" + name + ", cards=" + cards + "]";
	}
	
}
