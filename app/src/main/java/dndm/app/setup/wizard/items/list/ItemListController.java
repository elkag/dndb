package dndm.app.setup.wizard.items.list;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.setup.wizard.data.SettlementsData;
import dndm.app.setup.wizard.items.models.Item;
import dndm.app.setup.wizard.merchants.models.MerchantModel;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class ItemListController extends BaseController {

    @FXML
    public ListView<Item> merchantsListView;

    //private final MerchantModel merchantModel;
    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private VBox vbox;


    public ItemListController(SceneManager sceneManager, MerchantModel merchantModel, SettlementsData data) {
        super(sceneManager);
        //this.merchantModel = data.getSettlements().stream().filter(settlement::equals).findAny().get();
    }
    public ItemListController(){

    }
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    private void selectHandler(ObservableValue<? extends Item> observableValue, Item oldValue, Item newValue) {

    }

    public void BackButtonHandler() {
        sceneManager.switchScene(vbox.getScene(), ViewsConfig.SETTLEMENTS_TREE);
    }

    @FXML
    private void addMerchant() {

    }

    private Item createNewItem(){
        return null;
    }

    public void editMerchant() {

    }

    public void nextStepHandler(ActionEvent actionEvent) {
    }
}
