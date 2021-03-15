package dndm.app.setup.wizard.items.controllers;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.setup.wizard.items.models.Item;
import dndm.app.setup.wizard.items.models.ItemMapper;
import dndm.app.setup.wizard.merchants.models.Merchant;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.ItemDto;
import dndm.service.exposed.models.SettlementTypeDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AddItemsController extends BaseController {

    @FXML
    private TableView<Item> itemsTable;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, Integer> costColumn;
    @FXML
    private TextField filterField;

    private final ObservableList<Item> masterData;

    private final Merchant merchant;

    public AddItemsController(SceneManager sceneManager, Merchant merchant) {
        this.merchant = merchant;

        List<ItemDto> dtos =
                ItemServiceProvider.itemService()
                        .getBySettlementTypeIdAndMerchantTypeId(
                                merchant.getSettlement().getType().getId(),
                                merchant.getType().getId());

        List<Item> items = dtos.stream().map(d -> ItemMapper.getInstance().mapToModel(d)).collect(Collectors.toList());
        masterData = FXCollections.observableArrayList(items);
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemsTable.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE
        );
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        costColumn.setCellValueFactory(cellData -> cellData.getValue().costProperty().asObject());

        FilteredList<Item> filteredData = new FilteredList<>(masterData, p -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) ->
                filteredData.setPredicate(item -> {
                    // If filter text is empty, display all items.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if (item.getName().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches item name.
                    } else return item.getDescription().toLowerCase().contains(lowerCaseFilter); // Filter matches description.
                }));

        // Wrap the FilteredList in a SortedList.
        SortedList<Item> sortedData = new SortedList<>(filteredData);

        //    Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(itemsTable.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        itemsTable.setItems(sortedData);
    }

}
