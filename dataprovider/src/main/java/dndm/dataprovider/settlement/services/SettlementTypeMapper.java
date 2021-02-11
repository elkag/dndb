package dndm.dataprovider.settlement.services;

import dndm.dataprovider.common.Mapper;
import dndm.dataprovider.settlement.entities.SettlementType;
import dndm.dataprovider.settlement.models.SettlementTypeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SettlementTypeMapper implements Mapper<SettlementType, SettlementTypeDto> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
                    .setType(settlementType.getType())
                    .setSize(settlementType.getSize());
    }

    @Override
    public SettlementType mapToEntity(SettlementTypeDto model) {
        return new SettlementType()
                .setType(model.getType())
                .setSize(model.getSize());
    }
}
