package dndm.app.common.header;

import dndm.app.base.BaseController;
import dndm.app.base.ViewsConfig;
import dndm.app.base.injection.DependencyInjection;
import dndm.app.setup.wizard.items.models.Item;
import dndm.app.setup.wizard.items.models.ItemMapper;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.api.MerchantServiceProvider;
import dndm.service.exposed.api.SettlementServiceProvider;
import dndm.service.exposed.models.*;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateNewItemController extends BaseController {
    @FXML
    private Button saveButton;
    @FXML
    private ChoiceBox<ItemTypeDto> itemType;
    @FXML
    private TextField itemName;
    @FXML
    private ChoiceBox<MerchantTypeDto> merchantType;
    @FXML
    private ChoiceBox<SettlementTypeDto> settlementType;
    @FXML
    private TextField itemRange;
    @FXML
    private TextField itemCost;
    @FXML
    private TextField itemWeight;
    @FXML
    private ChoiceBox<DamageTypeDto> damageType;
    @FXML
    private TextField damageValue;
    @FXML
    private ChoiceBox<ArmorTypeDto> armorType;
    @FXML
    private TextField armorValue;
    @FXML
    private ChoiceBox<PotionTypeDto> potionType;
    @FXML
    private TextField potionValue;
    @FXML
    private TextArea itemDescription;

    private Item item;

    private final ObservableList<SettlementTypeDto> settlementTypesList;
    private final ObservableList<MerchantTypeDto> merchantTypesList;
    private final ObservableList<ItemTypeDto> itemTypesList;
    private final ObservableList<ArmorTypeDto> armorTypesList;
    private final ObservableList<DamageTypeDto> damageTypesList;
    private final ObservableList<PotionTypeDto> potionTypesList;


    public CreateNewItemController() {

        setupCallbacks();

        final List<ItemTypeDto> items = ItemServiceProvider.itemTypeService().getAll();
        itemTypesList = FXCollections.observableArrayList(items);

        final List<SettlementTypeDto> settlements = SettlementServiceProvider.settlementTypeService().getAll();
        settlementTypesList = FXCollections.observableArrayList(settlements);

        final List<MerchantTypeDto> merchants = MerchantServiceProvider.merchantService().getAll();
        merchantTypesList = FXCollections.observableArrayList(merchants);

        final List<ArmorTypeDto> armorTypes = ItemServiceProvider.armorTypeService().getAll();
        armorTypesList = FXCollections.observableArrayList(armorTypes);

        final List<DamageTypeDto> damageTypes = ItemServiceProvider.damageTypeService().getAll();
        damageTypesList = FXCollections.observableArrayList(damageTypes);

        final List<PotionTypeDto> potionTypes = ItemServiceProvider.potionTypeService().getAll();
        potionTypesList = FXCollections.observableArrayList(potionTypes);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(settlementTypesList.size() > 0) {
            settlementType.setItems(settlementTypesList);
            settlementType.getSelectionModel().select(0);
        }
        if(merchantTypesList.size() > 0) {
            merchantType.setItems(merchantTypesList);
            merchantType.getSelectionModel().select(0);
        }
        if(itemTypesList.size() > 0) {
            itemType.setItems(itemTypesList);
            itemType.getSelectionModel().select(0);
        }
        if(armorTypesList.size() > 0) {
            armorType.setItems(armorTypesList);
            armorType.getSelectionModel().select(0);
        }
        if(damageTypesList.size() > 0) {
            damageType.setItems(damageTypesList);
            damageType.getSelectionModel().select(0);
        }
        if(potionTypesList.size() > 0) {
            potionType.setItems(potionTypesList);
            potionType.getSelectionModel().select(0);
        }
        item = new Item();

        item.nameProperty().bind(itemName.textProperty());
        itemCost.textProperty().bindBidirectional(item.costProperty(), new NumberStringConverter());
        itemWeight.textProperty().bindBidirectional(item.weightProperty(), new NumberStringConverter());
        itemRange.textProperty().bindBidirectional(item.itemRangeProperty(), new NumberStringConverter());
        item.descriptionProperty().bindBidirectional(itemDescription.textProperty());

        armorValue.textProperty().bindBidirectional(item.armorValueProperty(), new NumberStringConverter());
        item.armorTypeProperty().bind(armorType.valueProperty());

        damageValue.textProperty().bindBidirectional(item.damageValueProperty(), new NumberStringConverter());
        item.damageTypeProperty().bind(damageType.valueProperty());

        potionValue.textProperty().bindBidirectional(item.portionValueProperty(), new NumberStringConverter());
        item.potionTypeProperty().bind(potionType.valueProperty());

        item.settlementTypeProperty().bind(settlementType.valueProperty());
        item.merchantTypeProperty().bind(merchantType.valueProperty());
        item.itemTypeProperty().bind(itemType.valueProperty());

    }

    public void handleAddNewItemType() {
        try {
            Parent root = (Parent) DependencyInjection.load(ViewsConfig.ADD_ITEM_TYPE.getUrl());
            Stage stage = new Stage();
            stage.setTitle("New Item Type");
            stage.setScene(new Scene( root, ViewsConfig.ADD_ITEM_TYPE.getWidth(), ViewsConfig.ADD_ITEM_TYPE.getHeight()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddNewDamageType() {
        try {
            Parent root = (Parent) DependencyInjection.load(ViewsConfig.ADD_DAMAGE_TYPE.getUrl());
            Stage stage = new Stage();
            stage.setTitle("New Damage Type");
            stage.setScene(new Scene( root, ViewsConfig.ADD_DAMAGE_TYPE.getWidth(), ViewsConfig.ADD_DAMAGE_TYPE.getHeight()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddNewArmorType() {
        try {
            Parent root = (Parent) DependencyInjection.load(ViewsConfig.ADD_ARMOR_TYPE.getUrl());
            Stage stage = new Stage();
            stage.setTitle("New Armor Type");
            stage.setScene(new Scene( root, ViewsConfig.ADD_ARMOR_TYPE.getWidth(), ViewsConfig.ADD_ARMOR_TYPE.getHeight()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleAddNewPotionType() {
        try {
            Parent root = (Parent) DependencyInjection.load(ViewsConfig.ADD_POTION_TYPE.getUrl());
            Stage stage = new Stage();
            stage.setTitle("New Potion Type");
            stage.setScene(new Scene( root, ViewsConfig.ADD_POTION_TYPE.getWidth(), ViewsConfig.ADD_POTION_TYPE.getHeight()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupCallbacks() {
        Callback<Class<?>, Object> itemTypeControllerFactory = param -> new CreateNewItemTypeController(itemTypesList);

        DependencyInjection.addInjectionMethod(
                CreateNewItemTypeController.class, itemTypeControllerFactory
        );

        Callback<Class<?>, Object> armorTypeControllerFactory = param -> new CreateNewArmorTypeController(armorTypesList);

        DependencyInjection.addInjectionMethod(
                CreateNewArmorTypeController.class, armorTypeControllerFactory
        );

        Callback<Class<?>, Object> damageTypeControllerFactory = param -> new CreateNewDamageTypeController(damageTypesList);

        DependencyInjection.addInjectionMethod(
                CreateNewDamageTypeController.class, damageTypeControllerFactory
        );

        Callback<Class<?>, Object> potionTypeControllerFactory = param -> new CreateNewPotionTypeController(potionTypesList);

        DependencyInjection.addInjectionMethod(
                CreateNewPotionTypeController.class, potionTypeControllerFactory
        );
    }

    public void handleSave(ActionEvent event) {
        ItemServiceProvider.itemService().save(ItemMapper.getInstance().mapToEntity(item));

        ((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
    }
}
