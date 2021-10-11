package pt.iscte.es.grupo4.scrumgest;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class SubFrame3 extends JFrame {

	private JList<String> list;
	private JList<String> list_1;
	private DefaultListModel<String> model;
	private DefaultListModel<String> model_1;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SubFrame3() {
		setResizable(false);
		setTitle("Github Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 143, 261);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Project Description");
		panel_3.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText("Insert the content of the README file, here, which contains the description of the project!");
		panel_4.add(scrollPane, BorderLayout.CENTER);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(145, 0, 12, 261);
		contentPane.add(verticalStrut);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(153, 0, 143, 261);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Master branch's tags");
		panel_5.add(lblNewLabel_1);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		model = new DefaultListModel<String>();
		model.addElement("insert tags (String)");
		list = new JList<String>(model);

		panel_6.add(list);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(298, 0, 0, 261);
		contentPane.add(verticalStrut_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(306, 0, 143, 261);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Commits");
		panel_7.add(lblNewLabel_2);

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.CENTER);

		model_1 = new DefaultListModel<String>();
		model_1.addElement("insert commits (String)");
		list_1 = new JList<String>(model_1);

		panel_8.add(list_1);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setBounds(450, 0, 0, 261);
		contentPane.add(verticalStrut_2);
	}
}
