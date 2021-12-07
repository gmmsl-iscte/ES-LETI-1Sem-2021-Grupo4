package pt.iscte.es.grupo4.scrumgest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Action;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.Label;
import com.julienvey.trello.impl.TrelloImpl;

public class My_Board {
	Trello trelloApi;
	List<Card> cards = new ArrayList<Card>();

	final int COSTPERHOUR = 20;

	/** Array structure [Sara,Fabio,Goncalo]* */
	double sprint1WorkAndPlannedHoursByMember[] = { 0, 0, 0, 0, 0, 0 };
	double sprint2WorkAndPlannedHoursByMember[] = { 0, 0, 0, 0, 0, 0 };
	double sprint3WorkAndPlannedHoursByMember[] = { 0, 0, 0, 0, 0, 0 };
	double sprint1TeamCost[] = { 0, 0, 0 };
	double sprint2TeamCost[] = { 0, 0, 0 };
	double sprint3TeamCost[] = { 0, 0, 0 };

//	public My_Board(List<Card> cards) {
//		this.cards = cards;
//	}

	public double[] getsprint1TeamCost() {
		return sprint1TeamCost;
	}

	public void setsprint1TeamCost(double[] sprint1TeamCost) {
		this.sprint1TeamCost = sprint1TeamCost;
	}

	public double[] getsprint2TeamCost() {
		return sprint2TeamCost;
	}

	public void setsprint2TeamCost(double[] sprint2TeamCost) {
		this.sprint2TeamCost = sprint2TeamCost;
	}

	public double[] getsprint3TeamCost() {
		return sprint3TeamCost;
	}

	public void setsprint3TeamCost(double[] sprint3TeamCost) {
		this.sprint3TeamCost = sprint3TeamCost;
	}

	public double[] getsprint1WorkAndPlannedHoursByMember() {
		return sprint1WorkAndPlannedHoursByMember;
	}

	public double[] getsprint2WorkAndPlannedHoursByMember() {
		return sprint2WorkAndPlannedHoursByMember;
	}

	public double[] getsprint3WorkAndPlannedHoursByMember() {
		return sprint3WorkAndPlannedHoursByMember;
	}

	public void setsprint1WorkAndPlannedHoursByMember(double[] sprint1WorkAndPlannedHoursByMember) {
		this.sprint1WorkAndPlannedHoursByMember = sprint1WorkAndPlannedHoursByMember;
	}

	public void setsprint2WorkAndPlannedHoursByMember(double[] sprint2WorkAndPlannedHoursByMember) {
		this.sprint2WorkAndPlannedHoursByMember = sprint2WorkAndPlannedHoursByMember;
	}

	public void setsprint3WorkAndPlannedHoursByMember(double[] sprint3WorkAndPlannedHoursByMember) {
		this.sprint3WorkAndPlannedHoursByMember = sprint3WorkAndPlannedHoursByMember;
	}

	@SuppressWarnings("deprecation")
	public void ConnectToTrello() {

		trelloApi = new TrelloImpl("d9a050a2b06b9d83d847f5145d5c9a01",
				"92b59d9c284cecc282dbbc981c376919b95eac07e8a53cb2ae13926f371c0aa8");

	}

	public void loadCardsFromTrello() {
		cards = trelloApi.getBoardCards("uZFHCkJo");
	}

	public double[] caltulateTotalWorkingAndPlanedHoursPerSprintForEachMember(String StringID) {
		double[] totalhours = { 0, 0, 0, 0, 0, 0 };
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals(StringID))
					for (Action comment : card.getActions()) {

						String card_coment = comment.getData().getText();
						if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
							String[] parts = card_coment.substring(6).split("/");
							if (comment.getMemberCreator().getFullName().startsWith("Sara")) {
								totalhours[0] += Double.parseDouble(parts[0]);
								totalhours[3] += Double.parseDouble(parts[1]);
							}
							if (comment.getMemberCreator().getFullName().startsWith("Fabio")) {
								totalhours[1] += Double.parseDouble(parts[0]);
								totalhours[4] += Double.parseDouble(parts[1]);
							}
							if (comment.getMemberCreator().getFullName().startsWith("Gonçalo")) {
								totalhours[2] += Double.parseDouble(parts[0]);
								totalhours[5] += Double.parseDouble(parts[1]);
							}
						}
					}
			}
		}

//		for (double d : totalhours) {
//			System.out.println(d);
//		}

		return totalhours;
	}

	public void calculateAllHours() {
		setsprint1WorkAndPlannedHoursByMember(caltulateTotalWorkingAndPlanedHoursPerSprintForEachMember("SPRINT1"));
		setsprint2WorkAndPlannedHoursByMember(caltulateTotalWorkingAndPlanedHoursPerSprintForEachMember("SPRINT2"));
		setsprint3WorkAndPlannedHoursByMember(caltulateTotalWorkingAndPlanedHoursPerSprintForEachMember("SPRINT3"));

	}

	public double[] calculateTotalCostPerSprint(double[] sprinthours) {
		double[] sprintcost = { sprinthours[0] * COSTPERHOUR, sprinthours[1] * COSTPERHOUR,
				sprinthours[2] * COSTPERHOUR };
		return sprintcost;
	}

	public void calculateEachSprintCost() {
		setsprint1TeamCost(calculateTotalCostPerSprint(getsprint1WorkAndPlannedHoursByMember()));
		setsprint2TeamCost(calculateTotalCostPerSprint(getsprint2WorkAndPlannedHoursByMember()));
		setsprint3TeamCost(calculateTotalCostPerSprint(getsprint3WorkAndPlannedHoursByMember()));

	}

	public double eachSprintcost(double[] SprintXTotalCost) {
		double spXTotalcost = 0;
		for (double cost : SprintXTotalCost) {
			spXTotalcost += cost;
		}
		return spXTotalcost;

	}

	public void loadAllTheInformation() {
		ConnectToTrello();
		loadCardsFromTrello();
		calculateAllHours();
		calculateEachSprintCost();
	}
	
	
	public void export_to_cvs() throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("C:/Users/facruz/Desktop/exporttest.txt", "UTF-8");
		writer.println("The first line");
		writer.println("The second line");
		writer.close();
	}
//}

// Used for class testing
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, UnsupportedEncodingException {
		My_Board test_board = new My_Board();
		test_board.loadAllTheInformation();
		
		test_board.export_to_cvs();
		
		System.out.println("Sprint1");
		test_board.caltulateTotalWorkingAndPlanedHoursPerSprintForEachMember("SPRINT1");
		System.out.println("Sprint2");
		test_board.caltulateTotalWorkingAndPlanedHoursPerSprintForEachMember("SPRINT2");
		System.out.println("Sprint3");
		test_board.caltulateTotalWorkingAndPlanedHoursPerSprintForEachMember("SPRINT3");
		System.out.println("End of test");
	}
}
