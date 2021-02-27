package dndm.app.setup.wizard.items.item;

import dndm.app.base.BaseController;
import dndm.app.setup.wizard.items.models.Item;
import dndm.app.setup.wizard.merchants.models.MerchantModel;
import dndm.service.exposed.api.ItemServiceProvider;
import dndm.service.exposed.models.ItemDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ItemController extends BaseController {
    public ImageView avatar;
    public Label name;
    public Label type;
    public Label maxItems;
    public Label maxGold;
    public Label pricemod;
    public Label settlement;
    public Item item;

    private ObservableList<ItemDto> masterData = FXCollections.observableArrayList();

    public ItemController(MerchantModel data) {
       // this.merchantModel = data;
    }

    public ItemController() {
        // this.merchantModel = data;
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<ItemDto> dtos = ItemServiceProvider.getService().get();
        masterData = FXCollections.observableArrayList(dtos);
        System.out.println(masterData.size());
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
