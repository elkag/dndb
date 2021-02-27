package dndm.service.exposed.api;

import dndm.service.common.Service;
import dndm.service.exposed.models.ItemDto;
import dndm.service.item.entities.ItemRepositoryProvider;
import dndm.service.item.service.ItemServiceImpl;

import java.util.HashMap;

public class ItemServiceProvider {

    private static final String ITEMS_SERVICE_NAME = "items";

    private static final HashMap<String, Service<ItemDto>> serviceMap = new HashMap<>();

    public static Service<ItemDto> getService() {
        if(serviceMap.containsKey(ITEMS_SERVICE_NAME)) {
            return serviceMap.get(ITEMS_SERVICE_NAME);
        }

        Service<ItemDto> service = new ItemServiceImpl(ItemRepositoryProvider.get());
        serviceMap.put(ITEMS_SERVICE_NAME, service);
        return service;
    }
}
