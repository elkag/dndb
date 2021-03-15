package dndm.service.item.services;

import dndm.service.common.Service;
import dndm.service.exposed.models.ArmorTypeDto;
import dndm.utilities.data.api.entities.ArmorType;
import dndm.utilities.data.api.repositories.ArmorTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ArmorTypeServiceImpl implements Service<ArmorType, ArmorTypeDto> {

    private final ArmorTypeRepository repository;

    public ArmorTypeServiceImpl(ArmorTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ArmorTypeDto> getAll() {
        List<ArmorType> items = repository.getAll();
        if(items == null) return List.of();
        return items.stream()
                .map(e -> ArmorTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ArmorTypeDto dto) {
        ArmorType entity = ArmorTypeMapper.Instance().mapToEntity(dto);
        repository.save(entity);
    }
}
