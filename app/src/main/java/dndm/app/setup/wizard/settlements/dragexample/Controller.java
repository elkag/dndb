package dndm.app.setup.wizard.settlements.dragexample;

import dndm.app.base.BaseController;
import dndm.app.base.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller extends BaseController {

    private final List<TreeNode<Circle>> trees = new ArrayList<>();
    private final Observer<TreeNode<Circle>> observer = o -> System.out.println(o.getData());
    @FXML
    Pane pane;

    Line line;

    public Controller(final SceneManager sceneManager) {
        super(sceneManager);
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeNode<Circle> tree1 = new TreeNode<>(new Circle(65, 87, 30));
        TreeNode<Circle> tree2 = new TreeNode<>(new Circle(90, 300, 30));
        TreeNode<Circle> tree3= new TreeNode<>(new Circle(120, 400, 30));
        tree1.addObserver(observer);
        TreeNode<Circle> child1 = tree1.addChild(new Circle(1, 300, 30));
        TreeNode<Circle> child2 = tree1.addChild(new Circle(2, 300, 30));
        TreeNode<Circle> child3 = tree1.addChild(new Circle(3, 300, 30));

        TreeNode<Circle> child11 = child1.addChild(new Circle(11, 300, 30));
        TreeNode<Circle> child12 = child1.addChild(new Circle(12, 300, 30));
        TreeNode<Circle> child13 = child1.addChild(new Circle(13, 300, 30));

        TreeNode<Circle> child21 = child2.addChild(new Circle(21, 300, 30));
        TreeNode<Circle> child22 = child2.addChild(new Circle(22, 300, 30));
        TreeNode<Circle> child23 = child2.addChild(new Circle(23, 300, 30));

        TreeNode<Circle> child33 = child21.addChild(new Circle(23, 300, 30));

        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);



        tree1.traverse();

        //line = drawLine(first.getCenterX(), second.getCenterX(), first.getCenterY(), second.getCenterY());
        //pane.getChildren().add(line);
        List<Circle> nodes = trees.stream().map(TreeNode::getData).collect(Collectors.toList());
        pane.getChildren().addAll(nodes);

        checkShapeIntersection(nodes.get(nodes.size() - 1));
    }


    private Line drawLine(double startx, double starty, double endx, double endy) {
        final Line line = new Line();
        line.setStartX(startx);
        line.setStartY(starty);
        line.setEndX(endx);
        line.setEndY(endy);
        return line;
    }

    private void checkShapeIntersection(Shape block) {
        boolean collisionDetected = false;
        List<Circle> nodes = trees.stream().map(TreeNode::getData).collect(Collectors.toList());
        for (Shape static_bloc : nodes) {
            if (static_bloc != block) {
                static_bloc.setFill(Color.GREEN);

                Shape intersect = Shape.intersect(block, static_bloc);
                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    collisionDetected = true;
                }
            }
        }

        if (collisionDetected) {
            block.setFill(Color.BLUE);
        } else {
            block.setFill(Color.GREEN);
        }
    }


}
