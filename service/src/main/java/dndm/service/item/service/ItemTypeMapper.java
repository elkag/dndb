package dndm.service.item.service;

import dndm.service.common.Mapper;
import dndm.service.exposed.models.ItemDto;
import dndm.service.item.entities.Item;
import dndm.service.item.entities.ItemType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemTypeMapper implements Mapper<Item, ItemDto> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<Item, ItemDto> instance = new ItemTypeMapper();

    private ItemTypeMapper() {
    }

    public static synchronized Mapper<Item, ItemDto> Instance() {
        if(instance == null) {
            instance = new ItemTypeMapper();
        }
        return instance;
    }

    @Override
    public ItemDto mapToModel(final Item entity) {
        return new ItemDto();
    }

    @Override
    public Item mapToEntity(ItemDto model) {
        return new Item();
    }
}
