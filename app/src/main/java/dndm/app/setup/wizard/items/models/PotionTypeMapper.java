package dndm.app.setup.wizard.items.models;

import dndm.app.setup.wizard.settlements.mappers.Mapper;
import dndm.service.exposed.models.PotionTypeDto;

public class PotionTypeMapper implements Mapper<PotionTypeDto, PotionType> {

    private static final PotionTypeMapper instance;

    static {
        instance = new PotionTypeMapper();
    }

    private PotionTypeMapper() {
    }

    public static PotionTypeMapper getInstance() {
        return instance;
    }

    @Override
    public PotionTypeDto mapToEntity(PotionType model) {
        PotionTypeDto dto = new PotionTypeDto();

        if(model.getType() != null){
            dto.setType(model.getType());
        }

        return dto;
    }

    @Override
    public PotionType mapToModel(PotionTypeDto entity) {
        if(entity == null) {
            return null;
        }
        PotionType model = new PotionType();

        if(entity.getType() != null){
            model.setType(entity.getType());
        }

        return model;
    }

    @Override
    public PotionType mapToModel(PotionTypeDto entity, PotionType model) {
        return null;
    }
}
