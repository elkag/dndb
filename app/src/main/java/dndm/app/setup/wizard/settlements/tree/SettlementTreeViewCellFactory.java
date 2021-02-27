package dndm.app.setup.wizard.settlements.tree;

import dndm.app.base.SceneManager;
import dndm.app.base.ViewsConfig;
import dndm.app.setup.wizard.settlements.models.SettlementModel;

import java.util.Objects;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

public class SettlementTreeViewCellFactory implements Callback<TreeView<SettlementModel>, TreeCell<SettlementModel>> {

    private static final DataFormat JAVA_FORMAT = new DataFormat("application/x-java-serialized-object");
    private TreeCell<SettlementModel> dropZone;
    private TreeItem<SettlementModel> draggedItem;
    private final SceneManager sceneManager;

    public SettlementTreeViewCellFactory(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }


    @Override
    public TreeCell<SettlementModel> call(TreeView<SettlementModel> treeView) {
        TreeCell<SettlementModel> cell = new TreeCell<>() {
            @Override
            protected void updateItem(SettlementModel item, boolean empty) {
                super.updateItem(item, empty);
                if (isEmpty()) {
                    setGraphic(null);
                    setText(null);
                    return;
                }
                HBox cellBox = new HBox(10);
                cellBox.setAlignment(Pos.CENTER_LEFT);
                Label label = new Label(item.toString());

                Button button = new Button("Go inside the town!");

                button.visibleProperty().bind(
                        Bindings.when(cellBox.hoverProperty())
                                .then(true)
                                .otherwise(false));

                button.setOnAction((ActionEvent event) -> {
                    treeView.getSelectionModel().select(getTreeItem());
                    sceneManager.updateScene(ViewsConfig.MERCHANTS_LIST, treeView.getParent().getScene().getWidth(), treeView.getParent().getScene().getHeight());
                });

                ImageView iv1 = new ImageView();
                iv1.setImage((item.getImage()));

                if(item.getType().equals("Capital")) {
                    cellBox.getChildren().addAll(iv1, label);
                } else {
                    cellBox.getChildren().addAll(iv1, label, button);
                }
                setGraphic(cellBox);
            }
        };

        cell.setOnMousePressed((MouseEvent event) -> event.setDragDetect(true));
        cell.setOnDragDetected((MouseEvent event) -> dragDetected(event, cell, treeView));
        cell.setOnDragOver((DragEvent event) -> dragOver(event, cell, treeView));
        cell.setOnDragDropped((DragEvent event) -> drop(event, cell, treeView));
        cell.setOnDragDone((DragEvent event) -> clearDropLocation());

        return cell;
    }

    private void moveFocus(MouseEvent event, TreeCell<SettlementModel> cell, TreeView<SettlementModel> treeView) {
        System.out.println("Move");
    }
    private void dragDetected(MouseEvent event, TreeCell<SettlementModel> treeCell, TreeView<SettlementModel> treeView) {
        draggedItem = treeCell.getTreeItem();

        // root can't be dragged
        if (draggedItem == null || draggedItem.getParent() == null) return;

        Dragboard db = treeCell.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.put(JAVA_FORMAT, draggedItem.getValue());
        db.setContent(content);

        db.setDragView(draggedItem.getValue().getImage());
        //db.setDragView(treeCell.snapshot(null, null));
        event.consume();
    }

    private void dragOver(DragEvent event, TreeCell<SettlementModel> treeCell, TreeView<SettlementModel> treeView) {
        if (!event.getDragboard().hasContent(JAVA_FORMAT)) return;
        TreeItem<SettlementModel> thisItem = treeCell.getTreeItem();

        // can't drop on itself
        if (draggedItem == null || thisItem == null || thisItem == draggedItem) return;

        // ignore drop of bigger to smaller settlement
        if(thisItem.getValue().getSize().get() >= draggedItem.getValue().getSize().get()) {
            return;
        }
        event.acceptTransferModes(TransferMode.MOVE);
        if (!Objects.equals(dropZone, treeCell)) {
            clearDropLocation();
            this.dropZone = treeCell;
        }

    }

    private void drop(DragEvent event, TreeCell<SettlementModel> treeCell, TreeView<SettlementModel> treeView) {
        Dragboard db = event.getDragboard();

        if (!db.hasContent(JAVA_FORMAT)) return;

        TreeItem<SettlementModel> thisItem = treeCell.getTreeItem();
        TreeItem<SettlementModel> droppedItemParent = draggedItem.getParent();
        // remove from previous location
        droppedItemParent.getChildren().remove(draggedItem);

        thisItem.getChildren().add(draggedItem);
        treeView.getSelectionModel().select(draggedItem);

        event.setDropCompleted(true);
    }

    private void clearDropLocation() {
        if (dropZone != null) dropZone.setStyle("");
    }

}
