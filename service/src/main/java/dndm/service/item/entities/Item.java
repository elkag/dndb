package dndm.service.item.entities;

import dndm.service.exposed.models.ItemTypeDto;
import dndm.service.merchant.entities.MerchantType;
import dndm.service.settlement.entities.SettlementType;
import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.Table;

@Table("items")
public class Item {

    @Column("name")
    private String name;
    @Column("cost")
    private Integer cost;
    @Column("weight")
    private Integer weight;
    @Column("itemtype")
    private ItemTypeDto itemType;
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
    @Column("settlementtype")
    private SettlementType settlementType;
    @Column("merchanttype")
    private MerchantType merchantType;

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
