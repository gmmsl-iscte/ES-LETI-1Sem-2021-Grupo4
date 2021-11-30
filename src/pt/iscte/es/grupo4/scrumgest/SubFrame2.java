package pt.iscte.es.grupo4.scrumgest;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.julienvey.trello.domain.Action;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.Label;
import com.julienvey.trello.domain.Member;
import com.julienvey.trello.domain.Membership;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class SubFrame2 extends JFrame {
	private List<Card> cards;
	private List<Card> ArtifactCards;
	private List<Card> ActivitiesCard;
	private Map<String, List<Card>> memberCards;

	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_4 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private JPanel panel_6 = new JPanel();
	private JPanel panel_7 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Activities which gave rise to artifacts");
	private final JLabel lblNewLabel_1 = new JLabel("Activities which did not gave origin to artifacts");
	private final JLabel lblNewLabel_2 = new JLabel("For each team member");
	private final JLabel lblNewLabel_3 = new JLabel("For the project as a whole");
	private final JLabel lblNewLabel_4 = new JLabel("For each team member");
	private final JLabel lblNewLabel_5 = new JLabel("For the project as a whole");
	private JList<String> list = new JList<String>();
	private JList<String> list_1 = new JList<String>();
	private JList<String> list_2 = new JList<String>();
	private JList<String> list_3 = new JList<String>();
	private DefaultListModel<String> model;
	private DefaultListModel<String> model1;
	private DefaultListModel<String> model2;
	private DefaultListModel<String> model3;

	/**
	 * Create the frame.
	 */
	public SubFrame2(List<Card> cards, Map<String, List<Card>> memberCards2) {
		this.cards = cards;
		this.memberCards = memberCards2;

		model = new DefaultListModel<String>();
		model1 = new DefaultListModel<String>();
		model2 = new DefaultListModel<String>();
		model3 = new DefaultListModel<String>();
		listUpdate();
		ActivitiesByMembers1();
		ActivitiesByMembers2();
		setTitle("Trello Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 782, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		panel.add(lblNewLabel, BorderLayout.NORTH);

		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));

		panel_4.add(lblNewLabel_2, BorderLayout.NORTH);

		panel_4.add(list, BorderLayout.CENTER);
		list.setModel(model);

		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		panel_5.add(lblNewLabel_3, BorderLayout.NORTH);

		panel_5.add(list_1, BorderLayout.CENTER);
		list_1.setModel(model1);

		panel_1.add(lblNewLabel_1, BorderLayout.NORTH);

		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		panel_3.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));

		panel_6.add(lblNewLabel_4, BorderLayout.NORTH);

		panel_6.add(list_2, BorderLayout.CENTER);
		list_2.setModel(model2);

		panel_3.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));

		panel_7.add(lblNewLabel_5, BorderLayout.NORTH);

		panel_7.add(list_3, BorderLayout.CENTER);
		list_3.setModel(model3);

	}

	public void ActivitiesByMembers1() {
		int numArtifacts;
		double totalhours;

		for (Map.Entry<String, List<Card>> set : memberCards.entrySet()) {
			numArtifacts = 0;
			totalhours = 0;
			for (Card card : set.getValue()) {
				List<Label> labels = card.getLabels();
				for (Label label : labels) {
					if (label.getName().equals("Artifact")) {
						numArtifacts++;
						for (Action comment : card.getActions()) {
							String card_coment = comment.getData().getText();
							if ((card_coment != null) && card_coment.startsWith("plus!")
									&& !card_coment.contains("@")) {
								String[] parts = card_coment.substring(6).split("/");
								totalhours += Double.parseDouble(parts[0]);

							}
						}
					}
				}
			}
			model.addElement("Member: " + set.getKey() + " Activities: " + numArtifacts + " Hours: " + totalhours + "h"
					+ " Cost: " + totalhours * 20 + "$");
		}
	}

	public void ActivitiesByMembers2() {
		int numActivities;
		double totalhours;
		for (Map.Entry<String, List<Card>> set : memberCards.entrySet()) {
			numActivities = 0;
			totalhours = 0;
			for (Card card : set.getValue()) {
				List<Label> labels = card.getLabels();
				for (Label label : labels) {
					if (label.getName().equals("No Artifact")) {
						numActivities++;
						for (Action comment : card.getActions()) {
							String card_coment = comment.getData().getText();
							if ((card_coment != null) && card_coment.startsWith("plus!")
									&& !card_coment.contains("@")) {
								String[] parts = card_coment.substring(6).split("/");
								totalhours += Double.parseDouble(parts[0]);

							}
						}
					}
				}
			}
			model2.addElement("Member: " + set.getKey() + " Activities: " + numActivities + " Hours: " + totalhours
					+ "h" + " Cost: " + totalhours * 20 + "$");
		}
	}

	public int ActivitiesTotal1() {
		ArtifactCards = new ArrayList<Card>();
		int numArtifacts = 0;
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("Artifact")) {
					numArtifacts++;
					ArtifactCards.add(card);
				}
			}
		}
		return numArtifacts;
	}

	public int ActivitiesTotal2() {
		ActivitiesCard = new ArrayList<Card>();
		int numActivities = 0;
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("No Artifact")) {
					numActivities++;
					ActivitiesCard.add(card);
				}
			}
		}
		return numActivities;
	}

	public double HoursTotal1() {
		double totalhours = 0;
		for (Card card : ArtifactCards) {
			for (Action comment : card.getActions()) {
				String card_coment = comment.getData().getText();
				if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
					String[] parts = card_coment.substring(6).split("/");
					totalhours += Double.parseDouble(parts[0]);

				}
			}
		}
		return totalhours;
	}

	public double HoursTotal2() {
		double totalhours = 0;
		for (Card card : ActivitiesCard) {
			for (Action comment : card.getActions()) {
				String card_coment = comment.getData().getText();
				if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
					String[] parts = card_coment.substring(6).split("/");
					totalhours += Double.parseDouble(parts[0]);

				}
			}
		}
		return totalhours;
	}

	public double costTotal1() {
		return HoursTotal1() * 20;
	}

	public double costTotal2() {
		return HoursTotal2() * 20;
	}

	public void listUpdate() {
		model1.addElement("Activities: " + ActivitiesTotal1() + " Hours: " + HoursTotal1() + "h" + " Cost: "
				+ costTotal1() + "$");
		model3.addElement("Activities: " + ActivitiesTotal2() + " Hours: " + HoursTotal2() + "h" + " Cost: "
				+ costTotal2() + "$");
	}
}
