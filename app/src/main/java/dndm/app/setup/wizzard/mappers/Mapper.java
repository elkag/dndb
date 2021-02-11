package dndm.app.setup.wizzard.mappers;

import java.sql.ResultSet;

public interface Mapper <T> {

    T mapToModel(final ResultSet rs);
    ResultSet mapToEntity(T model);
}
