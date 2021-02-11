package dndm.dataprovider.settlement.services;

import dndm.dataprovider.common.Service;
import dndm.dataprovider.common.repository.Repository;
import dndm.dataprovider.settlement.entities.SettlementType;
import dndm.dataprovider.settlement.models.SettlementTypeDto;

import java.util.List;
import java.util.stream.Collectors;

class SettlementServiceImpl implements Service<SettlementTypeDto> {

    private final Repository<SettlementType> repository;

    SettlementServiceImpl(Repository<SettlementType> repository) {
        this.repository = repository;
    }

    @Override
    public List<SettlementTypeDto> get() {
        List<SettlementType> all = repository.getAll(SettlementType.class);

        return all.stream()
                .map(e -> SettlementTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }
}
