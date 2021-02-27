package dndm.service.common.repository;

import dndm.utilities.db.DataUtils;
import dndm.utilities.db.anotations.Table;

import java.util.List;



public abstract class AbstractRepository<T> implements Repository<T>  {

    public List<T> getAll(Class<T> typeArgumentClass) {
        String tableName;

        if(typeArgumentClass.isAnnotationPresent(Table.class)) {
            tableName = typeArgumentClass.getAnnotation(Table.class).value();
            String sql = "Select * from " + tableName;
            return DataUtils.dbExecuteQuery(sql, typeArgumentClass);
        }
        return null;
    }

}
