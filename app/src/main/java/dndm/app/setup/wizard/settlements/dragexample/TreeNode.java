package dndm.app.setup.wizard.settlements.dragexample;

import java.util.*;

public class TreeNode<T> extends Observable<TreeNode<T>> implements Iterable<TreeNode<T>> {

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return null;
    }
    T data;
    TreeNode<T> head;
    List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.head = this;
        this.children.add(childNode);
        return childNode;
    }

    public TreeNode<T> getHead() {
        return head;
    }

    public T getData() {
        return data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public T traverse() {
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(this);

        TreeNode<T> currentNode;
        Set<TreeNode<T>> alreadyVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            //System.out.printf("Visited node with value: %s%n", currentNode.getData());
            setValue(currentNode);
            alreadyVisited.add(currentNode);
            queue.addAll(currentNode.getChildren());
            queue.removeAll(alreadyVisited);
            //return currentNode.getData();
        }
        return null;
    }

    static class Operations {
        public static <T> Optional<TreeNode<T>> search(T value, TreeNode<T> start) {
            Queue<TreeNode<T>> queue = new ArrayDeque<>();
            queue.add(start);

            TreeNode<T> currentNode;
            Set<TreeNode<T>> alreadyVisited = new HashSet<>();
            while (!queue.isEmpty()) {
                currentNode = queue.remove();

                currentNode.setValue(currentNode);
                if (currentNode.getData().equals(value)) {
                    return Optional.of(currentNode);
                } else {
                    alreadyVisited.add(currentNode);
                    queue.addAll(currentNode.getChildren());
                    queue.removeAll(alreadyVisited);
                }
            }

            return Optional.empty();
        }

        public static <T> T traverse(TreeNode<T> start) {
            Queue<TreeNode<T>> queue = new ArrayDeque<>();
            queue.add(start);

            TreeNode<T> currentNode;
            Set<TreeNode<T>> alreadyVisited = new HashSet<>();
            while (!queue.isEmpty()) {
                currentNode = queue.remove();
                //System.out.printf("Visited node with value: %s%n", currentNode.getData());
                currentNode.setValue(currentNode);
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getChildren());
                queue.removeAll(alreadyVisited);
                //return currentNode.getData();
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
