package dndm.app.setup.wizard.items.list;

import dndm.app.base.ViewsConfig;
import dndm.app.base.injection.DependencyInjection;
import dndm.app.setup.wizard.items.item.ItemController;
import dndm.app.setup.wizard.items.models.Item;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ItemListCellFactory extends ListCell<Item> {


    @Override
    protected void updateItem(Item item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null && !empty) {
            try {
                FXMLLoader loader = DependencyInjection.getLoader(ViewsConfig.MERCHANT_VIEW.getUrl());
                Pane newMerchantPane = loader.load();
                ItemController itemController = loader.getController();
                itemController.setModel(item);
                setGraphic(newMerchantPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            setGraphic(null);
        }
    }
}
