package dndm.service.merchant.entities;

import dndm.utilities.db.anotations.Column;
import dndm.utilities.db.anotations.Table;

@Table("merchant_types")
public class MerchantType {

    @Column("type")
    private String type;

    @Column("avatar")
    private String avatar;

    public String getType() {
        return type;
    }

    public MerchantType setType(String type) {
        this.type = type;
        return this;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public MerchantType setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
