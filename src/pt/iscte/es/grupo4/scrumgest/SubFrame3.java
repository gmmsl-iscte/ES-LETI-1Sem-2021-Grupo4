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
import javax.swing.border.TitledBorder;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("serial")
public class SubFrame3 extends JFrame {
	private DefaultListModel<String> model;
	private DefaultListModel<String> model_1;
	private JPanel contentPane;
	private GHRepository repository;
	JTextArea textArea;

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public SubFrame3(GHRepository repository) throws FileNotFoundException {
		this.repository = repository;
		setResizable(false);
		setTitle("Github Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 143, 261);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Project Description");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		getReadMe();
		panel_4.add(scrollPane, BorderLayout.CENTER);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(155, 0, 12, 261);
		contentPane.add(verticalStrut);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(166, 0, 309, 260);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Master branch's tags");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(lblNewLabel_1);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1, BorderLayout.CENTER);

		model = new DefaultListModel<String>();
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		list.setModel(model);
		getCommits();

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(471, 0, 0, 261);
		contentPane.add(verticalStrut_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(485, 0, 309, 261);
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Commits");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_7.add(lblNewLabel_2);

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_8.add(scrollPane_2, BorderLayout.CENTER);

		JList list_1 = new JList();
		scrollPane_2.setViewportView(list_1);

		model_1 = new DefaultListModel<String>();
	}

	public void getCommits() {

		for (GHCommit commit : repository.listCommits()) {
			model.addElement(commit.getSHA1());

		}
	}

	public void getReadMe() throws FileNotFoundException {
		List<String> readme = new ArrayList<String>();
		File file = new File("README.md");
		@SuppressWarnings("resource")
		Scanner myReader = new Scanner(file);
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			readme.add(data);
		}
		
		textArea.setText(readme.toString());

	}

}
