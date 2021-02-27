package dndm.app.setup.wizard.data;

import dndm.app.setup.wizard.settlements.models.SettlementModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

public class SettlementsData {

    private final ObservableSet<SettlementModel> settlements = FXCollections.observableSet();

    public ObservableSet<SettlementModel> getSettlements() {
        return settlements;
    }

    public void addSettlement(final SettlementModel settlementModel){
        settlements.add(settlementModel);
    }

    public void removeSettlement(final SettlementModel settlementModel){
        settlements.remove(settlementModel);
    }
}
