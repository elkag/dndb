package dndm.dataprovider.settlement.entities;

import dndm.dataprovider.common.repository.Repository;

public class SettlementRepositoryProvider {

    private static final Repository<SettlementType> repository = new SettlementTypeRepositoryImpl();

    public static Repository<SettlementType> get() {
        return repository;
    }
}
