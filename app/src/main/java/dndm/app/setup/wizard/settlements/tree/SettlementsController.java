package dndm.app.setup.wizard.settlements.tree;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import dndm.app.base.injection.DependencyInjection;
import dndm.app.setup.wizard.data.SettlementsData;
import dndm.app.setup.wizard.merchants.list.MerchantListController;
import dndm.app.setup.wizard.settlements.mappers.SettlementDtoMapper;
import dndm.app.setup.wizard.settlements.models.SettlementModel;
import dndm.service.exposed.models.SettlementTypeDto;
import dndm.service.exposed.api.SettlementServiceProvider;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SettlementsController extends BaseController {
    @FXML
    public TextField settlementName;
    @FXML
    public ChoiceBox<SettlementTypeDto> settlementSizeChoiceBox;
    @FXML
    public TextField newSettlementName;
    @FXML
    public ChoiceBox<SettlementTypeDto> newSettlementSizeChoiceBox;
    @FXML
    public Button addBtn;
    @FXML
    public Button deleteBtn;
    @FXML
    public Label editSettlementLabel;
    @FXML
    public Label newSettlementLabel;
    @FXML
    public VBox vbox;
    @FXML
    public SettlementTreeView<SettlementModel> settlementsTree;
    @FXML
    public HBox menuBar;

    List<SettlementTypeDto> dbSettlementTypesList;

    ObservableList<TreeItem<SettlementModel>> settlementList;
    SettlementsData settlementData;

    public SettlementsController(SceneManager sceneManager, SettlementsData data) {
        super(sceneManager);
        this.settlementData = data;

        Callback<Class<?>, Object> settlementListControllerFactory = param -> {
            SettlementModel model = getSelectedSettlement();
            return new MerchantListController(sceneManager, model);
        };

        DependencyInjection.addInjectionMethod(
                MerchantListController.class, settlementListControllerFactory
        );
    }

    private SettlementModel getSelectedSettlement() {
        return settlementsTree.getSelectionModel().getSelectedItem().getValue();
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbSettlementTypesList = SettlementServiceProvider.settlementService().get();

        SettlementModel capitalModel = SettlementDtoMapper.getInstance().mapToModel(dbSettlementTypesList.get(0));
        capitalModel.setName("Capital");

        newSettlementSizeChoiceBox.getItems().addAll(dbSettlementTypesList);
        newSettlementSizeChoiceBox.getSelectionModel().select(0);
        newSettlementLabel.prefWidthProperty().bind(vbox.widthProperty());

        createSettlementsTree(capitalModel);
        HBox.setHgrow(settlementsTree, Priority.ALWAYS);
        editSettlementLabel.prefWidthProperty().bind(vbox.widthProperty());



    }

    @FXML
    protected void addTreeViewItem() {
        SettlementModel model = SettlementDtoMapper.getInstance().mapToModel(newSettlementSizeChoiceBox.getSelectionModel().selectedItemProperty().get());
        model.setName(newSettlementName.textProperty().get());

        TreeItem<SettlementModel> treeItem = new TreeItem<>(model);
        settlementsTree.getSelectionModel().getSelectedItem().getChildren().add(treeItem);
        settlementsTree.refresh();
        settlementsTree.getSelectionModel().getSelectedItem().setExpanded(true);
        settlementData.addSettlement(model);
    }

    @FXML
    protected void editTreeViewItem() {
        if(settlementSizeChoiceBox.getSelectionModel().selectedItemProperty().get() == null) {
            return;
        }
        final SettlementModel currentModel = settlementsTree.getSelectionModel().getSelectedItem().getValue()
                .setName(settlementName.textProperty().get());
        SettlementModel model = SettlementDtoMapper.getInstance().mapToModel(
                settlementSizeChoiceBox.getSelectionModel().selectedItemProperty().get(),
                currentModel);
        settlementsTree.getSelectionModel().getSelectedItem().setValue(model);
        settlementsTree.refresh();
        settlementName.requestFocus();
        updateAddSettlementForm(settlementsTree.getSelectionModel().getSelectedItem());
    }

    @FXML
    protected void onDelete() {
        TreeItem<SettlementModel> toRemove = settlementsTree.getSelectionModel().getSelectedItem();
        if(toRemove.equals(settlementsTree.getRoot())) {
            return;
        }
        toRemove.getParent().getChildren().remove(toRemove);
        //settlements.remove(toRemove.getValue());
        settlementData.removeSettlement(toRemove.getValue());
    }


    private void createSettlementsTree(SettlementModel root) {

        TreeItem<SettlementModel> rootItem = new TreeItem<> (root, new ImageView(root.getImage()));
        rootItem.setExpanded(true);

        settlementsTree.getSelectionModel()
                .selectedItemProperty()
                .addListener(this::selectHandler);

        settlementsTree.setRoot(rootItem);

        this.settlementList = settlementsTree.getRoot().getChildren();
        settlementsTree.setCellFactory(new SettlementTreeViewCellFactory(sceneManager));
        settlementsTree.getSelectionModel().select(0);
        deleteBtn.setDisable(true);
        settlementsTree.setFocusTraversable(false);

    }

    private void selectHandler(ObservableValue<? extends TreeItem<SettlementModel>> observable,
                               TreeItem<SettlementModel> oldValue,
                               TreeItem<SettlementModel> newValue) {

        updateAddSettlementForm(newValue);
        updateEditSettlementForm(newValue);

        settlementName.requestFocus();

    }

    private void updateEditSettlementForm(TreeItem<SettlementModel> selectedTreeItem) {
        // Set [EDIT] form choiceBox' values
        TreeItem<SettlementModel> parent = selectedTreeItem.getParent();

        // In case it is the root node, i.e. the Capital
        if(parent == null) {
            parent = selectedTreeItem;
        }
        TreeItem<SettlementModel> finalParent = parent;

        int childrenMaxSizeType;
        if(selectedTreeItem.isLeaf()){
            childrenMaxSizeType = dbSettlementTypesList.get(dbSettlementTypesList.size()-1).getSize() + 1;
        } else {
            childrenMaxSizeType = selectedTreeItem.getChildren().stream()
                    .map(TreeItem::getValue)
                    .max(Comparator.comparingInt(s -> s.getSize().get()))
                    .orElse(selectedTreeItem.getValue()).getSize().get();
        }

        List<SettlementTypeDto> current = dbSettlementTypesList.stream()
                .filter(s -> s.getSize() > finalParent.getValue().getSize().getValue() && s.getSize() < childrenMaxSizeType)
                .collect(Collectors.toList());

        settlementSizeChoiceBox.setItems(FXCollections.observableArrayList(current));

        settlementName.setText(selectedTreeItem.getValue().nameProperty().get());

        final boolean isTheCapital = settlementsTree.getRoot().equals(selectedTreeItem);
        final boolean isTheSmallestSettlement = selectedTreeItem.getValue().getSize().get() == dbSettlementTypesList.size();
        deleteBtn.setDisable(isTheCapital);
        if (isTheCapital || isTheSmallestSettlement) {
            settlementSizeChoiceBox.setDisable(true);
            settlementSizeChoiceBox.getSelectionModel().select(getSettlementTypeDto(selectedTreeItem.getValue()));
        } else {
            settlementSizeChoiceBox.setDisable(false);
            SettlementTypeDto selected = getSettlementTypeDto(selectedTreeItem.getValue());
            settlementSizeChoiceBox.getSelectionModel().select(selected);
        }


        settlementName.requestFocus();
    }

    private void updateAddSettlementForm(TreeItem<SettlementModel> selectedTreeItem) {
        List<SettlementTypeDto> updated = dbSettlementTypesList.stream()
                .filter(s -> s.getSize() > selectedTreeItem.getValue().getSize().getValue())
                .collect(Collectors.toList());

        newSettlementSizeChoiceBox.getItems().clear();
        newSettlementSizeChoiceBox.getItems().addAll(updated);

        if (updated.size() <= 0) {
            disableAddSettlementForm(true);
        } else {
            disableAddSettlementForm(false);
            newSettlementSizeChoiceBox.getSelectionModel().select(0);
        }
    }

    private void disableAddSettlementForm(boolean disabled){
        newSettlementName.setDisable(disabled);
        newSettlementSizeChoiceBox.setDisable(disabled);
        addBtn.setDisable(disabled);
    }

    private SettlementTypeDto getSettlementTypeDto(SettlementModel model){
        return dbSettlementTypesList.stream()
                .filter(s -> s.getSize().equals(model.getSize().getValue()))
                .findAny()
                .orElse(null);
    }
}

