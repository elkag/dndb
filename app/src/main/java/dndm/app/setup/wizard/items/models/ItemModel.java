package dndm.app.setup.wizard.items.models;

import dndm.app.setup.wizard.settlements.models.SettlementModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;

public class ItemModel {
    private StringProperty name;
    private SettlementModel settlement;
    private StringProperty type = new SimpleStringProperty();
    private IntegerProperty pricemod = new SimpleIntegerProperty();
    private IntegerProperty gold = new SimpleIntegerProperty();
    private IntegerProperty maxItems = new SimpleIntegerProperty();
    private IntegerProperty maxGold = new SimpleIntegerProperty();
    private ObservableList<Integer> items = FXCollections.observableArrayList();
    private ObservableList<Integer> availableItems = FXCollections.observableArrayList();
    private Image avatar;
    private File imagePath;


    public StringProperty typeProperty() {
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

    public ItemModel setImagePath(String imageName) {
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
}
