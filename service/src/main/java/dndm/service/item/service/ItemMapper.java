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
        ItemDto itemDto = new ItemDto();
        if(item.getArmorType() != null){
            itemDto.setArmorType(item.getArmorType());
        }
        if(item.getArmorValue() != null){
            itemDto.setArmorValue(item.getArmorValue());
        }
        if(item.getCost() != null){
            itemDto.setCost(item.getCost());
        }
        if(item.getDamageType() != null){
            itemDto.setDamageType(item.getDamageType());
        }
        if(item.getDamageValue() != null){
            itemDto.setDamageValue(item.getDamageValue());
        }
        if(item.getDescription() != null){
            itemDto.setDescription(item.getDescription());
        }
        if(item.getItemRange() != null){
            itemDto.setItemRange(item.getItemRange());
        }
        if(item.getItemType() != null){
            itemDto.setItemType(ItemTypeMapper.Instance().mapToModel(item.getItemType()));
        }
        if(item.getItemRange() != null){
            itemDto.setItemRange(item.getItemRange());
        }
        if(item.getItemRange() != null){
            itemDto.setMerchantType(MerchantTypeMapper.Instance().mapToModel(item.getMerchantType()));
        }
        if(item.getName() != null){
            itemDto.setName(item.getName());
        }
        if(item.getPotionType() != null){
            itemDto.setPotionType(item.getPotionType());
        }
        if(item.getPortionValue() != null){
            itemDto.setPortionValue(item.getPortionValue());
        }
        if(item.getWeight() != null){
            itemDto.setWeight(item.getWeight());
        }
        if(item.getSettlementType() != null){
            itemDto.setSettlementType(SettlementTypeMapper.Instance().mapToModel(item.getSettlementType()));
        }

        return itemDto;
    }

    @Override
    public Item mapToEntity(ItemDto itemDto) {
        return null;
    }
}
