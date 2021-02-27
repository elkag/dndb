package dndm.service.settlement.entities;

import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.Table;

@Table("settlements")
class Settlement {

    @Column("type")
    private String type;

    @Column("name")
    private String name;

    @Column("population")
    private Integer size;

    public String getType() {
        return type;
    }

    public Settlement setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public Settlement setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
