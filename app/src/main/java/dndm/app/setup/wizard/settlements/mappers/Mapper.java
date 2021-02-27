package dndm.app.setup.wizard.settlements.mappers;

public interface Mapper <E, M> {
    E mapToEntity(M model);
    M mapToModel(E entity);

    M mapToModel(E entity, M model);
}
