package dndm.service.exposed.services;

import dndm.service.common.Service;
import dndm.service.exposed.models.ItemDto;
import dndm.service.exposed.models.MerchantTypeDto;
import dndm.utilities.data.api.entities.Item;

import java.util.List;

public interface ItemService extends Service<Item, ItemDto> {

    List<ItemDto> getByMerchant(MerchantTypeDto merchantTypeDto);
    List<ItemDto> getByMerchantTypeId(long id);
    List<ItemDto> getBySettlementTypeIdAndMerchantTypeId(long settlementTypeId, long merchantTypeId);
}
