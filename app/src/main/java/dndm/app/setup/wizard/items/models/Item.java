package dndm.app.setup.wizard.items.models;

import dndm.service.exposed.models.ItemDto;
import dndm.service.exposed.models.MerchantTypeDto;
import dndm.service.exposed.models.SettlementTypeDto;
import javafx.beans.property.*;

public class Item {

    private StringProperty name;
    private IntegerProperty cost;
    private IntegerProperty weight;
    private ObjectProperty<ItemDto> itemType;
    private StringProperty description;
    private IntegerProperty damageType;
    private IntegerProperty damageValue;
    private IntegerProperty itemRange;
    private IntegerProperty armorType;
    private IntegerProperty armorValue;
    private IntegerProperty potionType;
    private IntegerProperty portionValue;
    private ObjectProperty<SettlementTypeDto> settlementType;
    private ObjectProperty<MerchantTypeDto> merchantType;


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getCost() {
        return cost.get();
    }

    public IntegerProperty costProperty() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost.set(cost);
    }

    public int getWeight() {
        return weight.get();
    }

    public IntegerProperty weightProperty() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight.set(weight);
    }

    public ItemDto getItemType() {
        return itemType.get();
    }

    public ObjectProperty<ItemDto> itemTypeProperty() {
        return itemType;
    }

    public void setItemType(ItemDto itemType) {
        this.itemType.set(itemType);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getDamageType() {
        return damageType.get();
    }

    public IntegerProperty damageTypeProperty() {
        return damageType;
    }

    public void setDamageType(int damageType) {
        this.damageType.set(damageType);
    }

    public int getDamageValue() {
        return damageValue.get();
    }

    public IntegerProperty damageValueProperty() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue.set(damageValue);
    }

    public int getItemRange() {
        return itemRange.get();
    }

    public IntegerProperty itemRangeProperty() {
        return itemRange;
    }

    public void setItemRange(int itemRange) {
        this.itemRange.set(itemRange);
    }

    public int getArmorType() {
        return armorType.get();
    }

    public IntegerProperty armorTypeProperty() {
        return armorType;
    }

    public void setArmorType(int armorType) {
        this.armorType.set(armorType);
    }

    public int getArmorValue() {
        return armorValue.get();
    }

    public IntegerProperty armorValueProperty() {
        return armorValue;
    }

    public void setArmorValue(int armorValue) {
        this.armorValue.set(armorValue);
    }

    public int getPotionType() {
        return potionType.get();
    }

    public IntegerProperty potionTypeProperty() {
        return potionType;
    }

    public void setPotionType(int potionType) {
        this.potionType.set(potionType);
    }

    public int getPortionValue() {
        return portionValue.get();
    }

    public IntegerProperty portionValueProperty() {
        return portionValue;
    }

    public void setPortionValue(int portionValue) {
        this.portionValue.set(portionValue);
    }

    public SettlementTypeDto getSettlementType() {
        return settlementType.get();
    }

    public ObjectProperty<SettlementTypeDto> settlementTypeProperty() {
        return settlementType;
    }

    public void setSettlementType(SettlementTypeDto settlementType) {
        this.settlementType.set(settlementType);
    }

    public MerchantTypeDto getMerchantType() {
        return merchantType.get();
    }

    public ObjectProperty<MerchantTypeDto> merchantTypeProperty() {
        return merchantType;
    }

    public void setMerchantType(MerchantTypeDto merchantType) {
        this.merchantType.set(merchantType);
    }
}
