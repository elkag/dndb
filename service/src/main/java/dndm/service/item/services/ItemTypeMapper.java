package dndm.service.item.services;

import dndm.service.common.Mapper;
import dndm.service.exposed.models.ItemTypeDto;
import dndm.utilities.data.api.entities.ItemType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class ItemTypeMapper implements Mapper<ItemType, ItemTypeDto> {

    //Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<ItemType, ItemTypeDto> instance = new ItemTypeMapper();

    private ItemTypeMapper() {
    }

    public static synchronized Mapper<ItemType, ItemTypeDto> Instance() {
        if(instance == null) {
            instance = new ItemTypeMapper();
        }
        return instance;
    }

    @Override
    public ItemTypeDto mapToModel(final ItemType entity) {
        return new ItemTypeDto()
                .setId(entity.getId())
                .setType(entity.getType())
                .setImage(entity.getImage());
    }

    @Override
    public ItemType mapToEntity(ItemTypeDto model) {
        return new ItemType()
                .setId(model.getId())
                .setType(model.getType())
                .setImage(model.getImage());
    }
}
