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
import java.awt.EventQueue;


import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("SCRUM Gest");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 217);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);

		Panel panel_3 = new Panel();
		panel_3.setBounds(0, 0, 194, 49);
		panel.add(panel_3);

		JLabel lblNewLabel = new JLabel("Project Identification");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(textField);
		textField.setColumns(15);
		textField.setText("ES-LETI-1Sem-2021-Grupo4");

		Panel panel_2 = new Panel();
		panel_2.setBounds(0, 58, 194, 111);
		panel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("Group Identification");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(190, 0, 12, 190);
		panel.add(verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 55, 190, 1);
		panel.add(horizontalStrut);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "SPRINT Data", "Trello Data", "Github Data" }));
		comboBox.setBackground(Color.WHITE);
		panel_1.add(comboBox);

		JButton btnNewButton = new JButton("View");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int key = comboBox.getSelectedIndex();
				switch (key) {

				case 0: {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SubFrame1 frame1 = new SubFrame1();
								frame1.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					break;
				}
				case 1: {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SubFrame2 frame2 = new SubFrame2();
								frame2.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					break;
				}
				case 2: {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SubFrame3 frame3 = new SubFrame3();
								frame3.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					break;
				}
				}

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
