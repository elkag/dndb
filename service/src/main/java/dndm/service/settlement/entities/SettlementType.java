package dndm.service.settlement.entities;

import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.Table;

@Table("settlement_types")
public class SettlementType {

    @Column("type")
    private String type;

    @Column("size")
    private Integer size;

    @Column("population")
    private Integer population;

    @Column("population_str")
    private String populationAsString;

    @Column("image_path")
    private String image;

    @Column("pricemod")
    private Integer pricemod;

    @Column("maxitems")
    private Integer maxitems;

    @Column("maxgold")
    private Integer maxgold;

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

    public Integer getPopulation() {
        return population;
    }

    public SettlementType setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    public String getPopulationAsString() {
        return populationAsString;
    }

    public SettlementType setPopulationAsString(String populationAsString) {
        this.populationAsString = populationAsString;
        return this;
    }

    public String getImage() {
        return image;
    }

    public SettlementType setImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getPricemod() {
        return pricemod;
    }

    public SettlementType setPricemod(Integer pricemod) {
        this.pricemod = pricemod;
        return this;
    }

    public Integer getMaxitems() {
        return maxitems;
    }

    public SettlementType setMaxitems(Integer maxitems) {
        this.maxitems = maxitems;
        return this;
    }

    public Integer getMaxgold() {
        return maxgold;
    }

    public SettlementType setMaxgold(Integer maxgold) {
        this.maxgold = maxgold;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.type, this.populationAsString);
    }
}
