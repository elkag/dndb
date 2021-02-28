package dndm.app.setup.wizard.items.list;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.setup.wizard.data.SettlementsData;
import dndm.app.setup.wizard.items.models.Item;
import dndm.app.setup.wizard.merchants.models.MerchantModel;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.ItemDto;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class ItemListController extends BaseController {

    @FXML
    public ListView<Item> merchantsListView;

    //private final MerchantModel merchantModel;
    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private VBox vbox;


    private ObservableList<ItemDto> masterData = FXCollections.observableArrayList();

    public ItemListController(SceneManager sceneManager, MerchantModel merchantModel, SettlementsData data) {
        super(sceneManager);

    }
    public ItemListController(){
        List<ItemDto> dtos = ItemServiceProvider.getService().get();
        masterData = FXCollections.observableArrayList(dtos);
        System.out.println(masterData.size());
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
// 0. Initialize the columns.


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
