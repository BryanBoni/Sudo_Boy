package Vue;

import Vue.GroupFx.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author BryanBoni
 */
public class Window extends Application {

    private StackPane root;
    private Scene scene;
    public static Text gChrono;

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
        gStats = new GroupFxStatistics(240, -153, 460, 250);
        root.getChildren().add(gStats);

        //Set the controls objects
        gControls = new GroupFxControls(240, 120, 460, 250);
        root.getChildren().add(gControls);

        //Set chrono
        gChrono = new Text("00 : 00 : 00");
        gChrono.setFont(Font.font("Courier new", FontWeight.BOLD, 48));
        gChrono.setTranslateX(-245);
        gChrono.setTranslateY(230);
        gChrono.setFill(Color.WHITE);
        root.getChildren().add(gChrono);

        //Test zone
        //Stage creation
        primaryStage.setTitle("Sudoku v0.0.1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent we) {
                if (Window.getgControls().getGame() != null) {
                    Window.getgControls().getGame().save();
                }
            }
        });
    }

    public static GroupFxSudoku getgSudoku() {
        return gSudoku;
    }

    public static GroupFxControls getgControls() {
        return gControls;
    }

    public static GroupFxStatistics getgStats() {
        return gStats;
    }

}
