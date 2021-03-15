package dndm.app.setup.wizard.items.controllers;

import dndm.app.base.BaseController;
import dndm.app.setup.wizard.items.models.Item;
import dndm.app.setup.wizard.items.models.ItemMapper;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.ItemDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ItemController extends BaseController {
    public ImageView avatar;
    public Label name;
    public Label type;
    public Label maxItems;
    public Label maxGold;
    public Label pricemod;
    public Label settlement;

    public TableView<Item> itemsTable;
    public TableColumn<Item, String> nameColumn;
    public TableColumn<Item, String> descriptionColumn;
    public TableColumn<Item, Integer> costColumn;
    public TextField filterField;

    private final ObservableList<Item> masterData;

    public ItemController() {
        List<ItemDto> dtos = ItemServiceProvider.itemService().getAll();
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

    public void deleteMerchant() {
        //merchantModel.getMerchants().remove(item);
    }

    public void setModel(final Item item) {
       /* name.textProperty().bind(item.nameProperty());
        type.textProperty().bind(item.typeProperty());
        maxItems.textProperty().bind(Bindings.convert(item.maxItemsProperty()));
        maxGold.textProperty().bind(Bindings.convert(item.maxGoldProperty()));
        pricemod.textProperty().bind(Bindings.convert(item.pricemodProperty()));
        //settlement.textProperty().bind(Bindings.convert(item.getSettlement().nameProperty()));


        avatar.setImage(item.getAvatar());
        this.item = item;*/
    }


}
