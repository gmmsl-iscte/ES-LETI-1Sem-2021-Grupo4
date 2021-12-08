package pt.iscte.es.grupo4.scrumgest;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.awt.Dimension;
import com.julienvey.trello.domain.*;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * @author sarag
 *
 */
@SuppressWarnings("serial")
public class SubFrame1 extends JFrame {
	String name1;
	String name2;
	String name3;
	double value1;
	double value2;
	double value3;
	String name_1;
	String name_2;
	String name_3;
	double value_1;
	double value_2;
	double value_3;

	double sprint1;
	double sprint2;
	double sprint3;
	double sprint_1;
	double sprint_2;
	double sprint_3;
	String SPRINT1 = "SPRINT1";
	String SPRINT2 = "SPRINT2";
	String SPRINT3 = "SPRINT3";

	List<TList> sprint;
	List<Card> cards;
	private Map<String, List<Card>> memberCards;
	JList<String> list;
	JList<String> list_1;
	DefaultListModel<String> model;
	DefaultListModel<String> model1;
	DefaultListModel<String> model2;
	DefaultListModel<String> model3;
	DefaultListModel<String> model4;
	DefaultListModel<String> model5;
	DefaultListModel<String> model6;
	private JPanel contentPane;
	private JPanel panel_13;
	final int nMembers = 2;
	int costSprint;
	final int nSprints = 3;

	/**
	 * Creates the Sprint data frame.
	 * 
	 * @param cards       refers to a List of cards retrieved from a Trello board
	 * @param memberCards refers to a Map which contains the Trello cards
	 *                    correspondent to each Trello board member
	 */
	public SubFrame1(List<Card> cards, Map<String, List<Card>> memberCards) {
		this.cards = cards;
		this.memberCards = memberCards;
		sprint1 = getPlannedHoursBySprint("SPRINT1");
		sprint2 = getPlannedHoursBySprint("SPRINT2");
		sprint3 = getPlannedHoursBySprint("SPRINT3");
		sprint_1 = getTotalHoursBySprint("SPRINT1");
		sprint_2 = getTotalHoursBySprint("SPRINT2");
		sprint_3 = getTotalHoursBySprint("SPRINT3");
		model = new DefaultListModel<>();
		model1 = new DefaultListModel<String>();
		model2 = new DefaultListModel<String>();
		model3 = new DefaultListModel<String>();
		model4 = new DefaultListModel<String>();
		model5 = new DefaultListModel<String>();
		model6 = new DefaultListModel<String>();

		SprintDuration();

		getHoursByMember();

		setResizable(false);
		setTitle("SPRINT Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 0, 787, 294);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 30));
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Data in each SPRINT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 5, 0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		panel_3.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JTextArea txtrDevelopedProductBacklog = new JTextArea();
		txtrDevelopedProductBacklog.setLineWrap(true);
		txtrDevelopedProductBacklog.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrDevelopedProductBacklog.setRows(2);
		txtrDevelopedProductBacklog.setText("Developed Product Backlog items");
		txtrDevelopedProductBacklog.setWrapStyleWord(true);
		txtrDevelopedProductBacklog.setOpaque(false);
		txtrDevelopedProductBacklog.setFocusable(false);
		txtrDevelopedProductBacklog.setEditable(false);
		panel_6.add(txtrDevelopedProductBacklog, BorderLayout.NORTH);

		list = new JList<String>();
		list.setBorder(null);
		list.setModel(model);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(list);
		panel_6.add(scroll, BorderLayout.CENTER);

		panel_3.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		JTextArea txtrSprintBeginningAnd = new JTextArea();
		txtrSprintBeginningAnd.setText("Select a SPRINT here");
		txtrSprintBeginningAnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrSprintBeginningAnd.setWrapStyleWord(true);
		txtrSprintBeginningAnd.setLineWrap(true);
		txtrSprintBeginningAnd.setOpaque(false);
		txtrSprintBeginningAnd.setFocusable(false);
		txtrSprintBeginningAnd.setEditable(false);
		panel_7.add(txtrSprintBeginningAnd, BorderLayout.NORTH);

		list_1 = new JList<String>();
		list_1.setModel(model1);
		list_1.setBorder(null);
		JScrollPane scroll1 = new JScrollPane();
		scroll1.setViewportView(list_1);
		list_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int key = list_1.getSelectedIndex();
				switch (key) {
				case 0: {
					model.removeAllElements();
					model2.removeAllElements();
					DevelopedProducts();
					MeetingText();
					filterModel(model, "SPRINT 1");
					filterModel(model2, "SPRINT 1");
					break;
				}

				case 1: {
					model.removeAllElements();
					model2.removeAllElements();
					DevelopedProducts();
					MeetingText();
					filterModel(model, "SPRINT 2");
					filterModel(model2, "SPRINT 2");
					break;
				}
				case 2: {
					model.removeAllElements();
					model2.removeAllElements();
					DevelopedProducts();
					MeetingText();
					filterModel(model, "SPRINT 3");
					filterModel(model2, "SPRINT 3");
					break;
				}
				}
			}
		});
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_7.add(scroll1, BorderLayout.CENTER);
		panel_3.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		JTextArea txtrSprintPlanning = new JTextArea();
		txtrSprintPlanning.setText("SPRINT Planning, Review and Retrospective\u2019s resulting text");
		txtrSprintPlanning.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrSprintPlanning.setWrapStyleWord(true);
		txtrSprintPlanning.setOpaque(false);
		txtrSprintPlanning.setFocusable(false);
		txtrSprintPlanning.setLineWrap(true);
		txtrSprintPlanning.setEditable(false);
		panel_8.add(txtrSprintPlanning, BorderLayout.NORTH);

		JScrollPane scroll2 = new JScrollPane();
		panel_8.add(scroll2, BorderLayout.CENTER);

		JList<String> list_2 = new JList<String>();
		list_2.setModel(model2);
		list_2.setBorder(null);
		scroll2.setViewportView(list_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(415, 305, 382, 294);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 30));
		panel_1.add(panel_4, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Global SPRINT data");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		panel_5.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JTextArea txtrTotalHoursOf_1 = new JTextArea();
		txtrTotalHoursOf_1.setWrapStyleWord(true);
		txtrTotalHoursOf_1.setText("Total hours of work performed so far");
		txtrTotalHoursOf_1.setRows(2);
		txtrTotalHoursOf_1.setOpaque(false);
		txtrTotalHoursOf_1.setLineWrap(true);
		txtrTotalHoursOf_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrTotalHoursOf_1.setFocusable(false);
		txtrTotalHoursOf_1.setEditable(false);
		panel_11.add(txtrTotalHoursOf_1, BorderLayout.NORTH);

		panel_13 = new JPanel();
		panel_11.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));

		JList<String> list_5 = new JList<String>();
		list_5.setBorder(null);

		list_5.setModel(model5);
		list_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int key = list_5.getSelectedIndex();
				switch (key) {
				case 0: {
					PieChart demo = new PieChart("Estimate", name_1, value_1, name_2, value_2, name_3, value_3, 0);
					demo.setSize(500, 500);
					demo.setVisible(true);
					demo.setDefaultCloseOperation();
					break;
				}

				case 1: {
					PieChart demo = new PieChart("Performed", name1, value1, name2, value2, name3, value3, 0);
					demo.setSize(500, 500);
					demo.setVisible(true);
					demo.setDefaultCloseOperation();
					break;
				}

				}
			}
		});
		list_5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_13.add(list_5);

		panel_5.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));

		JTextArea txtrHumanResourcesCost = new JTextArea();
		txtrHumanResourcesCost.setWrapStyleWord(true);
		txtrHumanResourcesCost.setText("Human resources cost throughout the project , so far ");
		txtrHumanResourcesCost.setRows(2);
		txtrHumanResourcesCost.setOpaque(false);
		txtrHumanResourcesCost.setLineWrap(true);
		txtrHumanResourcesCost.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrHumanResourcesCost.setFocusable(false);
		txtrHumanResourcesCost.setEditable(false);
		panel_12.add(txtrHumanResourcesCost, BorderLayout.NORTH);

		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));

		JList<String> list_6 = new JList<String>();
		list_6.setBorder(null);
		list_6.setModel(model6);
		model6.addElement("Total cost");

		list_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PieChart demo = new PieChart("Total cost", name1, value1, name2, value2, name3, value3, 1);
				demo.setSize(500, 500);
				demo.setVisible(true);
				demo.setDefaultCloseOperation();

			}
		});
		list_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_14.add(list_6);

		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_17.setBounds(10, 305, 382, 294);
		contentPane.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));

		JPanel panel_2_1 = new JPanel();
		panel_17.add(panel_2_1, BorderLayout.NORTH);
		panel_2_1.setPreferredSize(new Dimension(10, 30));

		JLabel lblNewLabel_2 = new JLabel("Data in each SPRINT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2_1.add(lblNewLabel_2);

		JPanel panel_18 = new JPanel();
		panel_17.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(1, 2, 0, 0));
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_18.add(panel_9);

		panel_9.setLayout(new BorderLayout(0, 0));

		JTextArea txtrTotalHoursOf = new JTextArea();
		txtrTotalHoursOf.setText("Total hours of work planned vs performed");
		txtrTotalHoursOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrTotalHoursOf.setWrapStyleWord(true);
		txtrTotalHoursOf.setOpaque(false);
		txtrTotalHoursOf.setLineWrap(true);
		txtrTotalHoursOf.setFocusable(false);
		txtrTotalHoursOf.setEditable(false);
		panel_9.add(txtrTotalHoursOf, BorderLayout.NORTH);

		JPanel panel_15 = new JPanel();
		panel_9.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new BorderLayout(0, 0));

		JList<String> list_4 = new JList<String>();
		list_4.setBorder(null);
		list_4.setModel(model4);

		model4.addElement("Planned");
		model4.addElement("Performed");
		list_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int key = list_4.getSelectedIndex();
				switch (key) {
				case 0: {

					PieChart demo = new PieChart("Planned", SPRINT1, sprint1, SPRINT2, sprint2, SPRINT3, sprint3, 0);
					demo.setSize(500, 500);
					demo.setVisible(true);
					demo.setDefaultCloseOperation();
					break;
				}
				case 1: {

					PieChart demo = new PieChart("Performed", SPRINT1, sprint_1, SPRINT2, sprint_2, SPRINT3, sprint_3,
							0);
					demo.setSize(500, 500);
					demo.setVisible(true);
					demo.setDefaultCloseOperation();
					break;
				}
				}
			}
		});
		list_4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_15.add(list_4);
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_18.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JTextArea txtrCostOfHuman = new JTextArea();
		txtrCostOfHuman.setText("Human resources cost");
		txtrCostOfHuman.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrCostOfHuman.setLineWrap(true);
		txtrCostOfHuman.setEditable(false);
		txtrCostOfHuman.setOpaque(false);
		txtrCostOfHuman.setFocusable(false);
		txtrCostOfHuman.setWrapStyleWord(true);
		panel_10.add(txtrCostOfHuman, BorderLayout.NORTH);

		JPanel panel_16 = new JPanel();
		panel_10.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));

		JList<String> list_3 = new JList<String>();
		list_3.setBorder(null);
		list_3.setModel(model3);
		model3.addElement("Planned");
		model3.addElement("Performed");
		list_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int key = list_3.getSelectedIndex();
				switch (key) {
				case 0: {

					PieChart demo = new PieChart("Planned", SPRINT1, sprint1, SPRINT2, sprint2, SPRINT3, sprint3, 1);
					demo.setSize(500, 500);
					demo.setVisible(true);
					demo.setDefaultCloseOperation();
					break;
				}
				case 1: {

					PieChart demo = new PieChart("Performed", SPRINT1, sprint_1, SPRINT2, sprint_2, SPRINT3, sprint_3,
							1);
					demo.setSize(500, 500);
					demo.setVisible(true);
					demo.setDefaultCloseOperation();
					break;
				}
				}
			}
		});

		list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_16.add(list_3);

	}

	/**
	 * This method retrieves the developed products from the main list of cards,
	 * organizing them by SPRINT and adding the information to the correspondent
	 * DefaultListModel
	 */
	public void DevelopedProducts() {
		List<Card> devCards = new ArrayList<Card>();

		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("Developed")) {
					devCards.add(card);

				}

			}

		}
		for (Card card2 : devCards) {
			List<Label> devLabels = card2.getLabels();
			for (Label label : devLabels) {
				if (label.getName().equals("SPRINT1"))
					model.addElement("SPRINT 1: " + card2.getName());
				if (label.getName().equals("SPRINT2"))
					model.addElement("SPRINT 2: " + card2.getName());
				if (label.getName().equals("SPRINT3"))
					model.addElement("SPRINT 3: " + card2.getName());
			}
		}
	}

	/**
	 * This method retrieves the text correspondent to the meetings, from the main
	 * list of cards, organizing them by their corresponding SPRINT.
	 */
	public void MeetingText() {
		List<Card> sprint1 = new ArrayList<Card>();
		List<Card> sprint2 = new ArrayList<Card>();
		List<Card> sprint3 = new ArrayList<Card>();

		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("SPRINT1")) {
					sprint1.add(card);

				}

			}

		}
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("SPRINT2")) {
					sprint2.add(card);

				}

			}

		}
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals("SPRINT3")) {
					sprint3.add(card);

				}

			}

		}
		for (Card card2 : sprint1) {
			List<Label> planLabels = card2.getLabels();
			for (Label label : planLabels) {
				if (label.getName().equals("Planning Meeting"))
					model2.addElement("SPRINT 1 Planning: " + card2.getDesc());
				if (label.getName().equals("Review Meeting"))
					model2.addElement("SPRINT 1 Review: " + card2.getDesc());
				if (label.getName().equals("Retrospective Meeting"))
					model2.addElement("SPRINT 1 Retrospective: " + card2.getDesc());
			}
		}
		for (Card card2 : sprint2) {
			List<Label> planLabels = card2.getLabels();
			for (Label label : planLabels) {
				if (label.getName().equals("Planning Meeting"))
					model2.addElement("SPRINT 2 Planning: " + card2.getDesc());
				if (label.getName().equals("Review Meeting"))
					model2.addElement("SPRINT 2 Review: " + card2.getDesc());
				if (label.getName().equals("Retrospective Meeting"))
					model2.addElement("SPRINT 2 Retrospective: " + card2.getDesc());
			}
		}
		for (Card card2 : sprint3) {
			List<Label> planLabels = card2.getLabels();
			for (Label label : planLabels) {
				if (label.getName().equals("Planning Meeting"))
					model2.addElement("SPRINT 3 Planning: " + card2.getDesc());
				if (label.getName().equals("Review Meeting"))
					model2.addElement("SPRINT 3 Review: " + card2.getDesc());
				if (label.getName().equals("Retrospective Meeting"))
					model2.addElement("SPRINT 3 Retrospective: " + card2.getDesc());
			}
		}
	}

	/**
	 * This method retrieves the information regarding the duration of each SPRINT
	 * from the main List of cards, adding the obtained information to a
	 * DefaultListModel.
	 */
	public void SprintDuration() {
		for (Card card : cards) {
			for (int j = 0; j < card.getLabels().size(); j++) {
				String label = card.getLabels().get(j).getName();
				if (card.getName().equals("SPRINT Duration")) {
					if (label.equals("SPRINT1"))
						model1.addElement("SPRINT 1:  " + card.getDesc());
					if (label.equals("SPRINT2"))
						model1.addElement("SPRINT 2:  " + card.getDesc());
					if (label.equals("SPRINT3"))
						model1.addElement("SPRINT 3:  " + card.getDesc());
				}
			}

		}

	}

	/**
	 * This method calculates the hours performed by team member from the main
	 * memberCards Map. After retrieving the necessary values, these are matched to
	 * the variables declared above, so that this information can be used to
	 * generate Pie Charts later.
	 */
	public void getHoursByMember() {
		double totalhours;
		double estimatehours;
		Map<String, Double> hours = new LinkedHashMap<>();
		Map<String, Double> estimate = new LinkedHashMap<>();
		for (Map.Entry<String, List<Card>> set : memberCards.entrySet()) {
			totalhours = 0;
			estimatehours = 0;
			for (Card card : set.getValue()) {
				for (Action comment : card.getActions()) {
					String card_coment = comment.getData().getText();
					if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
						if (comment.getMemberCreator().getUsername().equals(set.getKey())) {
							String[] parts = card_coment.substring(6).split("/");
							totalhours += Double.parseDouble(parts[0]);
							estimatehours += Double.parseDouble(parts[1]);
							hours.put(set.getKey(), totalhours);
							estimate.put(set.getKey(), estimatehours);
						}
					}
				}
			}

		}

		name1 = (String) hours.keySet().toArray()[0];
		name2 = (String) hours.keySet().toArray()[1];
		name3 = (String) hours.keySet().toArray()[2];
		value1 = hours.get(name1);
		value2 = hours.get(name2);
		value3 = hours.get(name3);

		name_1 = (String) estimate.keySet().toArray()[0];
		name_2 = (String) estimate.keySet().toArray()[1];
		name_3 = (String) estimate.keySet().toArray()[2];
		value_1 = estimate.get(name_1);
		value_2 = estimate.get(name_2);
		value_3 = estimate.get(name_3);

		model5.addElement("Estimate");
		model5.addElement("Performed");

	}

	/**
	 * This method calculates all the planned hours of work within a SPRINT.
	 * 
	 * @param sprint corresponds to a filter, that can be used to specify the
	 *               desired SPRINT.
	 * @return the planned hours of work, as a double.
	 */
	public double getPlannedHoursBySprint(String sprint) {
		double estimatehours = 0;
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals(sprint)) {
					for (Action comment : card.getActions()) {
						String card_coment = comment.getData().getText();
						if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
							String[] parts = card_coment.substring(6).split("/");
							estimatehours += Double.parseDouble(parts[1]);

						}

					}
				}

			}
		}
		return estimatehours;
	}

	/**
	 * This method calculates all the worked hours within a SPRINT.
	 * 
	 * @param sprint corresponds to a filter, that can be used to specify the
	 *               desired SPRINT.
	 * @return the hours of work, as a double.
	 */
	public double getTotalHoursBySprint(String sprint) {
		double totalhours = 0;
		for (Card card : cards) {
			List<Label> labels = card.getLabels();
			for (Label label : labels) {
				if (label.getName().equals(sprint)) {
					for (Action comment : card.getActions()) {
						String card_coment = comment.getData().getText();
						if ((card_coment != null) && card_coment.startsWith("plus!") && !card_coment.contains("@")) {
							String[] parts = card_coment.substring(6).split("/");
							totalhours += Double.parseDouble(parts[0]);
						}
					}
				}

			}

		}
		return totalhours;

	}

	/**
	 * This method retrieves the values within a DefaultListModel and puts them in a
	 * regular List.
	 * 
	 * @param model represents the DefaultListModel to be used.
	 * @return the populated list.
	 */
	public List<String> modelValues(DefaultListModel<String> model) {
		List<String> modelValues = new ArrayList<String>();
		for (int i = 0; i < model.getSize(); i++) {
			modelValues.add(model.getElementAt(i));
		}
		return modelValues;

	}

	/**
	 * This method takes a DefaultListModel and filters it.
	 * 
	 * @param model  represents the DefaultListModel to be used.
	 * @param filter represents the value to be filtered.
	 */
	public void filterModel(DefaultListModel<String> model, String filter) {
		List<String> modelValues = modelValues(model);
		for (String s : modelValues) {
			if (!s.startsWith(filter)) {
				if (model.contains(s)) {
					model.removeElement(s);
				}
			} else {
				if (!model.contains(s)) {
					model.addElement(s);
				}
			}
		}
	}

}