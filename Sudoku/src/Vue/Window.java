package Vue;

import Vue.GroupFx.*;
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
    
    public GroupFxSudoku gSudoku;

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
        scene = new Scene(root, 1000, 600, Color.rgb(42, 42, 42, 1.0));
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        root.getStyleClass().add("root");

        //Set the sudoku object.
        gSudoku = new GroupFxSudoku(-245, -50, 0, 0);
        root.getChildren().add(gSudoku);
        
        
        //Set the Stats objects
        Rectangle statsPanel = new Rectangle(460, 250);
        statsPanel.setTranslateX(230);
        statsPanel.setTranslateY(-150);
        statsPanel.setStrokeWidth(2);
        statsPanel.setStroke(Color.GOLD);
        statsPanel.setFill(Color.TRANSPARENT);
        root.getChildren().add(statsPanel);
        
        

        //Set the controls objects
        //Set Timer
        primaryStage.setTitle("Sudoku v0.0.1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

}
