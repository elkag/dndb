package dndm.service.merchant.services;

import dndm.service.common.Mapper;
import dndm.utilities.data.api.entities.MerchantType;
import dndm.service.exposed.models.MerchantTypeDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class MerchantTypeMapper implements Mapper<MerchantType, MerchantTypeDto> {

   // Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<MerchantType, MerchantTypeDto> instance = new MerchantTypeMapper();

    private MerchantTypeMapper() {
    }

    public static synchronized Mapper<MerchantType, MerchantTypeDto> Instance() {
        if(instance == null) {
            instance = new MerchantTypeMapper();
        }
        return instance;
    }

    @Override
    public MerchantTypeDto mapToModel(final MerchantType entity) {
        return new MerchantTypeDto()
                .setId(entity.getId())
                .setType(entity.getType())
                .setAvatar(entity.getAvatar());
    }

    @Override
    public MerchantType mapToEntity(MerchantTypeDto model) {
        return new MerchantType()
                .setId(model.getId())
                .setType(model.getType())
                .setAvatar(model.getAvatar());
    }
}
