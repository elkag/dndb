package dndm.service.merchant.services;

import dndm.service.common.Service;
import dndm.utilities.data.api.entities.MerchantType;
import dndm.service.exposed.models.MerchantTypeDto;
import dndm.utilities.data.api.repositories.MerchantTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MerchantServiceImpl implements Service<MerchantType, MerchantTypeDto> {

    private final MerchantTypeRepository repository;

    public MerchantServiceImpl(MerchantTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MerchantTypeDto> getAll() {
        List<MerchantType> merchants = repository.getAll();

        return merchants.stream()
                .map(e -> MerchantTypeMapper.Instance().mapToModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public void save(MerchantTypeDto dto) {

    }
}
