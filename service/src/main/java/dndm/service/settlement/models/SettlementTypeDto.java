package dndm.service.settlement.models;

public class SettlementTypeDto {

    private Long id;
    private String type;
    private int size;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public SettlementTypeDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public SettlementTypeDto setType(String type) {
        this.type = type;
        return this;
    }

    public int getSize() {
        return size;
    }

    public SettlementTypeDto setSize(int size) {
        this.size = size;
        return this;
    }
}
