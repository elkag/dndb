package dndm.app.setup.wizzard.models;

public class SettlementTypeModel {
    private String name;
    private Integer size;

    public String getName() {
        return name;
    }

    public SettlementTypeModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public SettlementTypeModel setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
