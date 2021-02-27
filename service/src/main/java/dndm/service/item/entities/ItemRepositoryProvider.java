package dndm.service.item.entities;

import dndm.service.common.repository.Repository;

public abstract class ItemRepositoryProvider {

    private static final ItemTypeRepository repository;

    static {
        repository = new ItemTypeRepository();
    }

    public static Repository<Item> get() {
        return repository;
    }
}
