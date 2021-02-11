package dndm.app.load.campaign;

import dndm.app.common.BaseController;
import javafx.event.ActionEvent;

public class Controller extends BaseController {
    public void onBack(ActionEvent actionEvent) {
        sceneManager.switchScene("/dndm/start_view/initialScreenView.fxml", 600d, 400d);
    }
}