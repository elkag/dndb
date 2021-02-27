package dndm.service.exposed.models;

public class SettlementTypeDto {
    private String type;
    private Integer size;
    private Integer population;
    private String populationAsString;
    private String image;
    private Integer pricemod;
    private Integer maxitems;
    private Integer maxgold;

    public String getType() {
        return type;
    }

    public SettlementTypeDto setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public SettlementTypeDto setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public SettlementTypeDto setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    public String getPopulationAsString() {
        return populationAsString;
    }

    public SettlementTypeDto setPopulationAsString(String populationAsString) {
        this.populationAsString = populationAsString;
        return this;
    }

    public String getImage() {
        return this.image;
    }

    public SettlementTypeDto setImage(String image) {
        this.image = image;
        return this;
    }

    public Integer getPricemod() {
        return pricemod;
    }

    public SettlementTypeDto setPricemod(Integer pricemod) {
        this.pricemod = pricemod;
        return this;
    }

    public Integer getMaxitems() {
        return maxitems;
    }

    public SettlementTypeDto setMaxitems(Integer maxitems) {
        this.maxitems = maxitems;
        return this;
    }

    public Integer getMaxgold() {
        return maxgold;
    }

    public SettlementTypeDto setMaxgold(Integer maxgold) {
        this.maxgold = maxgold;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.type, this.populationAsString);
    }
}
