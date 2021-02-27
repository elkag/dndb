package dndm.app.setup.wizard.settlements.tree;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.util.ArrayDeque;
import java.util.Iterator;

public class SettlementTreeView<T> extends TreeView<T> implements Iterable<TreeItem<T>> {


    @Override
    public Iterator<TreeItem<T>> iterator() {

        return new TreeItemIterator<T>(getRoot());
    }

    /**
     * Iterate over items in a tree.
     * The tree should not be modified while this iterator is being used.
     *
     * @param <T> the type of items stored in the tree.
     */
    static class TreeItemIterator<T> implements Iterator<TreeItem<T>> {
        private final ArrayDeque<TreeItem<T>> stack = new ArrayDeque<>();

        public TreeItemIterator(TreeItem<T> root) {
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public TreeItem<T> next() {
            TreeItem<T> nextItem = stack.pop();
            nextItem.getChildren().forEach(stack::push);

            return nextItem;
        }
    }
}
