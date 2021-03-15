package dndm.service.item.services;

import dndm.service.common.Mapper;
import dndm.service.exposed.models.ArmorTypeDto;
import dndm.utilities.data.api.entities.ArmorType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class ArmorTypeMapper implements Mapper<ArmorType, ArmorTypeDto> {

    //Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<ArmorType, ArmorTypeDto> instance = new ArmorTypeMapper();

    private ArmorTypeMapper() {
    }

    public static synchronized Mapper<ArmorType, ArmorTypeDto> Instance() {
        if(instance == null) {
            instance = new ArmorTypeMapper();
        }
        return instance;
    }

    @Override
    public ArmorTypeDto mapToModel(final ArmorType entity) {
        if(entity == null) {
            return null;
        }
        return new ArmorTypeDto()
                .setId(entity.getId())
                .setType(entity.getType())
                .setImage(entity.getImage());
    }

    @Override
    public ArmorType mapToEntity(ArmorTypeDto model) {
        return new ArmorType()
                .setId(model.getId())
                .setType(model.getType())
                .setImage(model.getImage());
    }
}
