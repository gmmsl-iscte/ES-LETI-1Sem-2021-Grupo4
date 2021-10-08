package pt.iscte.es.grupo4.scrumgest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JComboBox;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 248);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		Panel panel_3 = new Panel();
		panel.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Project Identification");
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		Panel panel_2 = new Panel();
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Group Identification");
		panel_2.add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		panel_2.add(list);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		panel_1.add(comboBox);
		
	}
}
