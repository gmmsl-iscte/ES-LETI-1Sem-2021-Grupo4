package pt.iscte.es.grupo4.scrumgest;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class SubFrame1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SubFrame1() {
		setResizable(false);
		setTitle("SPRINT Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 924, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 611, 260);
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
		JPanel panel_7 = new JPanel();
		JPanel panel_8 = new JPanel();
		JPanel panel_9 = new JPanel();
		JPanel panel_10 = new JPanel();
		
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
		
		JList list = new JList();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_6.add(list, BorderLayout.CENTER);
		panel_3.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JTextArea txtrSprintBeginningAnd = new JTextArea();
		txtrSprintBeginningAnd.setText("SPRINT beginning and end date");
		txtrSprintBeginningAnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtrSprintBeginningAnd.setWrapStyleWord(true);
		txtrSprintBeginningAnd.setLineWrap(true);
		txtrSprintBeginningAnd.setOpaque(false);
		txtrSprintBeginningAnd.setFocusable(false);
		txtrSprintBeginningAnd.setEditable(false);
		panel_7.add(txtrSprintBeginningAnd, BorderLayout.NORTH);
		
		JList list_1 = new JList();
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.add(list_1, BorderLayout.CENTER);
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
		
		JScrollPane scrollPane = new JScrollPane();
		panel_8.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(textArea);
		panel_3.add(panel_9);
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
		
		JList list_2 = new JList();
		list_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.add(list_2, BorderLayout.CENTER);
		panel_3.add(panel_10);
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
		
		JList list_3 = new JList();
		list_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_10.add(list_3, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(654, -1, 243, 262);
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
		JPanel panel_12 = new JPanel();
		
	
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
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(644, -1, 0, 262);
		contentPane.add(verticalStrut);
		
		
	}
}
