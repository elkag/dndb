package dndm.dataprovider.common;

import dndm.dataprovider.settlement.models.SettlementTypeDto;

import java.util.List;

public interface Service<T> {
    List<T> get();
}
