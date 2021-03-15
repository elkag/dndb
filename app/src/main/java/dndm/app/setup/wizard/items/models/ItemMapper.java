package dndm.app.setup.wizard.items.models;

import dndm.app.setup.wizard.settlements.mappers.Mapper;
import dndm.service.exposed.models.ItemDto;

public class ItemMapper implements Mapper<ItemDto, Item> {

    private static final ItemMapper instance;

    static {
        instance = new ItemMapper();
    }

    private ItemMapper() {
    }

    public static ItemMapper getInstance() {
        return instance;
    }

    @Override
    public ItemDto mapToEntity(Item model) {
        ItemDto entity = new ItemDto();
        if(model.getArmorType() != null){
            entity.setArmorType(model.getArmorType());
        }
        if(model.getArmorValue() > 0){
            entity.setArmorValue(model.getArmorValue());
        }
        if(model.getCost() > 0){
            entity.setCost(model.getCost());
        }
        if(model.getWeight() > 0){
            entity.setWeight(model.getWeight());
        }
        if(model.getDamageType() != null){
            entity.setDamageType(model.getDamageType());
        }
        if(model.getDamageValue() > 0){
            entity.setDamageValue(model.getDamageValue());
        }
        if(!model.getDescription().isEmpty()){
            entity.setDescription(model.getDescription());
        }
       // if(model.getItemRange() > 0){
            entity.setItemRange(model.getItemRange());
       // }
        if(model.getItemType() != null){
            entity.setItemType(model.getItemType());
        }
       //if(model.getItemRange() > 0){
            entity.setItemRange(model.getItemRange());
       // }
        if(model.getMerchantType() != null){
            entity.setMerchantType(model.getMerchantType());
        }
        if(model.getName() != null){
            entity.setName(model.getName());
        }
        if(model.getPotionType() != null){
            entity.setPotionType(model.getPotionType());
        }
        if(model.getPortionValue() > 0){
            entity.setPortionValue(model.getPortionValue());
        }
        if(model.getWeight() > 0){
            entity.setWeight(model.getWeight());
        }
        if(model.getSettlementType() != null){
            entity.setSettlementType(model.getSettlementType());
        }

        return entity;
    }

    @Override
    public Item mapToModel(ItemDto dto) {
        Item model = new Item();
        if(dto.getArmorType() != null){
            model.setArmorType(dto.getArmorType());
        }
        if(dto.getArmorValue() != null){
            model.setArmorValue(dto.getArmorValue());
        }
        if(dto.getCost() != null){
            model.setCost(dto.getCost());
        }
        if(dto.getWeight() != null){
            model.setWeight(dto.getWeight());
        }
        if(dto.getDamageType() != null){
            model.setDamageType(dto.getDamageType());
        }
        if(dto.getDamageValue() != null){
            model.setDamageValue(dto.getDamageValue());
        }
        if(dto.getDescription() != null){
            model.setDescription(dto.getDescription());
        }
        if(dto.getItemRange() != null){
            model.setItemRange(dto.getItemRange());
        }
        if(dto.getItemType() != null){
            model.setItemType(dto.getItemType());
        }
        if(dto.getItemRange() != null){
            model.setItemRange(dto.getItemRange());
        }
        if(dto.getItemRange() != null){
            model.setMerchantType(dto.getMerchantType());
        }
        if(dto.getName() != null){
            model.setName(dto.getName());
        }
        if(dto.getPotionType() != null){
            model.setPotionType(dto.getPotionType());
        }
        if(dto.getPortionValue() != null){
            model.setPortionValue(dto.getPortionValue());
        }
        if(dto.getWeight() != null){
            model.setWeight(dto.getWeight());
        }
        if(dto.getSettlementType() != null){
            model.setSettlementType(dto.getSettlementType());
        }

        return model;
    }

    @Override
    public Item mapToModel(ItemDto dto, Item model) {


            return null;

    }
}
