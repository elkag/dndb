package dndm.service.exposed.models;

public class ItemTypeDto {
    private String type;

    public String getType() {
        return type;
    }

    public ItemTypeDto setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
