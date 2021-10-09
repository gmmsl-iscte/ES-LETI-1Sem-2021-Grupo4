package pt.iscte.es.grupo4.scrumgest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 221);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);

		Panel panel_3 = new Panel();
		panel_3.setBounds(0, 0, 177, 57);
		panel.add(panel_3);

		JLabel lblNewLabel = new JLabel("Project Identification");
		panel_3.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(textField);
		textField.setColumns(16);
		textField.setText("ES-LETI-1Sem-2021-Grupo4");

		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 50, 177, 136);
		panel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Group Identification");
		panel_2.add(lblNewLabel_1);

		JList<String> list = new JList<String>();
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		list.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "Sara Fonseca - 60188", "Fabio Cruz - 62003", "Gonçalo Lopes - 54342",
					"Bruno Maia - 69093" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});

		list.setBackground(Color.WHITE);
		panel_2.add(list);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 45, 177, 0);
		panel.add(horizontalStrut);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 46, 84, 0 };
		gbl_panel_1.rowHeights = new int[] { 20, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Sprint Data", "Trello Data", "Github Data" }));
		comboBox.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
