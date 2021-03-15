package dndm.service.item.services;

import dndm.service.exposed.models.ItemDto;
import dndm.service.exposed.models.MerchantTypeDto;
import dndm.service.exposed.services.ItemService;
import dndm.service.merchant.services.MerchantTypeMapper;
import dndm.utilities.data.api.entities.Item;
import dndm.utilities.data.api.entities.MerchantType;
import dndm.utilities.data.api.repositories.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {

    protected ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ItemDto> getAll() {
        List<Item> items = repository.fetchAll();
        if(items == null) return List.of();
        return items.stream()
                .map(e -> ItemMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    public List<ItemDto> getByMerchant(MerchantTypeDto merchantTypeDto) {
        MerchantType merchantType = MerchantTypeMapper.Instance().mapToEntity(merchantTypeDto);
        List<Item> items = repository.fetchByMerchantTypeId(merchantType.getId());
        if(items == null) return List.of();
        return items.stream()
                .map(e -> ItemMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }
    public List<ItemDto> getByMerchantTypeId(long id) {

        List<Item> items = repository.fetchByMerchantTypeId(id);
        if(items == null) return List.of();
        return items.stream()
                .map(e -> ItemMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    public List<ItemDto> getBySettlementTypeIdAndMerchantTypeId(long settlementTypeId, long merchantTypeId) {

        List<Item> items = repository.fetchBySettlementTypeIdAndMerchantTypeId(settlementTypeId, merchantTypeId);
        if(items == null) return List.of();
        return items.stream()
                .map(e -> ItemMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }
    @Override
    public void save(ItemDto dto) {
        Item item = ItemMapper.Instance().mapToEntity(dto);
        repository.save(item);
    }
}
