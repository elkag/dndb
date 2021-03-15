package dndm.service.exposed.models;

import dndm.service.common.Dto;

public class MerchantTypeDto implements Dto {

    private Long id;
    private String type;
    private String avatar;
    public Long getId() {
        return id;
    }

    public MerchantTypeDto setId(Long id) {
        this.id = id;
        return this;
    }
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
