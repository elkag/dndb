package dndm.service.settlement.services;

import dndm.service.common.Service;
import dndm.service.common.repository.Repository;
import dndm.service.settlement.entities.SettlementType;
import dndm.service.exposed.models.SettlementTypeDto;

import java.util.List;
import java.util.stream.Collectors;

public class SettlementServiceImpl implements Service<SettlementTypeDto> {

    private final Repository<SettlementType> repository;

    public SettlementServiceImpl(Repository<SettlementType> repository) {
        this.repository = repository;
    }

    @Override
    public List<SettlementTypeDto> get() {
        List<SettlementType> settlements = repository.getAll(SettlementType.class);

        return settlements.stream()
                .map(e -> SettlementTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }
}
