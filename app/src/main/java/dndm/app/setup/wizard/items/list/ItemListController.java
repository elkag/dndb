package dndm.app.setup.wizard.items.list;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.setup.wizard.data.SettlementsData;
import dndm.app.setup.wizard.items.models.Item;
import dndm.app.setup.wizard.merchants.models.MerchantModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class ItemListController extends BaseController {

    @FXML
    public ListView<Item> merchantsListView;

    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private VBox vbox;


    public ItemListController(SceneManager sceneManager, MerchantModel merchantModel, SettlementsData data) {
        super(sceneManager);

    }
    public ItemListController(){

    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
