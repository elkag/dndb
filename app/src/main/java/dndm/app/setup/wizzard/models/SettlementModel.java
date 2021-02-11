package dndm.app.setup.wizzard.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SettlementModel {

    private StringProperty name;
    private IntegerProperty size;

    public StringProperty getName() {
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
}
