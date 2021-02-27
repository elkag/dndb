package dndm.service.settlement.models;

public class SettlementDto {

    private String type;
    private int size;
    private String name;

    public String getName() {
        return this.name;
    }

    public SettlementDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public SettlementDto setType(String type) {
        this.type = type;
        return this;
    }

    public int getSize() {
        return size;
    }

    public SettlementDto setSize(int size) {
        this.size = size;
        return this;
    }
}
