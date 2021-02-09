package org.dndm.campaign.setup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.dndm.common.BaseController;


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
    public ChoiceBox<SettlementType> settlementSizeChoiceBox;

    @FXML
    public void initialize() {
        settlementNameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        settlementSizeColumn.setCellValueFactory(cellData -> cellData.getValue().getSize());

        SettlementType village = new SettlementType().setName("Village > 1").setSize(1);
        SettlementType small = new SettlementType().setName("Small > 100").setSize(100);
        SettlementType medium = new SettlementType().setName("Medium > 1,000").setSize(1000);
        SettlementType big = new SettlementType().setName("Big > 100,000").setSize(100000);
        SettlementType megapolis = new SettlementType().setName("Megapolis > 1,000,000").setSize(1000000);

        settlementSizeChoiceBox.getItems().addAll(village, small, medium, big, megapolis);
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
                .setSize(settlementSizeChoiceBox.getSelectionModel().getSelectedItem().size));
    }

    public void deleteSettlement(ActionEvent actionEvent) {
        SettlementModel selectedItem = settlementsTable.getSelectionModel().getSelectedItem();
        settlementsTable.getItems().remove(selectedItem);
    }

    private static class SettlementType {
        private String name;
        private Integer size;

        public SettlementType setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getSize() {
            return size;
        }

        public SettlementType setSize(Integer size) {
            this.size = size;
            return this;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
