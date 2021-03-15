package dndm.service.exposed.api;

import dndm.service.common.Dto;
import dndm.service.common.Service;
import dndm.service.exposed.models.*;
import dndm.service.exposed.services.ItemService;
import dndm.service.exposed.services.ItemTypeService;
import dndm.service.item.services.*;
import dndm.utilities.data.api.RepositoryProvider;
import dndm.utilities.data.api.entities.*;
import dndm.utilities.data.api.entities.BaseEntity;
import dndm.utilities.data.api.repositories.*;

import java.util.HashMap;
import java.util.Map;

public class ItemServiceProvider {

    private static final String ITEMS_SERVICE_NAME = "item-service";
    private static final String ITEMS_TYPE_SERVICE_NAME = "item-type-service";
    private static final String DAMAGE_TYPE_SERVICE_NAME = "damage-type-service";
    private static final String ARMOR_TYPE_SERVICE_NAME = "armor-type-service";
    private static final String POTION_TYPE_SERVICE_NAME = "potion-type-service";

    private static final Map<String, Service<? extends BaseEntity, ? extends Dto>> serviceMap = new HashMap<>();

    public static ItemService itemService() {
        if(serviceMap.containsKey(ITEMS_SERVICE_NAME)) {
            return (ItemService) serviceMap.get(ITEMS_SERVICE_NAME);
        }
        ItemService service = new ItemServiceImpl(RepositoryProvider.getItemRepository());
        serviceMap.put(ITEMS_SERVICE_NAME, service);
        return service;
    }

    public static ItemTypeService itemTypeService() {
        if(serviceMap.containsKey(ITEMS_TYPE_SERVICE_NAME)) {
            return (ItemTypeService) serviceMap.get(ITEMS_TYPE_SERVICE_NAME);
        }
        ItemTypeService service = new ItemTypeServiceImpl(RepositoryProvider.getItemTypeRepository());
        serviceMap.put(ITEMS_TYPE_SERVICE_NAME, service);
        return service;
    }

    public static Service<ArmorType, ArmorTypeDto> armorTypeService() {
        if(serviceMap.containsKey(ARMOR_TYPE_SERVICE_NAME)) {
            return (Service<ArmorType, ArmorTypeDto>) serviceMap.get(ARMOR_TYPE_SERVICE_NAME);
        }
        Service<ArmorType, ArmorTypeDto> service = new ArmorTypeServiceImpl((ArmorTypeRepository) RepositoryProvider.getArmorTypeRepository());
        serviceMap.put(ARMOR_TYPE_SERVICE_NAME, service);
        return service;
    }

    public static Service<DamageType, DamageTypeDto> damageTypeService() {
        if(serviceMap.containsKey(DAMAGE_TYPE_SERVICE_NAME)) {
            return (Service<DamageType, DamageTypeDto>) serviceMap.get(DAMAGE_TYPE_SERVICE_NAME);
        }
        Service<DamageType, DamageTypeDto> service = new DamageTypeServiceImpl((DamageTypeRepository) RepositoryProvider.getDamageTypeRepository());
        serviceMap.put(DAMAGE_TYPE_SERVICE_NAME, service);
        return service;
    }

    public static Service<PotionType, PotionTypeDto> potionTypeService() {
        if(serviceMap.containsKey(POTION_TYPE_SERVICE_NAME)) {
            return (Service<PotionType,PotionTypeDto>) serviceMap.get(POTION_TYPE_SERVICE_NAME);
        }
        Service<PotionType, PotionTypeDto> service = new PotionTypeServiceImpl((PotionTypeRepository) RepositoryProvider.getPotionTypeRepository());
        serviceMap.put(POTION_TYPE_SERVICE_NAME, service);
        return service;
    }


}
