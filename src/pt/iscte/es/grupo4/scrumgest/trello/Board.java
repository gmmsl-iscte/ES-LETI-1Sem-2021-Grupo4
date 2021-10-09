package pt.iscte.es.grupo4.scrumgest.trello;

public class Board {

	public final String id;
	public final String name;
	public final Iterable<? extends BoardList> lists;

	public Board(final String id, final String name, final Iterable<? extends BoardList> lists) {
		this.id = id;
		this.name = name;
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", lists=" + lists + "]";
	}
	
}
