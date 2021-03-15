package dndm.service.item.services;

import dndm.service.common.Mapper;
import dndm.service.exposed.models.DamageTypeDto;
import dndm.utilities.data.api.entities.DamageType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class DamageTypeMapper implements Mapper<DamageType, DamageTypeDto> {

   // Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<DamageType, DamageTypeDto> instance = new DamageTypeMapper();

    private DamageTypeMapper() {
    }

    public static synchronized Mapper<DamageType, DamageTypeDto> Instance() {
        if(instance == null) {
            instance = new DamageTypeMapper();
        }
        return instance;
    }

    @Override
    public DamageTypeDto mapToModel(final DamageType entity) {
        return new DamageTypeDto()
                .setId(entity.getId())
                .setType(entity.getType())
                .setImage(entity.getImage());
    }

    @Override
    public DamageType mapToEntity(DamageTypeDto model) {
        return new DamageType()
                .setId(model.getId())
                .setType(model.getType())
                .setImage(model.getImage());
    }
}
