package pt.iscte.es.grupo4.scrumgest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Action;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.Label;
import com.julienvey.trello.domain.TList;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;

public class My_Board {
	Trello trelloApi;
	HashMap<TList, Card> sprintAndCards; // unkown
	List<Card> cards = new ArrayList<Card>();
	List<TList> sprint = new ArrayList<TList>();// not used yet
	List<Card> sprintCards;// not used yet

	double sprint1TotalWorkHours = 0;
	double sprint2TotalWorkHours = 0;
	double sprint3TotalWorkHours = 0;
	double sprint1TotalCost = 0;
	double sprint2TotalCost = 0;
	double sprint3totalCost = 0;
	
	

	public double getSprint1TotalCost() {
		return sprint1TotalCost;
	}

	public void setSprint1TotalCost(double sprint1TotalCost) {
		this.sprint1TotalCost = sprint1TotalCost;
	}

	public double getSprint2TotalCost() {
		return sprint2TotalCost;
	}

	public void setSprint2TotalCost(double sprint2TotalCost) {
		this.sprint2TotalCost = sprint2TotalCost;
	}

	public double getSprint3totalCost() {
		return sprint3totalCost;
	}

	public void setSprint3totalCost(double sprint3totalCost) {
		this.sprint3totalCost = sprint3totalCost;
	}

	public My_Board(List<Card> cards) {
		this.cards = cards;
	}

	public double getSprint1TotalWorkHours() {
		return sprint1TotalWorkHours;
	}

	public double getSprint2TotalWorkHours() {
		return sprint2TotalWorkHours;
	}

	public double getSprint3TotalWorkHours() {
		return sprint3TotalWorkHours;
	}

	public void setSprint1TotalWorkHours(double sprint1TotalWorkHours) {
		this.sprint1TotalWorkHours = sprint1TotalWorkHours;
	}

	public void setSprint2TotalWorkHours(double sprint2TotalWorkHours) {
		this.sprint2TotalWorkHours = sprint2TotalWorkHours;
	}

	public void setSprint3TotalWorkHours(double sprint3TotalWorkHours) {
		this.sprint3TotalWorkHours = sprint3TotalWorkHours;
	}
//
//	public void TrelloConnect() {
//		trelloApi = new TrelloImpl("d9a050a2b06b9d83d847f5145d5c9a01",
//				"92b59d9c284cecc282dbbc981c376919b95eac07e8a53cb2ae13926f371c0aa8", new ApacheHttpClient());
//	}

	public void TrelloContents() {// get all the boards for the member listed and add all cards to the Arraylist
									// named cards
		List<Board> member = trelloApi.getMemberBoards("saragiraopereirafernandesdafonseca");
		for (Board quadro : member) {
			cards = quadro.fetchCards();
		}

	}

	// need to verify issue with some inputs from the activities
	// Verified that the COMMENT OWNER can HAMMER it to only keep the format plus!
	// X/Y (will probably need that)
	public double caltulateTotalWorkingHoursPerSprint(String StringID) {
		double totalhours = 0;
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals(StringID))
					for (Action comment : card.getActions()) {
						String card_coment = comment.getData().getText();
						if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
							String[] parts = card_coment.substring(6).split("/");
							totalhours += Double.parseDouble(parts[0]);
						}
					}
			}
		}
		return totalhours;
	}

	public void calculateAllWorkingHours() {
		setSprint1TotalWorkHours(caltulateTotalWorkingHoursPerSprint("SPRINT1"));
		setSprint2TotalWorkHours(caltulateTotalWorkingHoursPerSprint("SPRINT2"));
		setSprint3TotalWorkHours(caltulateTotalWorkingHoursPerSprint("SPRINT3"));

	}
	
	public double calculateTotalCostPerSprint(String StringID) {
		return caltulateTotalWorkingHoursPerSprint(StringID)*20;
	}
	
	public void calculateCostTotal() {
		calculateAllWorkingHours();
		setSprint1TotalCost(sprint1TotalWorkHours*20);
		setSprint2TotalCost(sprint2TotalWorkHours*20);
		setSprint3totalCost(sprint3TotalWorkHours*20);
		
	}
//
//	public static void main(String[] args) throws InterruptedException {
//		My_Board test_board = new My_Board();
//		test_board.TrelloConnect();
//		test_board.TrelloContents();
//		test_board.calculateAllWorkingHours();
//		Thread.sleep(2000);
//		System.out.println(test_board.sprint1TotalWorkHours);
//		System.out.println(test_board.sprint2TotalWorkHours);
//		System.out.println(test_board.sprint3TotalWorkHours);
//	}
}
