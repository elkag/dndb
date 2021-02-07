package org.dndm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.dndm.configuration.DataSource;
import org.dndm.configuration.DataUtils;

import java.util.Objects;

public class MainApp extends Application {

    private Button okButton;

    @Override
    public void init() throws Exception {
        //String stmt
        DataUtils.dbConnect();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("dndm/sample.fxml")));

        okButton = new Button();
        okButton.setText("OK");

        StackPane layout = new StackPane();
        layout.getChildren().add(okButton);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        DataSource.close();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
