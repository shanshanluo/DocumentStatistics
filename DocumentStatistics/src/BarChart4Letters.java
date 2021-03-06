/**
 * Created by x0241589 on 5/2/2017.
 * test check-in
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.File;

public class BarChart4Letters {
    private static File inFile = null;
    final static String[] ch = {"a", "b", "c", "d",
            "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static int[] incidences = null;

    public BarChart4Letters(File file){
        inFile = file;
    }

    public void startStatistic() {
        Stage stage = new Stage();
        stage.setTitle("Bar Chart for Letters in Document");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<>(xAxis, yAxis);

        bc.setTitle("Letter Incidences In Document");
        xAxis.setLabel("Letters");
        yAxis.setLabel("Incidences (%)");

        XYChart.Series series = new XYChart.Series();
        series.setName("Input document : " + inFile.getName());
        for(int i=0; i<26; i++){
            series.getData().add(new XYChart.Data(ch[i], incidences[i]));
        }
        Scene scene = new Scene(bc, 1000, 600);
        bc.getData().addAll(series);
        stage.setScene(scene);
        stage.show();
    }

    public void setIncidences(int[] values){
        incidences = values;
    }
}
