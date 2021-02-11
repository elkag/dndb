package dndm.app.setup.wizzard.mappers.impl;

import dndm.app.setup.wizzard.mappers.Mapper;
import dndm.app.setup.wizzard.models.SettlementTypeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SettlementTypeMapper implements Mapper<SettlementTypeModel> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Mapper<SettlementTypeModel> INSTANCE = new SettlementTypeMapper();

    private SettlementTypeMapper() {
    }

    public static synchronized Mapper<SettlementTypeModel> Instance() {
        if(INSTANCE == null) {
            INSTANCE = new SettlementTypeMapper();
        }
        return INSTANCE;
    }
    public SettlementTypeModel mapToModel(final ResultSet rs) {
        SettlementTypeModel model = new SettlementTypeModel();
        try {
            model.setName(rs.getNString("type"));
            model.setSize(rs.getInt("population"));
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return model;
    }

    @Override
    public ResultSet mapToEntity(SettlementTypeModel model) {
        return null;
    }
}
