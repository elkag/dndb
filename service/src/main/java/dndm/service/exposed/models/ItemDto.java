package dndm.service.exposed.models;

public class ItemDto {

    private String name;
    private Integer cost;
    private Integer weight;
    private ItemTypeDto itemType;
    private String description;
    private Integer damageType;
    private Integer damageValue;
    private Integer itemRange;
    private Integer armorType;
    private Integer armorValue;
    private Integer potionType;
    private Integer portionValue;
    private SettlementTypeDto settlementType;
    private MerchantTypeDto merchantType;

    public String getName() {
        return name;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCost() {
        return cost;
    }

    public ItemDto setCost(Integer cost) {
        this.cost = cost;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public ItemDto setWeight(Integer weight) {
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

    public Integer getDamageType() {
        return damageType;
    }

    public ItemDto setDamageType(Integer damageType) {
        this.damageType = damageType;
        return this;
    }

    public Integer getDamageValue() {
        return damageValue;
    }

    public ItemDto setDamageValue(Integer damageValue) {
        this.damageValue = damageValue;
        return this;
    }

    public Integer getItemRange() {
        return itemRange;
    }

    public ItemDto setItemRange(Integer itemRange) {
        this.itemRange = itemRange;
        return this;
    }

    public Integer getArmorType() {
        return armorType;
    }

    public ItemDto setArmorType(Integer armorType) {
        this.armorType = armorType;
        return this;
    }

    public Integer getArmorValue() {
        return armorValue;
    }

    public ItemDto setArmorValue(Integer armorValue) {
        this.armorValue = armorValue;
        return this;
    }

    public Integer getPotionType() {
        return potionType;
    }

    public ItemDto setPotionType(Integer potionType) {
        this.potionType = potionType;
        return this;
    }

    public Integer getPortionValue() {
        return portionValue;
    }

    public ItemDto setPortionValue(Integer portionValue) {
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
