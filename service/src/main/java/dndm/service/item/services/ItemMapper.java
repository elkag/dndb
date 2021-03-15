package dndm.service.item.services;

import dndm.service.common.Mapper;
import dndm.service.exposed.models.ItemDto;
import dndm.utilities.data.api.entities.Item;
import dndm.service.merchant.services.MerchantTypeMapper;
import dndm.service.settlement.services.SettlementTypeMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class ItemMapper implements Mapper<Item, ItemDto> {

   // Logger logger = LoggerFactory.getLogger(this.getClass());

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
        ItemDto itemDto = new ItemDto().setId(item.getId());
        if(item.getArmorType() != null){
            itemDto.setArmorType(ArmorTypeMapper.Instance().mapToModel(item.getArmorType()));
        }
        if(item.getArmorValue() != null){
            itemDto.setArmorValue(item.getArmorValue());
        }
        if(item.getCost() != null){
            itemDto.setCost(item.getCost());
        }
        if(item.getDamageType() != null){
            itemDto.setDamageType(DamageTypeMapper.Instance().mapToModel(item.getDamageType()));
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
            itemDto.setPotionType(PotionTypeMapper.Instance().mapToModel(item.getPotionType()));
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
    public Item mapToEntity(ItemDto dto) {
        Item entity = new Item();
        if(dto.getArmorType() != null){
            entity.setArmorType(ArmorTypeMapper.Instance().mapToEntity(dto.getArmorType()));
        }
        if(dto.getArmorValue() != null){
            entity.setArmorValue(dto.getArmorValue());
        }
        if(dto.getCost() != null){
            entity.setCost(dto.getCost());
        }
        if(dto.getDamageType() != null){
            entity.setDamageType(DamageTypeMapper.Instance().mapToEntity(dto.getDamageType()));
        }
        if(dto.getDamageValue() != null){
            entity.setDamageValue(dto.getDamageValue());
        }
        if(dto.getDescription() != null){
            entity.setDescription(dto.getDescription());
        }
        if(dto.getItemRange() != null){
            entity.setItemRange(dto.getItemRange());
        }
        if(dto.getItemType() != null){
            entity.setItemType(ItemTypeMapper.Instance().mapToEntity(dto.getItemType()));
        }
        if(dto.getItemRange() != null){
            entity.setItemRange(dto.getItemRange());
        }
        if(dto.getItemRange() != null){
            entity.setMerchantType(MerchantTypeMapper.Instance().mapToEntity(dto.getMerchantType()));
        }
        if(dto.getName() != null){
            entity.setName(dto.getName());
        }
        if(dto.getPotionType() != null){
            entity.setPotionType(PotionTypeMapper.Instance().mapToEntity(dto.getPotionType()));
        }
        if(dto.getPortionValue() != null){
            entity.setPortionValue(dto.getPortionValue());
        }
        if(dto.getWeight() != null){
            entity.setWeight(dto.getWeight());
        }
        if(dto.getSettlementType() != null){
            entity.setSettlementType(SettlementTypeMapper.Instance().mapToEntity(dto.getSettlementType()));
        }

        if(dto.getMerchantType() != null){
            entity.setMerchantType(MerchantTypeMapper.Instance().mapToEntity(dto.getMerchantType()));
        }

        return entity;
    }
}
