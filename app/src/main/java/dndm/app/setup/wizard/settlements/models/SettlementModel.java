package dndm.app.setup.wizard.settlements.models;

import dndm.app.setup.wizard.merchants.models.Merchant;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.image.Image;

import java.io.*;

public class SettlementModel implements Serializable {

    private StringProperty name;
    private IntegerProperty size;

    private String type;
    private File imagePath;
    private Image image;
    private Integer population;
    private String populationAsString;
    private Integer pricemod;
    private Integer maxitems;
    private Integer maxgold;
    private final ObservableList<Merchant> merchants = FXCollections.observableArrayList();

    public ObservableList<Merchant> getMerchants() {
        return merchants;
    }

    public void addMerchant(Merchant merchant) {
        merchants.add(merchant);
    }

    public boolean removeMerchant(Merchant merchant) {
        return this.merchants.remove(merchant);
    }

    public boolean removeMerchant(int id) {
        this.merchants.remove(id);
        return true;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public SettlementModel setName(String name) {
        this.name = new SimpleStringProperty(name);
        return this;
    }

    public IntegerProperty getSize() {
        return size;
    }

    public SettlementModel setSize(int size) {
        this.size = new SimpleIntegerProperty(size);
        return this;
    }

    public String getType() {
        return type;
    }

    public SettlementModel setType(String type) {
        this.type = type;
        return this;
    }

    public Image getImage() {
        if(image != null) {
            return image;
        }
        setImage(imagePath);
        return this.image;
    }

    private void setImage(File file) {
        Image image = null;
        if(file != null) {
            image = new Image(file.toURI().toString());
        }

        if (image == null || image.isError()) {
            image = new Image(getClass().getResourceAsStream("/dndm/shared/images/broken.png"));
        }

        this.image = image;
    }

    public SettlementModel setImagePath(String imageName) {
        String[] path = { System.getProperty("user.home"), "dndb", "resources", "images", "settlements", imageName };
        File file = new File(String.join(File.separator, path));
        if(file.exists()) {
            this.imagePath = file;
        } else {
            this.imagePath = new File(String.join(File.separator, path));
        }
        setImage(imagePath);
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public SettlementModel setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    public String getPopulationAsString() {
        return populationAsString;
    }

    public SettlementModel setPopulationAsString(String populationAsString) {
        this.populationAsString = populationAsString;
        return this;
    }


    public Integer getPricemod() {
        return pricemod;
    }

    public SettlementModel setPricemod(Integer pricemod) {
        this.pricemod = pricemod;
        return this;
    }

    public Integer getMaxitems() {
        return maxitems;
    }

    public SettlementModel setMaxitems(Integer maxitems) {
        this.maxitems = maxitems;
        return this;
    }

    public Integer getMaxgold() {
        return maxgold;
    }

    public SettlementModel setMaxgold(Integer maxgold) {
        this.maxgold = maxgold;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.name.get(), this.populationAsString);
    }

    // serialization:
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeObject(nameProperty().getValue()); // write event as a plain String
        s.writeObject(getSize().getValue().toString());
    }

    // deserialization:
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.name = new SimpleStringProperty((String)s.readObject());
        this.size = new SimpleIntegerProperty((Integer) s.readObject());
    }
}
