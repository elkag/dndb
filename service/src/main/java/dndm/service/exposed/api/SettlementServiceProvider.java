package dndm.service.exposed.api;

import dndm.service.exposed.models.SettlementTypeDto;
import dndm.service.common.Service;
import dndm.service.settlement.entities.SettlementRepositoryProvider;
import dndm.service.settlement.services.SettlementServiceImpl;

import java.util.HashMap;

public class SettlementServiceProvider {

    private static final String SETTLEMENT_TYPE_SERVICE_NAME = "settlement-type";

    private static final HashMap<String, Service<SettlementTypeDto>> serviceMap = new HashMap<>();

    public static Service<SettlementTypeDto> settlementService() {
        if(serviceMap.containsKey(SETTLEMENT_TYPE_SERVICE_NAME)) {
            return serviceMap.get(SETTLEMENT_TYPE_SERVICE_NAME);
        }

        Service<SettlementTypeDto> service = new SettlementServiceImpl(SettlementRepositoryProvider.get());
        serviceMap.put(SETTLEMENT_TYPE_SERVICE_NAME, service);
        return service;
    }
}
