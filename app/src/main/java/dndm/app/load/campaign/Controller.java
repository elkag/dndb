package dndm.app.load.campaign;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {


    public Controller(final SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onBack() {
        sceneManager.switchScene(ViewsConfig.INITIAL_SCREEN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}