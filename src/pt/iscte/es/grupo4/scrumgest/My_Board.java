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
	List<Card> cards = new ArrayList<Card>();

	final int COSTPERHOUR = 20;
	double sprint1TotalWorkHours = 0;
	double sprint2TotalWorkHours = 0;
	double sprint3TotalWorkHours = 0;
	double sprint1PlannedWorkHours = 0;
	double sprint2PlannedWorkHours = 0;
	double sprint3PlannedWorkHours = 0;
	double sprint1TotalCost = 0;
	double sprint2TotalCost = 0;
	double sprint3TotalCost = 0;

//	public My_Board(List<Card> cards) {
//		this.cards = cards;
//	}

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
		return sprint3TotalCost;
	}

	public void setSprint3totalCost(double sprint3totalCost) {
		this.sprint3TotalCost = sprint3totalCost;
	}

	public double getSprint1PlannedWorkHours() {
		return sprint1PlannedWorkHours;
	}

	public void setSprint1PlannedWorkHours(double sprint1PlannedWorkHours) {
		this.sprint1PlannedWorkHours = sprint1PlannedWorkHours;
	}

	public double getSprint2PlannedWorkHours() {
		return sprint2PlannedWorkHours;
	}

	public void setSprint2PlannedWorkHours(double sprint2PlannedWorkHours) {
		this.sprint2PlannedWorkHours = sprint2PlannedWorkHours;
	}

	public double getSprint3PlannedWorkHours() {
		return sprint3PlannedWorkHours;
	}

	public void setSprint3PlannedWorkHours(double sprint3PlannedWorkHours) {
		this.sprint3PlannedWorkHours = sprint3PlannedWorkHours;
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

	@SuppressWarnings("deprecation")
	public void ConnectToTrello() {

		trelloApi = new TrelloImpl("d9a050a2b06b9d83d847f5145d5c9a01",
				"92b59d9c284cecc282dbbc981c376919b95eac07e8a53cb2ae13926f371c0aa8");

	}

	public void loadCardsFromTrello() {
		cards = trelloApi.getBoardCards("uZFHCkJo");
	}

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

	public double caltulatePlannedHoursPerSprint(String StringID) {
		double plannedhours = 0;
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals(StringID))
					for (Action comment : card.getActions()) {
						String card_coment = comment.getData().getText();
						if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
							String[] parts = card_coment.substring(6).split("/");
							plannedhours += Double.parseDouble(parts[1]);
						}
					}
			}
		}
		return plannedhours;
	}

	public void calculateAllHours() {
		setSprint1TotalWorkHours(caltulateTotalWorkingHoursPerSprint("SPRINT1"));
		setSprint2TotalWorkHours(caltulateTotalWorkingHoursPerSprint("SPRINT2"));
		setSprint3TotalWorkHours(caltulateTotalWorkingHoursPerSprint("SPRINT3"));

		setSprint1PlannedWorkHours(caltulatePlannedHoursPerSprint("SPRINT1"));
		setSprint2PlannedWorkHours(caltulatePlannedHoursPerSprint("SPRINT2"));
		setSprint3PlannedWorkHours(caltulatePlannedHoursPerSprint("SPRINT3"));

	}

	public double calculateTotalCostPerSprint(String StringID) {
		return caltulateTotalWorkingHoursPerSprint(StringID) * COSTPERHOUR;
	}

	public void calculateEachSprintCost() {
		setSprint1TotalCost(sprint1TotalWorkHours * COSTPERHOUR);
		setSprint2TotalCost(sprint2TotalWorkHours * COSTPERHOUR);
		setSprint3totalCost(sprint3TotalWorkHours * COSTPERHOUR);

	}

	public void loadAllTheInformation() {
		ConnectToTrello();
		loadCardsFromTrello();
		calculateAllHours();
		calculateEachSprintCost();
	}
}

// Used for class testing
//	public static void main(String[] args) throws InterruptedException {
//		My_Board test_board = new My_Board();
//	
//		test_board.loadAllTheInformation();
//		Thread.sleep(2000);
//		System.out.println("Each Sprint worked hours");
//		System.out.println(test_board.sprint1TotalWorkHours);
//		System.out.println(test_board.sprint2TotalWorkHours);
//		System.out.println(test_board.sprint3TotalWorkHours);
//		
//		System.out.println("Each Sprint Planed hours");
//		System.out.println(test_board.sprint1PlannedWorkHours);
//		System.out.println(test_board.sprint2PlannedWorkHours);
//		System.out.println(test_board.sprint3PlannedWorkHours);
//		
//		System.out.println("Each Sprint Cost");
//		System.out.println(test_board.sprint1TotalCost);
//		System.out.println(test_board.sprint2TotalCost);
//		System.out.println(test_board.sprint3TotalCost);
//		
//	}
//}
