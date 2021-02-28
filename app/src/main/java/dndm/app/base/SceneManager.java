package dndm.app.base;

import dndm.app.base.injection.DependencyInjection;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void switchScene(final Scene oldScene, final ViewsConfig view) {
        Stage stage = (Stage) oldScene.getWindow();

        Scene scene = scenes.computeIfAbsent(view.getUrl(), u -> {
            try {
                Parent root = DependencyInjection.getLoader(view.getUrl()).load();
                return new Scene(root, stage.getWidth(), stage.getHeight());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        stage.setScene(scene);
        rootStage.centerOnScreen();
    }

    public void switchScene(final ViewsConfig view) {
        Scene scene = scenes.computeIfAbsent(view.getUrl(), u -> {
            try {
                Parent root = DependencyInjection.getLoader(view.getUrl()).load();
                return new Scene(root, view.getWidth(), view.getHeight());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        rootStage.setScene(scene);
        rootStage.centerOnScreen();
    }

    public void updateScene(final ViewsConfig view) {
        try {
            Parent root = (Parent) DependencyInjection.load(view.getUrl());
            scenes.put(view.getUrl(), new Scene(root));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Scene scene = scenes.get(view.getUrl());
        rootStage.setScene(scene);
    }

    public void updateScene(final ViewsConfig view, double width, double height) {
        try {
            Parent root = (Parent) DependencyInjection.load(view.getUrl());
            scenes.put(view.getUrl(), new Scene(root, width, height));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        Scene scene = scenes.get(view.getUrl());
        rootStage.setScene(scene);
        rootStage.centerOnScreen();
    }

}
