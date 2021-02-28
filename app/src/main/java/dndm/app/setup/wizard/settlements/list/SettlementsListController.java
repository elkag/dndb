package dndm.app.setup.wizard.settlements.list;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.setup.wizard.settlements.models.SettlementModel;
import dndm.app.setup.wizard.settlements.tree.SettlementTreeView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class SettlementsListController extends BaseController {

    @FXML
    private Label settlementName;
    @FXML
    private Label settlementType;
    @FXML
    private ListView<VBox> list;

    private final SettlementTreeView<SettlementModel> settlementsTree;


    public SettlementsListController(SceneManager sceneManager, SettlementTreeView<SettlementModel> settlementsTree) {
        super(sceneManager);
        this.settlementsTree = settlementsTree;
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        settlementsTree.forEach(s -> {
            VBox pane = new VBox();
            HBox hBox = new HBox();
            ImageView image = new ImageView();
            image.setImage(s.getValue().getImage());
            Text name = new Text();
            name.setText(s.getValue().nameProperty().get());
            hBox.getChildren().addAll(image, name);
            pane.getChildren().add(hBox);
            list.getItems().add(pane);
        });
    }

    public void BackButtonHandler() {
        sceneManager.switchScene(settlementName.getScene(), ViewsConfig.SETTLEMENTS_TREE);
    }
}
