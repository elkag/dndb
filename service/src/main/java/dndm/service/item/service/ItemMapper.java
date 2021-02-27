package dndm.service.item.service;

import dndm.service.common.Mapper;
import dndm.service.exposed.models.ItemDto;
import dndm.service.item.entities.Item;
import dndm.service.merchant.service.MerchantTypeMapper;
import dndm.service.settlement.services.SettlementTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemMapper implements Mapper<Item, ItemDto> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile static Mapper<Item, ItemDto> instance = new ItemMapper();

    public static synchronized Mapper<Item, ItemDto> Instance() {
        if(instance == null) {
            instance = new ItemMapper();
        }
        return instance;
    }
    private ItemMapper() {
    }

    @Override
    public ItemDto mapToModel(Item item) {
        return new ItemDto()
                .setArmorType(item.getArmorType())
                .setArmorValue(item.getArmorValue())
                .setCost(item.getCost())
                .setDamageType(item.getDamageType())
                .setDamageValue(item.getDamageValue())
                .setDescription(item.getDescription())
                .setItemRange(item.getItemRange())
                .setItemType(ItemTypeMapper.Instance().mapToModel(item.getItemType()))
                .setMerchantType(MerchantTypeMapper.Instance().mapToModel(item.getMerchantType()))
                .setName(item.getName())
                .setPortionValue(item.getPortionValue())
                .setSettlementType(SettlementTypeMapper.Instance().mapToModel(item.getSettlementType()))
                .setWeight(item.getWeight());
    }

    @Override
    public Item mapToEntity(ItemDto itemDto) {
        return null;
    }
}
