package dndm.app.setup.wizard.merchants.list;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.base.injection.DependencyInjection;
import dndm.app.setup.wizard.data.SettlementsData;
import dndm.app.setup.wizard.merchants.merchant.MerchantController;
import dndm.app.setup.wizard.merchants.models.Merchant;
import dndm.app.setup.wizard.settlements.models.SettlementModel;
import dndm.service.exposed.api.MerchantServiceProvider;
import dndm.service.exposed.models.MerchantTypeDto;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MerchantListController extends BaseController {

    @FXML
    public ListView<Merchant> merchantsListView;

    private final SettlementModel settlementModel;
    public ChoiceBox<MerchantTypeDto> merchantTypeChoiceBox;
    public TextField merchantName;
    public Button addButton;
    public Button deleteButton;
    public TextField newMerchantName;
    public ChoiceBox<MerchantTypeDto> newMerchantTypeChoiceBox;
    @FXML
    private VBox vbox;
    @FXML
    private Label addMerchantLabel;
    @FXML
    private Label editMerchantLabel;

    List<MerchantTypeDto> dbMerchantTypesList;

    public MerchantListController(SceneManager sceneManager, SettlementModel settlement, SettlementsData data) {
        super(sceneManager);
        this.settlementModel = data.getSettlements().stream().filter(settlement::equals).findAny().get();
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dbMerchantTypesList = MerchantServiceProvider.merchantService().get();

        merchantTypeChoiceBox.getItems().addAll(dbMerchantTypesList);
        merchantTypeChoiceBox.getSelectionModel().select(0);

        newMerchantTypeChoiceBox.getItems().addAll(dbMerchantTypesList);
        newMerchantTypeChoiceBox.getSelectionModel().select(0);

        merchantsListView.setCellFactory(listView1 -> new MerchantListCellFactory(sceneManager));
        merchantsListView.setItems(settlementModel.getMerchants());
        merchantsListView.getSelectionModel().select(0);

        //addButton.disableProperty().bind(merchantsListView.getSelectionModel().selectedItemProperty().isNull());
        merchantName.disableProperty().bind(merchantsListView.getSelectionModel().selectedItemProperty().isNull());

        merchantsListView.getSelectionModel()
                .selectedItemProperty()
                .addListener(this::selectHandler);
        addMerchantLabel.prefWidthProperty().bind(vbox.widthProperty());

        HBox.setHgrow(merchantsListView, Priority.ALWAYS);
        editMerchantLabel.prefWidthProperty().bind(vbox.widthProperty());

        Callback<Class<?>, Object> merchantControllerFactory = param -> new MerchantController(settlementModel);

        //save the factory in the injector
        DependencyInjection.addInjectionMethod(
                MerchantController.class, merchantControllerFactory
        );

    }

    private void selectHandler(ObservableValue<? extends Merchant> observableValue, Merchant oldValue, Merchant newValue) {
        if(newValue == null) {
            return;
        }
        merchantName.setText(newValue.getName());
        MerchantTypeDto dto = dbMerchantTypesList.stream().filter(l -> l.getType().equals(newValue.getType())).findAny().get();
        merchantTypeChoiceBox.getSelectionModel().select(dbMerchantTypesList.indexOf(dto));
    }

    public void BackButtonHandler() {
        sceneManager.switchScene(addButton.getScene(), ViewsConfig.SETTLEMENTS_TREE);
    }

    @FXML
    private void addMerchant() {
        Merchant merchant = createNewMerchant();
        settlementModel.addMerchant(merchant);
        merchantsListView.getSelectionModel().select(merchant);
        merchantsListView.scrollTo(merchant);
    }

    private Merchant createNewMerchant(){
        Merchant model = new Merchant();
        model.setName(newMerchantName.getText());

        final MerchantTypeDto dto = newMerchantTypeChoiceBox.getSelectionModel().getSelectedItem();
        model.setType(dto.getType());
        model.setImagePath(dto.getAvatar());
        model.setMaxGold(settlementModel.getMaxgold());
        model.setMaxItems(settlementModel.getMaxitems());
        model.setPricemod(settlementModel.getPricemod());
        model.setSettlement(settlementModel);

        return model;
    }

    public void editMerchant() {
        Merchant merchant = merchantsListView.getSelectionModel().getSelectedItem();
        if(merchant == null) {
            return;
        }
        merchant.setName(merchantName.getText());
        merchant.setType(merchantTypeChoiceBox.getSelectionModel().getSelectedItem().getType());
        merchant.setImagePath(merchantTypeChoiceBox.getSelectionModel().getSelectedItem().getAvatar());
        merchantsListView.refresh();
    }

    public void nextStepHandler() {
    }

    public void merchantEditHandler() {
        editMerchant();
    }
}
