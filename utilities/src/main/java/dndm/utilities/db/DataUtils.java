package dndm.utilities.db;

import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.JoinColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataUtils  {

    public static Connection dbConnect() throws SQLException {
        return DataSource.getConnection();
    }

    public static void dbDisconnect(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    //DB Execute Query Operation
    public static <T> List<T> dbExecuteQuery(String queryStmt, Class<T> clazz) {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<T> result = new ArrayList<>();

        try {
            connection = dbConnect();
            pst = connection.prepareStatement(queryStmt);
            rs = pst.executeQuery();

            Field[] fields = clazz.getDeclaredFields();
            for(Field field: fields) {
                field.setAccessible(true);
            }
            while (rs.next()) {
                T dto = clazz.getConstructor().newInstance();

                for(Field field: fields) {
                    if(field.isAnnotationPresent(Column.class)) {
                        Column col = field.getAnnotation(Column.class);
                        String name = col.value();
                        String value = rs.getString(name);
                        if(value != null) {
                            field.set(dto, field.getType().getConstructor(String.class).newInstance(value));
                        }

                    } else if(field.isAnnotationPresent(JoinColumn.class)) {
                        JoinColumn joinCol = field.getAnnotation(JoinColumn.class);
                        Object obj = fetchEntityById(connection, field, rs.getString(joinCol.name()));
                        field.set(dto, obj);
                    }
                }

                result.add(dto);
            }
        } catch (SQLException | NoSuchMethodException ex) {
            Logger lgr = LoggerFactory.getLogger(DataUtils.class);;
            lgr.error(ex.getMessage(), ex);

        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                dbDisconnect(connection);

            } catch (SQLException ex) {
                Logger lgr = LoggerFactory.getLogger(DataUtils.class);;
                lgr.warn(ex.getMessage(), ex);
            }
        }
        return result;
    }

    private static Object fetchEntityById(Connection connection, Field parentField, String id) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        JoinColumn joinCol = parentField.getAnnotation(JoinColumn.class);
        String table = joinCol.table();

        PreparedStatement pst = connection.prepareStatement("Select * from " + table + " where id=" + id);
        ResultSet rs = pst.executeQuery();

        if(rs.next()){
            Class<?> clazz = parentField.getType();
            Object childdto = clazz.getConstructor().newInstance();

            Field[] fields = clazz.getDeclaredFields();

            for(Field field: fields) {
                if(field.isAnnotationPresent(Column.class)){
                    Column col = field.getAnnotation(Column.class);
                    field.setAccessible(true);
                    String value = rs.getString(col.value());
                    if(value != null) {
                        field.set(childdto, field.getType().getConstructor(String.class).newInstance(value));
                    }
                } else if(field.isAnnotationPresent(JoinColumn.class)) {
                    fetchEntityById(connection, field, rs.getString(joinCol.name()));
                }

            }
            return childdto;
        }
        return null;
    }

    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException {
        //Declare statement as null
        Statement stmt = null;
        Connection connection = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            connection = dbConnect();
            //Create Statement
            stmt = connection.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            Logger lgr = LoggerFactory.getLogger(DataUtils.class);;
            lgr.error(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                dbDisconnect(connection);
            } catch (SQLException ex) {
                Logger lgr = LoggerFactory.getLogger(DataUtils.class);;
                lgr.warn(ex.getMessage(), ex);
            }
        }
    }
}
