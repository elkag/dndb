package dndm.service.exposed.models;

public class ItemTypeDto {
    private String type;
    private String image;

    public String getImage() {
        return image;
    }

    public ItemTypeDto setImage(String image) {
        this.image = image;
        return this;
    }

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
