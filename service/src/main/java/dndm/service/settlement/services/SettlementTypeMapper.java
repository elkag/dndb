package dndm.service.settlement.services;

import dndm.service.common.Mapper;
import dndm.utilities.data.api.entities.SettlementType;
import dndm.service.exposed.models.SettlementTypeDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class SettlementTypeMapper implements Mapper<SettlementType, SettlementTypeDto> {

   // Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<SettlementType, SettlementTypeDto> instance = new SettlementTypeMapper();

    private SettlementTypeMapper() {
    }

    public static synchronized Mapper<SettlementType, SettlementTypeDto> Instance() {
        if(instance == null) {
            instance = new SettlementTypeMapper();
        }
        return instance;
    }

    @Override
    public SettlementTypeDto mapToModel(final SettlementType settlementType) {
        return new SettlementTypeDto()
                .setId(settlementType.getId())
                .setType(settlementType.getType())
                .setPopulation(settlementType.getPopulation())
                .setPopulationAsString(settlementType.getPopulationAsString())
                .setImage(settlementType.getImage())
                .setSize(settlementType.getSize())
                .setMaxgold(settlementType.getMaxgold())
                .setPricemod(settlementType.getPricemod())
                .setMaxitems(settlementType.getMaxitems());
    }

    @Override
    public SettlementType mapToEntity(SettlementTypeDto model) {
        return new SettlementType()
                .setId(model.getId())
                .setType(model.getType())
                .setSize(model.getSize());
    }
}
