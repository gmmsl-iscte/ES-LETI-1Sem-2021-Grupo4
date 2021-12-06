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

public class PieChart {
	private static double value1;
	private static double value2;
	private static double value3;
	private static String name1;
	private static String name2;
	private static String name3;
	private static double percentage;
	JFrame f;

	public PieChart(String title, String name1, double value1, String name2, double value2, String name3,
			double value3) {
		f = new JFrame(title);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PieChart.value1 = value1;
		PieChart.value2 = value2;
		PieChart.value3 = value3;
		PieChart.name1 = name1;
		PieChart.name2 = name2;
		PieChart.name3 = name3;
		JFreeChart chart = createChart(createDataset());
		ChartPanel chartPanel = new ChartPanel(chart);
		f.add(chartPanel);
		
	}

	static double percentage(double v){
		double total= value1 + value2 + value3;
		percentage = (v * 100.0)/total;
		return percentage;
	}
	
	static String percentageRounding(double p) {
		DecimalFormat df = new DecimalFormat("##.##");
		if(p + 0.05 == p + 0.1) {
		df.setRoundingMode(RoundingMode.UP);
		}
		return df.format(p);
	}
	
	public void setSize(int x, int y) {
		f.setSize(x, y);
	}
	
	public void setVisible(boolean bool) {
		f.setVisible(bool);
	}
	
	public void setDefaultCloseOperation() {
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static double getValue1() {
		return value1;
	}

	public static void setValue1(double value1) {
		PieChart.value1 = value1;
	}

	public static double getValue2() {
		return value2;
	}

	public static void setValue2(double value2) {
		PieChart.value2 = value2;
	}

	public static double getValue3() {
		return value3;
	}

	public static void setValue3(double value3) {
		PieChart.value3 = value3;
	}

	public static String getName1() {
		return name1;
	}

	public static void setName1(String name1) {
		PieChart.name1 = name1;
	}

	public static String getName2() {
		return name2;
	}

	public static void setName2(String name2) {
		PieChart.name2 = name2;
	}

	public static String getName3() {
		return name3;
	}

	public static void setName3(String name3) {
		PieChart.name3 = name3;
	}

	private static PieDataset<String> createDataset() {
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

	private static JFreeChart createChart(PieDataset<String> dataset) {
		JFreeChart chart = ChartFactory.createPieChart("", dataset, true, true, false);

		return chart;
	}

}
