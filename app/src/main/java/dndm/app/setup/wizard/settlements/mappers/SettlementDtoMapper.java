package dndm.app.setup.wizard.settlements.mappers;

import dndm.app.setup.wizard.settlements.models.SettlementModel;
import dndm.service.exposed.models.SettlementTypeDto;

public class SettlementDtoMapper implements Mapper<SettlementTypeDto, SettlementModel> {

    private static final SettlementDtoMapper instance;

    static {
         instance = new SettlementDtoMapper();
    }

    private SettlementDtoMapper() {
    }

    public static SettlementDtoMapper getInstance() {
        return instance;
    }

    @Override
    public SettlementTypeDto mapToEntity(SettlementModel model) {
        return null;
    }

    @Override
    public SettlementModel mapToModel(SettlementTypeDto entity) {
        return new SettlementModel()
                .setType(entity)
                .setSize(entity.getSize())
                .setPopulationAsString(entity.getPopulationAsString())
                .setImagePath(entity.getImage())
                .setPopulation(entity.getPopulation())
                .setMaxgold(entity.getMaxgold())
                .setPricemod(entity.getPricemod())
                .setMaxitems(entity.getMaxitems());
    }

    @Override
    public SettlementModel mapToModel(SettlementTypeDto entity, SettlementModel model) {
        return model
                .setType(entity)
                .setSize(entity.getSize())
                .setPopulationAsString(entity.getPopulationAsString())
                .setImagePath(entity.getImage())
                .setPopulation(entity.getPopulation())
                .setMaxgold(entity.getMaxgold())
                .setPricemod(entity.getPricemod())
                .setMaxitems(entity.getMaxitems());
    }
}
