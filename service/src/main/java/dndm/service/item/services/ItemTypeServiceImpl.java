package dndm.service.item.services;

import dndm.service.exposed.models.ItemTypeDto;
import dndm.service.exposed.services.ItemTypeService;
import dndm.utilities.data.api.entities.ItemType;
import dndm.utilities.data.api.repositories.ItemTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ItemTypeServiceImpl implements ItemTypeService {

    private final ItemTypeRepository repository;

    public ItemTypeServiceImpl(ItemTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemTypeDto> getAll() {
        List<ItemType> items = repository.getAll();
        if(items == null) return List.of();
        return items.stream()
                .map(e -> ItemTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ItemTypeDto dto) {
        ItemType entity = ItemTypeMapper.Instance().mapToEntity(dto);
        repository.save(entity);
    }

    public void concrete(){

    }
}
