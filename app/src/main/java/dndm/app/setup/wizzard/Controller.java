package dndm.app.setup.wizzard;

import dndm.app.common.BaseController;
import dndm.app.setup.wizzard.models.SettlementModel;
import dndm.dataprovider.settlement.models.SettlementTypeDto;
import dndm.dataprovider.settlement.services.SettlementServiceProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;


public class Controller extends BaseController {

    @FXML
    public TextField settlement;
    @FXML
    public TableColumn<SettlementModel, String> settlementNameColumn;
    @FXML
    public TableColumn<SettlementModel, Number> settlementSizeColumn;
    @FXML
    public TableView<SettlementModel> settlementsTable;
    @FXML
    public ChoiceBox<SettlementTypeDto> settlementSizeChoiceBox;

    @FXML
    public void initialize() {
        settlementNameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        settlementSizeColumn.setCellValueFactory(cellData -> cellData.getValue().getSize());

        List<SettlementTypeDto> list = SettlementServiceProvider.settlementService().get();

        settlementSizeChoiceBox.getItems().addAll(list);
                settlementSizeChoiceBox.getSelectionModel().select(2);
    }

    public void onBack(ActionEvent actionEvent) {
        sceneManager.switchScene("/dndm/start_view/initialScreenView.fxml", 600d, 400d);
    }

    public void addSettlement() {
        if("".equals(settlement.getText())) {
            return;
        }
        settlementsTable.getItems().addAll(new SettlementModel()
                .setName(settlement.textProperty().get())
                .setSize(settlementSizeChoiceBox.getSelectionModel().getSelectedItem().getSize()));
    }

    public void deleteSettlement(ActionEvent actionEvent) {
        SettlementModel selectedItem = settlementsTable.getSelectionModel().getSelectedItem();
        settlementsTable.getItems().remove(selectedItem);
    }
}
