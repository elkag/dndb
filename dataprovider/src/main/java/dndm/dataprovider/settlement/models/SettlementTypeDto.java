package dndm.dataprovider.settlement.models;

public class SettlementTypeDto {
    private String type;
    private Integer size;

    public String getType() {
        return type;
    }

    public SettlementTypeDto setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public SettlementTypeDto setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
