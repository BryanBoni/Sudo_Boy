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
    
    //groups components variables
    public static GroupFxSudoku gSudoku;
    public static GroupFxControls gControls;
    public static GroupFxStatistics gStats;

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
        
       // gSudoku.redraw();
        
        //Set the Stats objects
        Rectangle statsPanel = new Rectangle(460, 250);
        statsPanel.setTranslateX(230);
        statsPanel.setTranslateY(-153);
        statsPanel.setStrokeWidth(2);
        statsPanel.setStroke(Color.GOLD);
        statsPanel.setFill(Color.TRANSPARENT);
        root.getChildren().add(statsPanel);
        

        //Set the controls objects
        gControls = new GroupFxControls(230, 140, 460, 250);
        root.getChildren().add(gControls);
        
        
        //Set Timer
        primaryStage.setTitle("Sudoku v0.0.1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

}
