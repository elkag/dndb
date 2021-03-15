package dndm.service.settlement.services;

import dndm.service.common.Service;
import dndm.utilities.data.api.entities.SettlementType;
import dndm.service.exposed.models.SettlementTypeDto;
import dndm.utilities.data.api.repositories.SettlementTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SettlementServiceImpl implements Service<SettlementType, SettlementTypeDto> {

    private final SettlementTypeRepository repository;

    public SettlementServiceImpl(SettlementTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SettlementTypeDto> getAll() {
        List<SettlementType> settlements = repository.getAll();

        return settlements.stream()
                .map(e -> SettlementTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public void save(SettlementTypeDto dto) {

    }
}
