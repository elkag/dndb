package dndm.service.item.services;

import dndm.service.common.Service;
import dndm.service.exposed.models.DamageTypeDto;
import dndm.utilities.data.api.entities.DamageType;
import dndm.utilities.data.api.repositories.DamageTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DamageTypeServiceImpl implements Service<DamageType, DamageTypeDto> {

    private final DamageTypeRepository repository;

    public DamageTypeServiceImpl(DamageTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DamageTypeDto> getAll() {
        List<DamageType> items = repository.getAll();
        if(items == null) return List.of();
        return items.stream()
                .map(e -> DamageTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public void save(DamageTypeDto dto) {
        DamageType entity = DamageTypeMapper.Instance().mapToEntity(dto);
        repository.save(entity);
    }
}
