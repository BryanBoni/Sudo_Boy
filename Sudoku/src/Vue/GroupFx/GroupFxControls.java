package Vue.GroupFx;

import Controller.Game;
import Model.BuildFromFile;
import Model.DefaultBuilder;
import Model.GridMatrix;
import Vue.Window;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * This class is used to set the controls component group.
 *
 * @author BryanBoni
 */
public class GroupFxControls extends GroupFx {

    private String selectedOption;
    private Game game;
    //Buttons
    private Button newGame;
    private Button loadGame;

    //radio Buttons
    private ToggleGroup newGameOptions;

    private RadioButton empty;
    private RadioButton easy;
    private RadioButton average;
    private RadioButton hard;
    private RadioButton fromFile;

    public GroupFxControls(int posX, int posY, int width, int height) {
        super(posX, posY, height, width);

        Rectangle controlsPanel = new Rectangle(width, height);

        //controlsPanel.setTranslateX(0);
        //controlsPanel.setTranslateY(0);
        controlsPanel.setStrokeWidth(2);
        controlsPanel.setStroke(Color.GOLD);
        controlsPanel.setFill(Color.TRANSPARENT);
        this.getChildren().add(controlsPanel);

        newGame = new Button("Nouvelle Partie");
        newGame.setAlignment(Pos.CENTER);
        newGame.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        newGame.setTranslateX(10);
        newGame.setTranslateY(10);
        
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Nouvelle Partie.");
                
                String option = getOption();
                if(option.equals("Vide"))
                    game = new Game(new DefaultBuilder());
                if(option.equals("Charger Fichier"))
                {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Choose Game File");
                    String path = fileChooser.showOpenDialog(null).getPath();
                    if(path != null)
                        game = new Game(new BuildFromFile(path));
                }
                GridMatrix board = game.getBoard();
                Window.getgSudoku().setCellTableForRedraw(board);
                Window.getgSudoku().redraw();
            }
        });
        this.getChildren().add(newGame);

        loadGame = new Button("Charger Partie");
        loadGame.setAlignment(Pos.CENTER);
        loadGame.setFont(Font.font("Courier New", FontWeight.BOLD, 20));
        loadGame.setTranslateX(width / 2 + 20);
        loadGame.setTranslateY(10);
        loadGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Charger Partie.");

                game = new Game();
                GridMatrix board = game.getBoard();
                Window.getgSudoku().setCellTableForRedraw(board);
                Window.getgSudoku().redraw();

            }
        });
        this.getChildren().add(loadGame);

        Text radioText = new Text("Mode de la nouvelle partie :");
        radioText.setFont(Font.font("Courier", FontWeight.BOLD, 24));
        radioText.setFill(Color.WHITE);
        radioText.setStroke(Color.BLACK);
        radioText.setTranslateX(10);
        radioText.setTranslateY(100);
        this.getChildren().add(radioText);

        newGameOptions = new ToggleGroup();

        empty = new RadioButton("Vide");
        empty.setUserData("Vide");
        empty.setToggleGroup(newGameOptions);
        empty.setTranslateX(20);
        empty.setTranslateY(150);
        this.getChildren().add(empty);

        easy = new RadioButton("Facile");
        easy.setUserData("Facile");        
        easy.setToggleGroup(newGameOptions);
        easy.setTranslateX(20);
        easy.setTranslateY(120);
        this.getChildren().add(easy);

        average = new RadioButton("Moyenne");
        average.setUserData("Moyenne");        
        average.setToggleGroup(newGameOptions);
        average.setTranslateX(120);
        average.setTranslateY(120);
        this.getChildren().add(average);

        hard = new RadioButton("Difficile");
        hard.setUserData("Difficile");
        hard.setToggleGroup(newGameOptions);
        hard.setTranslateX(220);
        hard.setTranslateY(120);
        this.getChildren().add(hard);

        fromFile = new RadioButton("Charger Fichier");
        fromFile.setUserData("Charger Fichier");
        fromFile.setToggleGroup(newGameOptions);
        fromFile.setTranslateX(120);
        fromFile.setTranslateY(150);
        this.getChildren().add(fromFile);

        this.setTranslateX(posX);
        this.setTranslateY(posY);
        
        newGameOptions.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (newGameOptions.getSelectedToggle() != null) {
                    selectedOption = newGameOptions.getSelectedToggle().getUserData().toString();
             // Do something here with the userData of newly selected radioButton

            }

            } 
        });
    }

    public String getOption()
    {
        return selectedOption;
    }

    public Game getGame()
    {
        return game;
    }
    
    
}
