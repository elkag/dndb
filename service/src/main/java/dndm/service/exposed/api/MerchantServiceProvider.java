package dndm.service.exposed.api;

import dndm.utilities.data.api.RepositoryProvider;
import dndm.service.exposed.models.MerchantTypeDto;
import dndm.service.common.Service;
import dndm.utilities.data.api.entities.MerchantType;
import dndm.service.merchant.services.MerchantServiceImpl;
import dndm.utilities.data.api.repositories.MerchantTypeRepository;

import java.util.HashMap;

public class MerchantServiceProvider {

    private static final String MERCHANT_TYPE_SERVICE_NAME = "merchant-type";

    private static final HashMap<String, Service<MerchantType, MerchantTypeDto>> serviceMap = new HashMap<>();

    public static Service<MerchantType, MerchantTypeDto> merchantService() {
        if(serviceMap.containsKey(MERCHANT_TYPE_SERVICE_NAME)) {
            return serviceMap.get(MERCHANT_TYPE_SERVICE_NAME);
        }

        Service<MerchantType, MerchantTypeDto> service = new MerchantServiceImpl((MerchantTypeRepository) RepositoryProvider.getMerchantTypeRepository());
        serviceMap.put(MERCHANT_TYPE_SERVICE_NAME, service);
        return service;
    }
}
