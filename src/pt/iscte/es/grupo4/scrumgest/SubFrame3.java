package pt.iscte.es.grupo4.scrumgest;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class SubFrame3 extends JFrame {
	private DefaultListModel<String> model;
	private DefaultListModel<String> model_1;
	private JPanel contentPane;
	private GHRepository repository;
	JTextArea textArea;

	/**
	 * Creates the GitHub data frame using with a given repository as argument.
	 * 
	 * @throws FileNotFoundException
	 */
	public SubFrame3(GHRepository repository) throws FileNotFoundException {
		this.repository = repository;
		model = new DefaultListModel<String>();
		model_1 = new DefaultListModel<String>();
		setTitle("Github Data");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		getReadMe();
		panel_4.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		JList<String> list = new JList<String>();
		scrollPane_1.setViewportView(list);
		list.setModel(model);
		getTags();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

		getCommits();
		JList<String> list_1 = new JList<String>();
		list_1.setModel(model_1);
		scrollPane_2.setViewportView(list_1);

	}

	public void getTags() {

		for (GHCommit commit : repository.listCommits()) {

			try {
				Date date = commit.getCommitDate();
				DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
				String strDate = dateFormat.format(date);

				model.addElement(strDate + " - " + commit.getSHA1());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

	public void getCommits() {
		List<String> elements = new ArrayList<String>();
		for (GHCommit commit : repository.listCommits()) {
			try {
				String user = commit.getCommitShortInfo().getAuthor().getName();
				Date date = commit.getCommitDate();
				DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
				String strDate = dateFormat.format(date);
				String message = commit.getCommitShortInfo().getMessage();
				String element = user + " on " + strDate + " - " + message;
				elements.add(element);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = elements.size() - 1; i >= 0; i--) {
			model_1.addElement(elements.get(i));
		}
	}

}
