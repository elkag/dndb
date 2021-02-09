package org.dndm.load.campaign;

import javafx.event.ActionEvent;
import org.dndm.common.BaseController;

public class Controller extends BaseController {
    public void onBack(ActionEvent actionEvent) {
        sceneManager.switchScene("/dndm/start_view/initialScreenView.fxml", 600d, 400d);
    }
}
