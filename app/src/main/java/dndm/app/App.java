package dndm.app;

import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.base.injection.DependencyInjection;
import dndm.app.common.header.HeaderController;
import dndm.app.initial.screen.Controller;
import dndm.app.setup.wizard.data.SettlementsData;
import dndm.app.setup.wizard.settlements.models.SettlementModel;
import dndm.app.setup.wizard.settlements.tree.SettlementsController;
//import dndm.utilities.db.DataSource;
//import dndm.utilities.db.DataUtils;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class App extends Application {

    //public static Set<SettlementModel> settlements = new HashSet<>();

    @Override
    public void init() throws Exception {
        //DataUtils.dbConnect();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneManager sceneManager = new SceneManager(primaryStage);
        SettlementsData settlementsData = new SettlementsData();

        setUpDependencyInjector(sceneManager, settlementsData);

        Parent root = (Parent) DependencyInjection.load(ViewsConfig.INITIAL_SCREEN.getUrl());
        primaryStage.setTitle("Start Campaign");
        primaryStage.setScene(new Scene( root, 600, 400));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        //DataSource.close();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setUpDependencyInjector(SceneManager sceneManager, SettlementsData settlementsData) {
        //set bundle
        DependencyInjection.setBundle(ResourceBundle.getBundle("greetings", Locale.UK));

        Callback<Class<?>, Object> initialScreenControllerFactory = param -> new Controller(sceneManager);
        //save the factory in the injector
        DependencyInjection.addInjectionMethod(
                Controller.class, initialScreenControllerFactory
        );

        Callback<Class<?>, Object> settlementTreeControllerFactory = param -> new SettlementsController(sceneManager, settlementsData);

        //save the factory in the injector
        DependencyInjection.addInjectionMethod(
                SettlementsController.class, settlementTreeControllerFactory
        );

        Callback<Class<?>, Object> headerControllerFactory = param -> new HeaderController(sceneManager);

        //save the factory in the injector
        DependencyInjection.addInjectionMethod(
                HeaderController.class, headerControllerFactory
        );


        Callback<Class<?>, Object> loadCampaignControllerFactory = param -> {
            return new dndm.app.load.campaign.Controller(sceneManager);
        };
        //save the factory in the injector
        DependencyInjection.addInjectionMethod(
                dndm.app.load.campaign.Controller.class, loadCampaignControllerFactory
        );
    }
}
