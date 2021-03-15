package dndm.app.setup.wizard.items.models;

import javafx.beans.property.*;

public class ItemType {

    private final StringProperty type;
    private final String image;

    public ItemType() {
        type = new SimpleStringProperty();
        image = "";
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }
}
