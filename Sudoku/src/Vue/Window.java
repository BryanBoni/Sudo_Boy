package Vue;

import Controller.Cell.Cell;
import Controller.Cell.CellFix;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author BryanBoni
 */
public class Window extends Application {

    private StackPane root;
    private Scene scene;

    //private Cell[][] grid;
    @Override
    public void start(Stage primaryStage) {
        initComponents(primaryStage);
        primaryStage.show();
    }

    /**
     * Initialise all fix components of our sudoku
     *
     * @param primaryStage
     */
    private void initComponents(Stage primaryStage) {
        root = new StackPane();
        scene = new Scene(root, 800, 600, Color.rgb(42, 42, 42, 1.0));

        //grid = new Cell[8][8];
                Rectangle rect;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rect = new Rectangle(150, 150);
                rect.setTranslateX(150 * i - 300);
                rect.setTranslateY(150 * j - 200);
                rect.setStrokeWidth(5);
                rect.setStroke(Color.BLUE);
                rect.setFill(Color.TRANSPARENT);
                root.getChildren().add(rect);
            }
        }
        Cell temp;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                //grid[y][x] = temp;  
                temp = new CellFix(1, x * 50, y * 50, x, y);
                root.getChildren().add(temp);
            }
        }

        primaryStage.setTitle("Sudoku v0.0.1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

}
