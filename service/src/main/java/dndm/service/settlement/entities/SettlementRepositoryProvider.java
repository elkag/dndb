package dndm.service.settlement.entities;

import dndm.service.common.repository.Repository;

public abstract class SettlementRepositoryProvider {

    private static final SettlementTypeRepository repository;

    static {
        repository = new SettlementTypeRepository();
    }

    public static Repository<SettlementType> get() {
        return repository;
    }
}
