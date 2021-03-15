package dndm.app.common.header;

import dndm.app.base.BaseController;
import dndm.app.setup.wizard.items.models.ArmorType;
import dndm.app.setup.wizard.items.models.ArmorTypeMapper;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.ArmorTypeDto;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewArmorTypeController extends BaseController {
    @FXML
    private Button saveButton;
    @FXML
    private TextField armorTypeTf;

    private final ArmorType armorType;
    private final ObservableList<ArmorTypeDto> armorTypes;

    public CreateNewArmorTypeController(ObservableList<ArmorTypeDto> armorTypes) {
        this.armorType = new ArmorType();
        this.armorTypes = armorTypes;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        armorType.typeProperty().bind(armorTypeTf.textProperty());
        saveButton.disableProperty().bind(armorTypeTf.textProperty().isEmpty());
    }

    public void handleSave(final ActionEvent event) {
        ItemServiceProvider.armorTypeService().save(ArmorTypeMapper.getInstance().mapToEntity(armorType));
        armorTypes.setAll(ItemServiceProvider.armorTypeService().getAll());
        ((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
    }
}
