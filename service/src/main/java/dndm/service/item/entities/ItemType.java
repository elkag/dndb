package dndm.service.item.entities;

import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.Table;

@Table("item_types")
public class ItemType {

    @Column("name")
    private String type;

    @Column("image")
    private String image;

    public String getImage() {
        return image;
    }

    public ItemType setImage(String image) {
        this.image = image;
        return this;
    }

    public String getType() {
        return type;
    }

    public ItemType setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
