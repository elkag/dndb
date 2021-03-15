package dndm.app.setup.wizard.items.models;

import dndm.app.setup.wizard.settlements.mappers.Mapper;
import dndm.service.exposed.models.ArmorTypeDto;

public class ArmorTypeMapper implements Mapper<ArmorTypeDto, ArmorType> {

    private static final ArmorTypeMapper instance;

    static {
        instance = new ArmorTypeMapper();
    }

    private ArmorTypeMapper() {
    }

    public static ArmorTypeMapper getInstance() {
        return instance;
    }

    @Override
    public ArmorTypeDto mapToEntity(ArmorType model) {
        ArmorTypeDto dto = new ArmorTypeDto();

        if(model.getType() != null){
            dto.setType(model.getType());
        }

        return dto;
    }

    @Override
    public ArmorType mapToModel(ArmorTypeDto dto) {
        ArmorType model = new ArmorType();

        if(dto.getType() != null){
            model.setType(dto.getType());
        }

        return model;
    }

    @Override
    public ArmorType mapToModel(ArmorTypeDto entity, ArmorType model) {
        return null;
    }
}
