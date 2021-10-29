package pt.iscte.es.grupo4.scrumgest.trello;

public class BoardCard {

	public final String id;
	public final String title;
	public final String description;

	public BoardCard(final String id, final String title, final String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	@Override
	public String toString() {
		return "BoardCard [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
}
