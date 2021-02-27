package dndm.app.initial.screen;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends BaseController {

    public Controller(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void onInitNewCampaign() {
        sceneManager.switchScene(ViewsConfig.SETTLEMENTS_TREE);
    }

    public void onLoadCampaign() {
        sceneManager.switchScene(ViewsConfig.LOAD_CAMPAIGN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
