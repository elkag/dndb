package org.dndm.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {

    private final Stage rootStage;

    public SceneManager(Stage rootStage) {
        if (rootStage == null) {
            throw new IllegalArgumentException();
        }
        this.rootStage = rootStage;
    }

    private final Map<String, Scene> scenes = new HashMap<>();

    public void switchScene(final String url, final double width, final double height) {
        Scene scene = scenes.computeIfAbsent(url, u -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(u));
            try {
                Pane p = loader.load();
                BaseController controller = loader.getController();
                controller.setSceneManager(this);
                return new Scene(p, width, height);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        rootStage.setScene(scene);
    }
}
