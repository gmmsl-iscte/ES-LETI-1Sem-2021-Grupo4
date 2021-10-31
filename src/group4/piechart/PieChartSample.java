package group4.piechart;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PieChartSample extends Application {
	 
	
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Hours of Work");
        stage.setWidth(500);
        stage.setHeight(500);
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Gonçalo Lopes", 13),
                new PieChart.Data("Sara Fonseca", 25),
                new PieChart.Data("Fábio Cruz", 10),
                new PieChart.Data("Bruno Maia", 22));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Hours of work");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
        
//        Mouse listener (not working yet).
        final Label caption = new Label("");
        caption.setTextFill(Color.BLACK);
        caption.setStyle("-fx-font: 24 arial;");
        
        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        caption.setText(String.valueOf(data.getPieValue()) + "%");
                     }
                });
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}


