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
        return null;
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
           // model.setItemType(ItemTypeMapper.Instance().mapToModel(dto.getItemType()));
        }
        if(dto.getItemRange() != null){
            model.setItemRange(dto.getItemRange());
        }
        if(dto.getItemRange() != null){
           // model.setMerchantType(MerchantTypeMapper.Instance().mapToModel(dto.getMerchantType()));
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
            //model.setSettlementType(SettlementTypeMapper.Instance().mapToModel(dto.getSettlementType()));
        }

        return model;
    }

    @Override
    public Item mapToModel(ItemDto dto, Item model) {


            return null;

    }
}
