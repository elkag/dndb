package dndm.app.setup.wizard.merchants.models;

import dndm.app.setup.wizard.settlements.models.SettlementModel;
import dndm.service.exposed.models.MerchantTypeDto;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class Merchant {
    private StringProperty name;
    private SettlementModel settlement;
    private ObjectProperty<MerchantTypeDto> type = new SimpleObjectProperty<>();
    private IntegerProperty pricemod = new SimpleIntegerProperty();
    private IntegerProperty gold = new SimpleIntegerProperty();
    private IntegerProperty maxItems = new SimpleIntegerProperty();
    private IntegerProperty maxGold = new SimpleIntegerProperty();
    private ObservableList<Integer> items = FXCollections.observableArrayList();
    private ObservableList<Integer> availableItems = FXCollections.observableArrayList();
    private Image avatar;
    private File imagePath;

    public ObjectProperty<MerchantTypeDto> typeProperty() {
        return type;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty pricemodProperty() {
        return pricemod;
    }

    public IntegerProperty goldProperty() {
        return gold;
    }

    public IntegerProperty maxItemsProperty() {
        return maxItems;
    }

    public IntegerProperty maxGoldProperty() {
        return maxGold;
    }

    public File getImagePath() {
        return imagePath;
    }

    public Image getAvatar() {
        if(avatar != null) {
            return avatar;
        }
        setAvatar(imagePath);
        return this.avatar;
    }

    private void setAvatar(File file) {
        Image image = null;
        if(file != null) {
            image = new Image(file.toURI().toString());
        }

        if (image == null || image.isError()) {
            image = new Image(getClass().getResourceAsStream("/dndm/shared/images/broken.png"));
        }

        this.avatar = image;
    }

    public Merchant setImagePath(String imageName) {
        String[] path = { System.getProperty("user.home"), "dndb", "resources", "images", "merchants", imageName };
        File file = new File(String.join(File.separator, path));
        if(file.exists()) {
            this.imagePath = file;
        } else {
            this.imagePath = new File(String.join(File.separator, path));
        }
        setAvatar(imagePath);
        return this;
    }

    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name.get();
    }

    /**
     * set field
     *
     * @param name
     */
    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    /**
     * get field
     *
     * @return settlement
     */
    public SettlementModel getSettlement() {
        return this.settlement;
    }

    /**
     * set field
     *
     * @param settlement
     */
    public void setSettlement(SettlementModel settlement) {
        this.settlement = settlement;
    }

    /**
     * get field
     *
     * @return type
     */
    public MerchantTypeDto getType() {
        return this.type.get();
    }

    /**
     * set field
     *
     * @param type
     */
    public void setType(MerchantTypeDto type) {
        this.type = new SimpleObjectProperty<>(type);
    }

    /**
     * get field
     *
     * @return pricemod
     */
    public int getPricemod() {
        return this.pricemod.get();
    }

    /**
     * set field
     *
     * @param pricemod -
     */
    public void setPricemod(int pricemod) {
        this.pricemod = new SimpleIntegerProperty(pricemod);
    }

    /**
     * get field
     *
     * @return gold
     */
    public int getGold() {
        return this.gold.get();
    }

    /**
     * set field
     *
     * @param gold -
     */
    public void setGold(int gold) {
        this.gold = new SimpleIntegerProperty(gold);
    }

    /**
     * get field
     *
     * @return maxItems
     */
    public int getMaxItems() {
        return this.maxItems.get();
    }

    /**
     * set field
     *
     * @param maxItems -
     */
    public void setMaxItems(int maxItems) {
        this.maxItems = new SimpleIntegerProperty(maxItems);
    }

    /**
     * get field
     *
     * @return maxGold
     */
    public int getMaxGold() {
        return this.maxGold.get();
    }

    /**
     * set field
     *
     * @param maxGold
     */
    public void setMaxGold(int maxGold) {
        this.maxGold = new SimpleIntegerProperty(maxGold);
    }

    /**
     * get field
     *
     * @return items
     */
    public List<Integer> getItems() {
        return this.items;
    }

    /**
     * set field
     *
     * @param items
     */
    public void setItems(ObservableList<Integer> items) {
        this.items = items;
    }

    /**
     * get field
     *
     * @return availableItems
     */
    public List<Integer> getAvailableItems() {
        return this.availableItems;
    }

    /**
     * set field
     *
     * @param availableItems
     */
    public void setAvailableItems(ObservableList<Integer> availableItems) {
        this.availableItems = availableItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant that = (Merchant) o;
        return name.equals(that.name) &&
                settlement.equals(that.settlement) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, settlement, type);
    }
}
