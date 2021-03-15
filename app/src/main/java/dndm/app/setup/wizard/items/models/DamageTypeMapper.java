package dndm.app.setup.wizard.items.models;

import dndm.app.setup.wizard.settlements.mappers.Mapper;
import dndm.service.exposed.models.DamageTypeDto;

public class DamageTypeMapper implements Mapper<DamageTypeDto, DamageType> {

    private static final DamageTypeMapper instance;

    static {
        instance = new DamageTypeMapper();
    }

    private DamageTypeMapper() {
    }

    public static DamageTypeMapper getInstance() {
        return instance;
    }

    @Override
    public DamageTypeDto mapToEntity(DamageType model) {
        DamageTypeDto dto = new DamageTypeDto();

        if(model.getType() != null){
            dto.setType(model.getType());
        }

        return dto;
    }

    @Override
    public DamageType mapToModel(DamageTypeDto dto) {
        DamageType model = new DamageType();

        if(dto.getType() != null){
            model.setType(dto.getType());
        }

        return model;
    }

    @Override
    public DamageType mapToModel(DamageTypeDto entity, DamageType model) {
        return null;
    }
}
