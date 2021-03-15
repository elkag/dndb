package dndm.app.common.header;

import dndm.app.base.BaseController;
import dndm.app.setup.wizard.items.models.ItemType;
import dndm.app.setup.wizard.items.models.ItemTypeMapper;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.ItemTypeDto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewItemTypeController extends BaseController {
    @FXML
    private Button saveButton;
    @FXML
    private TextField itemTypeTf;

    private final ItemType itemType;

    private final ObservableList<ItemTypeDto> potionTypes;

    public CreateNewItemTypeController(ObservableList<ItemTypeDto> armorTypes) {
        this.itemType = new ItemType();
        this.potionTypes = armorTypes;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemType.typeProperty().bind(itemTypeTf.textProperty());
        saveButton.disableProperty().bind(itemTypeTf.textProperty().isEmpty());
    }

    public void handleSave(final ActionEvent event) {
        ItemServiceProvider.itemTypeService().save(ItemTypeMapper.getInstance().mapToEntity(itemType));
        potionTypes.setAll(ItemServiceProvider.itemTypeService().getAll());
        ((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
    }
}
