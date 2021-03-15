package dndm.service.exposed.api;

import dndm.service.exposed.models.SettlementTypeDto;
import dndm.service.common.Service;
import dndm.utilities.data.api.RepositoryProvider;
import dndm.utilities.data.api.entities.SettlementType;
import dndm.service.settlement.services.SettlementServiceImpl;
import dndm.utilities.data.api.repositories.SettlementTypeRepository;

import java.util.HashMap;

public class SettlementServiceProvider {

    private static final String SETTLEMENT_TYPE_SERVICE_NAME = "settlement-type";
    private static final String SETTLEMENT_SERVICE_NAME = "settlement";

    private static final HashMap<String, Service<SettlementType, SettlementTypeDto>> serviceMap = new HashMap<>();

    public static Service<SettlementType, SettlementTypeDto> settlementTypeService() {
        if(serviceMap.containsKey(SETTLEMENT_TYPE_SERVICE_NAME)) {
            return serviceMap.get(SETTLEMENT_TYPE_SERVICE_NAME);
        }

        Service<SettlementType, SettlementTypeDto> service = new SettlementServiceImpl((SettlementTypeRepository) RepositoryProvider.getSettlementTypeRepository());
        serviceMap.put(SETTLEMENT_TYPE_SERVICE_NAME, service);
        return service;
    }


    public static Service<SettlementType, SettlementTypeDto> settlementService() {
       return null;
    }

}
