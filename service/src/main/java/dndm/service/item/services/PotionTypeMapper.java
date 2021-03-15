package dndm.service.item.services;

import dndm.service.common.Mapper;
import dndm.service.exposed.models.PotionTypeDto;
import dndm.utilities.data.api.entities.PotionType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class PotionTypeMapper implements Mapper<PotionType, PotionTypeDto> {

   // Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<PotionType, PotionTypeDto> instance = new PotionTypeMapper();

    private PotionTypeMapper() {
    }

    public static synchronized Mapper<PotionType, PotionTypeDto> Instance() {
        if(instance == null) {
            instance = new PotionTypeMapper();
        }
        return instance;
    }

    @Override
    public PotionTypeDto mapToModel(final PotionType entity) {
        return new PotionTypeDto()
                .setType(entity.getType())
                .setImage(entity.getImage());
    }

    @Override
    public PotionType mapToEntity(PotionTypeDto model) {
        return new PotionType()
                .setType(model.getType())
                .setImage(model.getImage());
    }
}
