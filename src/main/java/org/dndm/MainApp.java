package org.dndm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.dndm.configuration.DataSource;
import org.dndm.configuration.DataUtils;
import org.dndm.common.BaseController;
import org.dndm.common.SceneManager;

public class MainApp extends Application {

    private Button okButton;

    @Override
    public void init() throws Exception {
        //String stmt
        DataUtils.dbConnect();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dndm/start_view/initialScreenView.fxml"));
        Parent root = loader.load();

        BaseController controller = loader.getController();
        controller.setSceneManager(new SceneManager(primaryStage));

        primaryStage.setTitle("Start Campaign");
        primaryStage.getIcons().add(new Image("dndm/common/logo.png"));
        primaryStage.setScene(new Scene(root, 600, 400));
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
