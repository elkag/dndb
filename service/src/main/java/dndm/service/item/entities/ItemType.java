package dndm.service.item.entities;

import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.Table;

@Table("item_types")
public class ItemType {

    @Column("type")
    private String type;

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
