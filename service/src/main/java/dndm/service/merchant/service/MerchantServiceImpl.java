package dndm.service.merchant.service;

import dndm.service.common.Service;
import dndm.service.common.repository.Repository;
import dndm.service.merchant.entities.MerchantType;
import dndm.service.exposed.models.MerchantTypeDto;

import java.util.List;
import java.util.stream.Collectors;

public class MerchantServiceImpl implements Service<MerchantTypeDto> {

    private final Repository<MerchantType> repository;

    public MerchantServiceImpl(Repository<MerchantType> repository) {
        this.repository = repository;
    }

    @Override
    public List<MerchantTypeDto> get() {
        List<MerchantType> merchants = repository.getAll(MerchantType.class);

        return merchants.stream()
                .map(e -> MerchantTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }
}
