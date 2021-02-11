package dndm.utilities.db;

import dndm.utilities.db.anotations.Column;
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
                    Column col = field.getAnnotation(Column.class);
                    if(col!=null) {
                        String name = col.value();
                        try{
                            String value = rs.getString(name);
                            field.set(dto, field.getType().getConstructor(String.class).newInstance(value));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
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
