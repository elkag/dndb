package dndm.service.item.services;

import dndm.service.common.Service;
import dndm.service.exposed.models.PotionTypeDto;
import dndm.utilities.data.api.entities.PotionType;
import dndm.utilities.data.api.repositories.PotionTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PotionTypeServiceImpl implements Service<PotionType, PotionTypeDto> {

    private final PotionTypeRepository repository;

    public PotionTypeServiceImpl(PotionTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PotionTypeDto> getAll() {
        List<PotionType> items = repository.getAll();
        if(items == null) return List.of();
        return items.stream()
                .map(e -> PotionTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PotionTypeDto dto) {
        PotionType entity = PotionTypeMapper.Instance().mapToEntity(dto);
        repository.save(entity);
    }
}
