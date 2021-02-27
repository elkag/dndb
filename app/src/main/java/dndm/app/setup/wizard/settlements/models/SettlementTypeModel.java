package dndm.app.setup.wizard.settlements.models;

import java.io.Serializable;

public class SettlementTypeModel implements Serializable {
    private String name;
    private Integer size;
    private Integer population;
    private String populationAsString;
    private String image;

    public String getName() {
        return name;
    }

    public SettlementTypeModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public SettlementTypeModel setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getPopulation() {
        return population;
    }

    public SettlementTypeModel setPopulation(Integer population) {
        this.population = population;
        return this;
    }

    public String getPopulationAsString() {
        return populationAsString;
    }

    public SettlementTypeModel setPopulationAsString(String populationAsString) {
        this.populationAsString = populationAsString;
        return this;
    }

    public String getImage() {
        return image;
    }

    public SettlementTypeModel setImage(String image) {
        this.image = image;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
