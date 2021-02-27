package dndm.service.exposed.models;

public class ItemDto {

    private String name;
    private int cost;
    private int weight;
    private ItemTypeDto itemType;
    private String description;
    private int damageType;
    private int damageValue;
    private int itemRange;
    private int armorType;
    private int armorValue;
    private int potionType;
    private int portionValue;
    private SettlementTypeDto settlementType;
    private MerchantTypeDto merchantType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ItemTypeDto getItemType() {
        return itemType;
    }

    public void setItemType(ItemTypeDto itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDamageType() {
        return damageType;
    }

    public void setDamageType(int damageType) {
        this.damageType = damageType;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public int getItemRange() {
        return itemRange;
    }

    public void setItemRange(int itemRange) {
        this.itemRange = itemRange;
    }

    public int getArmorType() {
        return armorType;
    }

    public void setArmorType(int armorType) {
        this.armorType = armorType;
    }

    public int getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(int armorValue) {
        this.armorValue = armorValue;
    }

    public int getPotionType() {
        return potionType;
    }

    public void setPotionType(int potionType) {
        this.potionType = potionType;
    }

    public int getPortionValue() {
        return portionValue;
    }

    public void setPortionValue(int portionValue) {
        this.portionValue = portionValue;
    }

    public SettlementTypeDto getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(SettlementTypeDto settlementType) {
        this.settlementType = settlementType;
    }

    public MerchantTypeDto getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(MerchantTypeDto merchantType) {
        this.merchantType = merchantType;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
