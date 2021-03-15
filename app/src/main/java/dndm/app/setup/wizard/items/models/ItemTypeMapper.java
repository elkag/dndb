package dndm.app.setup.wizard.items.models;

import dndm.app.setup.wizard.settlements.mappers.Mapper;
import dndm.service.exposed.models.ItemTypeDto;

public class ItemTypeMapper implements Mapper<ItemTypeDto, ItemType> {

    private static final ItemTypeMapper instance;

    static {
        instance = new ItemTypeMapper();
    }

    private ItemTypeMapper() {
    }

    public static ItemTypeMapper getInstance() {
        return instance;
    }

    @Override
    public ItemTypeDto mapToEntity(ItemType model) {
        ItemTypeDto entity = new ItemTypeDto();

        if(model.getType() != null){
            entity.setType(model.getType());
        }

        return entity;
    }

    @Override
    public ItemType mapToModel(ItemTypeDto dto) {
        ItemType model = new ItemType();

        if(dto.getType() != null){
            model.setType(dto.getType());
        }

        return model;
    }

    @Override
    public ItemType mapToModel(ItemTypeDto entity, ItemType model) {
        return null;
    }
}
