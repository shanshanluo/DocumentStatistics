/**
 * Created by luoshanshan on 5/12/2017.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class OpenAFile extends Application{
    private Desktop desktop = Desktop.getDesktop();

    public void start(final Stage stage)
    {
        stage.setTitle("Open a file");

        final FileChooser filechooser = new FileChooser();
        final Button openButton = new Button("Open a file to start");

        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        File file = filechooser.showOpenDialog(stage);
                        if(file != null){
                            openFile4Statistics(file);
                        }
                    }
                }
        );

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 0);

        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton);

        final Pane rootGroup = new VBox(6);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(48, 48, 48, 48));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    private void openFile4Statistics(File file){
        int[] incidences = null;
        try {
            Boolean status;
            DocumentStatistics DocStats = new DocumentStatistics();
            status = DocStats.openDocument(file);
            if(status == Boolean.TRUE){
                DocStats.scanLettersInDocument();
                incidences = DocStats.getLettersOccurringPercentage();
                BarChart4Letters chart = new BarChart4Letters(file);
                chart.setIncidences(incidences);
                chart.startStatistic();
            }
        }catch(Exception ex){
            Logger.getLogger(OpenAFile.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
