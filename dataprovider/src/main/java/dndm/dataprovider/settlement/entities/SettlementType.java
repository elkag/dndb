package dndm.dataprovider.settlement.entities;

import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.Table;

@Table("settlements_type")
public class SettlementType {

    @Column("type")
    private String type;

    @Column("population")
    private Integer size;

    public String getType() {
        return type;
    }

    public SettlementType setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public SettlementType setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
