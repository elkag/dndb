package dndm.app.common.header;

import dndm.app.base.BaseController;
import dndm.app.setup.wizard.items.models.PotionType;
import dndm.app.setup.wizard.items.models.PotionTypeMapper;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.PotionTypeDto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewPotionTypeController extends BaseController {
    @FXML
    private Button saveButton;
    @FXML
    private TextField potionTypeTf;

    private final PotionType potionType;

    private final ObservableList<PotionTypeDto> potionTypes;

    public CreateNewPotionTypeController(ObservableList<PotionTypeDto> armorTypes) {
        this.potionType = new PotionType();
        this.potionTypes = armorTypes;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        potionType.typeProperty().bind(potionTypeTf.textProperty());
        saveButton.disableProperty().bind(potionTypeTf.textProperty().isEmpty());
    }

    public void handleSave(final ActionEvent event) {
        ItemServiceProvider.potionTypeService().save(PotionTypeMapper.getInstance().mapToEntity(potionType));
        potionTypes.setAll(ItemServiceProvider.potionTypeService().getAll());
        ((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
    }
}
