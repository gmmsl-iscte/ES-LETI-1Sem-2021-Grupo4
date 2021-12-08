package pt.iscte.es.grupo4.scrumgest;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * @author sarag
 *
 */
public class PieChart {
	private static double value1;
	private static double value2;
	private static double value3;
	private static String name1;
	private static String name2;
	private static String name3;
	private static double percentage;
	JFrame f;

	/**
	 * Creates a Pie Chart type graph with the given parameters.
	 * 
	 * @param title  Title of the graph.
	 * @param name1  Name of the first member.
	 * @param value1 Value correspondent to the first member.
	 * @param name2  Name of the second member.
	 * @param value2 Value correspondent to the second member.
	 * @param name3  Name of the third member.
	 * @param value3 Value correspondent to the third member.
	 * @param type   0 for a percentage type graph, 1 for a cost type graph
	 */
	public PieChart(String title, String name1, double value1, String name2, double value2, String name3, double value3,
			int type) {
		f = new JFrame(title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PieChart.value1 = value1;
		PieChart.value2 = value2;
		PieChart.value3 = value3;
		PieChart.name1 = name1;
		PieChart.name2 = name2;
		PieChart.name3 = name3;
		if (type == 0) {
			JFreeChart chart = createChart(createDatasetPercentage());
			ChartPanel chartPanel = new ChartPanel(chart);
			f.add(chartPanel);
		}
		if (type == 1) {
			JFreeChart chart = createChart(createDatasetCost());
			ChartPanel chartPanel = new ChartPanel(chart);
			f.add(chartPanel);
		}
	}

	/**
	 * Calculates the percentage of the given value.
	 * 
	 * @param value to convert.
	 * @return percentage.
	 */
	static double percentage(double v) {
		double total = value1 + value2 + value3;
		percentage = (v * 100.0) / total;
		return percentage;
	}

	/**
	 * Rounds the percentage of the given value.
	 * @param value to round.
	 * @return rounded value.
	 */
	static String percentageRounding(double p) {
		DecimalFormat df = new DecimalFormat("##.##");
		if (p + 0.05 == p + 0.1) {
			df.setRoundingMode(RoundingMode.UP);
		}
		return df.format(p);
	}

	/**
	 * Defines the window size.
	 * @param x
	 * @param y
	 */
	public void setSize(int x, int y) {
		f.setSize(x, y);
	}

	/**
	 * Defines the frame's visibility
	 * @param boolean
	 */
	public void setVisible(boolean bool) {
		f.setVisible(bool);
	}

	/**
	 * Sets the frame's close operation to dispose when closing.
	 */
	public void setDefaultCloseOperation() {
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	/**
	 * Getter for value1.
	 * @return value1.
	 */
	public static double getValue1() {
		return value1;
	}

	/**Setter for value1.
	 * @param value1
	 */
	public static void setValue1(double value1) {
		PieChart.value1 = value1;
	}

	/**
	 * Getter for value2.
	 * @return value2.
	 */
	public static double getValue2() {
		return value2;
	}

	/**Setter for value2.
	 * @param value2
	 */
	public static void setValue2(double value2) {
		PieChart.value2 = value2;
	}

	/**Getter for value3.
	 * @return value3.
	 */
	public static double getValue3() {
		return value3;
	}

	/**Setter for value3.
	 * @param value3
	 */
	public static void setValue3(double value3) {
		PieChart.value3 = value3;
	}

	/**Getter for name1.
	 * @return name1.
	 */
	public static String getName1() {
		return name1;
	}

	/**Setter for name1.
	 * @param name1
	 */
	public static void setName1(String name1) {
		PieChart.name1 = name1;
	}

	/**Getter for name2.
	 * @return name2.
	 */
	public static String getName2() {
		return name2;
	}

	/**Setter for name2.
	 * @param name2
	 */
	public static void setName2(String name2) {
		PieChart.name2 = name2;
	}

	/**Getter for name3.
	 * @return name3.
	 */
	public static String getName3() {
		return name3;
	}

	/**Setter for name3.
	 * @param name3
	 */
	public static void setName3(String name3) {
		PieChart.name3 = name3;
	}

	/**Creates a percentage based dataset to be used on the Pie chart.
	 * @return the dataset.
	 */
	private static PieDataset<String> createDatasetPercentage() {
		DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
		try {
			dataset.setValue(name1 + " " + String.valueOf(percentageRounding(percentage(value1))) + "%", value1);
			dataset.setValue(name2 + " " + String.valueOf(percentageRounding(percentage(value2))) + "%", value2);
			dataset.setValue(name3 + " " + String.valueOf(percentageRounding(percentage(value3))) + "%", value3);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return dataset;
	}

	
	/**Creates a cost based dataset to be used on the Pie chart.
	 * @return the dataset.
	 */
	private static PieDataset<String> createDatasetCost() {
		DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
		try {
			dataset.setValue(name1 + " " + Math.round(value1 * 20 * 100) / 100.00 + "€",
					Math.round(value1 * 20 * 100) / 100.00);
			dataset.setValue(name2 + " " + Math.round(value2 * 20 * 100) / 100.00 + "€",
					Math.round(value2 * 20 * 100) / 100.00);
			dataset.setValue(name3 + " " + Math.round(value3 * 20 * 100) / 100.00 + "€",
					Math.round(value3 * 20 * 100) / 100.00);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return dataset;
	}

	/**Generates a chart with the given dataset.
	 * @param dataset.
	 * @return chart.
	 */
	private static JFreeChart createChart(PieDataset<String> dataset) {
		JFreeChart chart = ChartFactory.createPieChart("", dataset, true, true, false);

		return chart;
	}

}
