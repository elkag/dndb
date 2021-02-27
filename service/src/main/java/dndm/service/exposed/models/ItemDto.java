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

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getCost() {
        return cost;
    }

    public ItemDto setCost(int cost) {
        this.cost = cost;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public ItemDto setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public ItemTypeDto getItemType() {
        return itemType;
    }

    public ItemDto setItemType(ItemTypeDto itemType) {
        this.itemType = itemType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getDamageType() {
        return damageType;
    }

    public ItemDto setDamageType(int damageType) {
        this.damageType = damageType;
        return this;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public ItemDto setDamageValue(int damageValue) {
        this.damageValue = damageValue;
        return this;
    }

    public int getItemRange() {
        return itemRange;
    }

    public ItemDto setItemRange(int itemRange) {
        this.itemRange = itemRange;
        return this;
    }

    public int getArmorType() {
        return armorType;
    }

    public ItemDto setArmorType(int armorType) {
        this.armorType = armorType;
        return this;
    }

    public int getArmorValue() {
        return armorValue;
    }

    public ItemDto setArmorValue(int armorValue) {
        this.armorValue = armorValue;
        return this;
    }

    public int getPotionType() {
        return potionType;
    }

    public ItemDto setPotionType(int potionType) {
        this.potionType = potionType;
        return this;
    }

    public int getPortionValue() {
        return portionValue;
    }

    public ItemDto setPortionValue(int portionValue) {
        this.portionValue = portionValue;
        return this;
    }

    public SettlementTypeDto getSettlementType() {
        return settlementType;
    }

    public ItemDto setSettlementType(SettlementTypeDto settlementType) {
        this.settlementType = settlementType;
        return this;
    }

    public MerchantTypeDto getMerchantType() {
        return merchantType;
    }

    public ItemDto setMerchantType(MerchantTypeDto merchantType) {
        this.merchantType = merchantType;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
