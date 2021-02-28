package dndm.app.setup.wizard.items.models;

import dndm.service.exposed.models.ItemDto;
import dndm.service.exposed.models.MerchantTypeDto;
import dndm.service.exposed.models.SettlementTypeDto;
import javafx.beans.property.*;

public class Item {

    private final StringProperty name;
    private final IntegerProperty cost;
    private final IntegerProperty weight;
    private final ObjectProperty<ItemDto> itemType;
    private final StringProperty description;
    private final IntegerProperty damageType;
    private final IntegerProperty damageValue;
    private final IntegerProperty itemRange;
    private final IntegerProperty armorType;
    private final IntegerProperty armorValue;
    private final IntegerProperty potionType;
    private final IntegerProperty portionValue;
    private final ObjectProperty<SettlementTypeDto> settlementType;
    private final ObjectProperty<MerchantTypeDto> merchantType;

    public Item() {
        name = new SimpleStringProperty();
        cost = new SimpleIntegerProperty();
        weight = new SimpleIntegerProperty();
        itemType = new SimpleObjectProperty<>();
        description = new SimpleStringProperty();
        damageType = new SimpleIntegerProperty();
        damageValue = new SimpleIntegerProperty();
        itemRange = new SimpleIntegerProperty();
        armorType = new SimpleIntegerProperty();
        armorValue = new SimpleIntegerProperty();
        potionType = new SimpleIntegerProperty();
        portionValue = new SimpleIntegerProperty();
        settlementType  = new SimpleObjectProperty<>();
        merchantType  = new SimpleObjectProperty<>();
    }

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
