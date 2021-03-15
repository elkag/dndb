package dndm.service.common;

import dndm.utilities.data.api.entities.BaseEntity;

import java.util.List;

public interface Service<K extends BaseEntity, V extends Dto> {

    List<V> getAll();
    void save(V dto);
}
