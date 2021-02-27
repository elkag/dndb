package dndm.service.merchant.entities;

import dndm.service.common.repository.Repository;

public abstract class MerchantRepositoryProvider {

    private static final MerchantTypeRepository repository;

    static {
        repository = new MerchantTypeRepository();
    }

    public static Repository<MerchantType> get() {
        return repository;
    }
}
