package dndm.service.item.service;

import dndm.service.common.Service;
import dndm.service.common.repository.Repository;
import dndm.service.exposed.models.ItemDto;
import dndm.service.item.entities.Item;
import dndm.service.item.entities.ItemType;

import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements Service<ItemDto> {

    private final Repository<Item> repository;

    public ItemServiceImpl(Repository<Item> repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemDto> get() {
        List<Item> items = repository.getAll(Item.class);
        if(items == null) return List.of();
        return items.stream()
                .map(e -> ItemTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }
}
