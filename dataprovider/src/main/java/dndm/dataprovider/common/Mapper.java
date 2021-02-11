package dndm.dataprovider.common;

public interface Mapper <Entity, Model> {

    Model mapToModel(final Entity entity);
    Entity mapToEntity(final Model model);
}
