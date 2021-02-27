package dndm.app.common.header;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.base.injection.DependencyInjection;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    @FXML
    public Region spacer;
    @FXML
    public HBox hbox;

    public Controller(final SceneManager sceneManager) {
        super(sceneManager);
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadStartScreen() {
        sceneManager.switchScene(spacer.getScene(), ViewsConfig.INITIAL_SCREEN);
    }

    public void openItemsWindow() {
        try {
            Parent root = (Parent) DependencyInjection.load(ViewsConfig.ADD_ITEMS.getUrl());
            Stage stage = new Stage();
            stage.setTitle("Explore items");
            stage.setScene(new Scene( root, ViewsConfig.ADD_ITEMS.getWidth(), ViewsConfig.ADD_ITEMS.getHeight()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
