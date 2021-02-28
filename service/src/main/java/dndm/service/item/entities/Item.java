package dndm.service.item.entities;

import dndm.service.merchant.entities.MerchantType;
import dndm.service.settlement.entities.SettlementType;
import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.JoinColumn;
import dndm.utilities.db.anotations.Table;

@Table("items")
public class Item {

    @Column("name")
    private String name;
    @Column("cost")
    private Integer cost;
    @Column("weight")
    private Integer weight;

    @JoinColumn(name = "itemtype", table = "item_types")
    private ItemType itemType;

    @Column("description")
    private String description;
    @Column("damagetype")
    private Integer damageType;
    @Column("damagevalue")
    private Integer damageValue;
    @Column("itemrange")
    private Integer itemRange;

    @Column("armortype")
    private Integer armorType;

    @Column("armorvalue")
    private Integer armorValue;
    @Column("potiontype")
    private Integer potionType;
    @Column("portionvalue")
    private Integer portionValue;

    @JoinColumn(name = "settlementsize", table = "settlement_types")
    private SettlementType settlementType;

    @JoinColumn(name = "merchanttype", table = "merchant_types")
    private MerchantType merchantType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDamageType() {
        return damageType;
    }

    public void setDamageType(Integer damageType) {
        this.damageType = damageType;
    }

    public Integer getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(Integer damageValue) {
        this.damageValue = damageValue;
    }

    public Integer getItemRange() {
        return itemRange;
    }

    public void setItemRange(Integer itemRange) {
        this.itemRange = itemRange;
    }

    public Integer getArmorType() {
        return armorType;
    }

    public void setArmorType(Integer armorType) {
        this.armorType = armorType;
    }

    public Integer getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(Integer armorValue) {
        this.armorValue = armorValue;
    }

    public Integer getPotionType() {
        return potionType;
    }

    public void setPotionType(Integer potionType) {
        this.potionType = potionType;
    }

    public Integer getPortionValue() {
        return portionValue;
    }

    public void setPortionValue(Integer portionValue) {
        this.portionValue = portionValue;
    }

    public SettlementType getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(SettlementType settlementType) {
        this.settlementType = settlementType;
    }

    public MerchantType getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(MerchantType merchantType) {
        this.merchantType = merchantType;
    }
}
