package dndm.app.setup.wizard.merchants.merchant;

import dndm.app.base.BaseController;
import dndm.app.setup.wizard.merchants.models.Merchant;
import dndm.app.setup.wizard.settlements.models.SettlementModel;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MerchantController extends BaseController {
    public ImageView avatar;
    public Label name;
    public Label type;
    public Label maxItems;
    public Label maxGold;
    public Label pricemod;
    public Label settlement;
    public Merchant merchant;

    private final SettlementModel settlementModel;

    public MerchantController(SettlementModel data) {
        this.settlementModel = data;
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void deleteMerchant() {
        settlementModel.getMerchants().remove(merchant);
    }

    public void setModel(final Merchant merchant) {
        name.textProperty().bind(merchant.nameProperty());
        type.textProperty().bind(merchant.typeProperty());
        maxItems.textProperty().bind(Bindings.convert(merchant.maxItemsProperty()));
        maxGold.textProperty().bind(Bindings.convert(merchant.maxGoldProperty()));
        pricemod.textProperty().bind(Bindings.convert(merchant.pricemodProperty()));
        settlement.textProperty().bind(Bindings.convert(merchant.getSettlement().nameProperty()));


        avatar.setImage(merchant.getAvatar());
        this.merchant = merchant;
    }


}
