package dndm.app.base;

import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;

public abstract class BaseController implements Initializable {

    protected SceneManager sceneManager;


    public BaseController() {
    }

    protected BaseController(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

}
