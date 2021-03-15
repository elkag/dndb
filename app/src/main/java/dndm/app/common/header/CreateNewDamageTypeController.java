package dndm.app.common.header;

import dndm.app.base.BaseController;
import dndm.app.setup.wizard.items.models.ArmorType;
import dndm.app.setup.wizard.items.models.ArmorTypeMapper;
import dndm.app.setup.wizard.items.models.DamageType;
import dndm.app.setup.wizard.items.models.DamageTypeMapper;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.ArmorTypeDto;
import dndm.service.exposed.models.DamageTypeDto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewDamageTypeController extends BaseController {
    @FXML
    private Button saveButton;
    @FXML
    private TextField damageTypeTf;

    private final DamageType damageType;

    private final ObservableList<DamageTypeDto> damageTypes;

    public CreateNewDamageTypeController(ObservableList<DamageTypeDto> armorTypes) {
        this.damageType = new DamageType();
        this.damageTypes = armorTypes;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        damageType.typeProperty().bind(damageTypeTf.textProperty());
        saveButton.disableProperty().bind(damageTypeTf.textProperty().isEmpty());
    }

    public void handleSave(final ActionEvent event) {
        ItemServiceProvider.damageTypeService().save(DamageTypeMapper.getInstance().mapToEntity(damageType));
        damageTypes.setAll(ItemServiceProvider.damageTypeService().getAll());
        ((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
    }
}
