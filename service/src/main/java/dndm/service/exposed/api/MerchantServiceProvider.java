package dndm.service.exposed.api;

import dndm.service.exposed.models.MerchantTypeDto;
import dndm.service.common.Service;
import dndm.service.merchant.entities.MerchantRepositoryProvider;
import dndm.service.merchant.service.MerchantServiceImpl;

import java.util.HashMap;

public class MerchantServiceProvider {

    private static final String MERCHANT_TYPE_SERVICE_NAME = "merchant-type";

    private static final HashMap<String, Service<MerchantTypeDto>> serviceMap = new HashMap<>();

    public static Service<MerchantTypeDto> merchantService() {
        if(serviceMap.containsKey(MERCHANT_TYPE_SERVICE_NAME)) {
            return serviceMap.get(MERCHANT_TYPE_SERVICE_NAME);
        }

        Service<MerchantTypeDto> service = new MerchantServiceImpl(MerchantRepositoryProvider.get());
        serviceMap.put(MERCHANT_TYPE_SERVICE_NAME, service);
        return service;
    }
}
