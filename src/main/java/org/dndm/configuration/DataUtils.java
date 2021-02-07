package org.dndm.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataUtils {

    public static Connection dbConnect() throws SQLException {
        return DataSource.getConnection();
    }

    public static void dbDisconnect(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    //DB Execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            connection = dbConnect();
            pst = connection.prepareStatement("SELECT * FROM registration");
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.format("%d %s %d %n", rs.getInt(1), rs.getString(2),
                        rs.getInt(3));
            }
        } catch (SQLException ex) {
            Logger lgr = LoggerFactory.getLogger(DataUtils.class);;
            lgr.error(ex.getMessage(), ex);

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
        return rs;
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
