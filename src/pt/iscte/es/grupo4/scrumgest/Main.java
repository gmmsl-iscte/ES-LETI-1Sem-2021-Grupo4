package pt.iscte.es.grupo4.scrumgest;

import java.awt.EventQueue;

public class Main {

	/**
	 * Launch the application.
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		My_Board project_board = new My_Board();
		project_board.loadAllTheInformation();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
