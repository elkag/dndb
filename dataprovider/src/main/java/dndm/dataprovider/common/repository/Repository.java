package dndm.dataprovider.common.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll(Class<T> typeArgumentClass);
}
