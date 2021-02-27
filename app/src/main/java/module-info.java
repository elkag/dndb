module dndm.app {

    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    requires dndm.utilities;
    requires dndm.service;

    opens dndm.app to javafx.fxml;
    opens dndm.app.common.header to javafx.fxml;
    opens dndm.app.load.campaign to javafx.fxml;
    opens dndm.app.setup.wizard.settlements.tree to javafx.fxml;
    opens dndm.app.setup.wizard.settlements.list to javafx.fxml;
    opens dndm.app.setup.wizard.merchants.list to javafx.fxml;
    opens dndm.app.setup.wizard.items.list to javafx.fxml;

    exports dndm.app;
    exports dndm.app.base;
    exports dndm.app.initial.screen;
    exports dndm.app.setup.wizard.data;
    exports dndm.app.setup.wizard.settlements.mappers;
    exports dndm.app.setup.wizard.settlements.models;
    exports dndm.app.setup.wizard.settlements.tree;
    exports dndm.app.setup.wizard.settlements.list;
    exports dndm.app.setup.wizard.merchants.list;
    exports dndm.app.setup.wizard.merchants.merchant;
    exports dndm.app.setup.wizard.merchants.models;
    exports dndm.app.setup.wizard.items.list;
    exports dndm.app.setup.wizard.items.item;
    exports dndm.app.setup.wizard.items.models;
}