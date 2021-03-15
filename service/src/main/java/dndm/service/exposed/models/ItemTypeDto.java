package dndm.service.exposed.models;

import dndm.service.common.Dto;

public class ItemTypeDto implements Dto {

    private Long id;
    private String type;
    private String image;

    public Long getId() {
        return id;
    }

    public ItemTypeDto setId(Long id) {
        this.id = id;
        return this;
    }

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
