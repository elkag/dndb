package dndm.service.exposed.models;

public class MerchantTypeDto {

    private String type;
    private String avatar;

    public String getType() {
        return this.type;
    }

    public MerchantTypeDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public MerchantTypeDto setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }


    @Override
    public String toString() {
        return this.type;
    }
}
