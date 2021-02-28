package dndm.app.setup.wizard.merchants.list;

import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.base.injection.DependencyInjection;
import dndm.app.setup.wizard.merchants.merchant.MerchantController;
import dndm.app.setup.wizard.merchants.models.Merchant;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MerchantListCellFactory extends ListCell<Merchant> {

    private final SceneManager sceneManager;

    public MerchantListCellFactory(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    protected void updateItem(Merchant item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null && !empty) {
            try {
                FXMLLoader loader = DependencyInjection.getLoader(ViewsConfig.MERCHANT_VIEW.getUrl());
                Pane newMerchantPane = loader.load();
                MerchantController merchantController = loader.getController();
                merchantController.setModel(item);
                setGraphic(newMerchantPane);
                setOnMouseClicked(mouseClickedEvent -> {
                    if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 2) {
                        sceneManager.switchScene(this.getScene(), ViewsConfig.ITEMS_LIST);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            setGraphic(null);
        }
    }
}
