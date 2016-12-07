
package Controller;

import Model.Builder;
import Model.GameChecker;
import Model.GridMatrix;
import Model.GridSquare;
import Model.Saver;
import javafx.scene.control.Alert;

/**
 *
 * @author Robin
 */
public class Game
{
    private GridMatrix board;
    private GameChecker gamecontroller;

    public Game()
    {
        board = new Saver().load();
        board.deleteObservers();
        gamecontroller = new GameChecker(this);
        board.addObserver(gamecontroller);
    }
    
    public Game(Builder builder)
    {
        board = builder.buildGrid();
        gamecontroller = new GameChecker(this);
        board.addObserver(gamecontroller);
    }
    
    public void finishGame()
    {
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        message.setTitle("Information");
        message.setHeaderText(null);
        message.setContentText("Vous avez gagné!");
        message.show();
    }
    
    public void modifyValueOfCell(int posX, int posY, int value)
    {
        GridSquare conflict = board.changeValue(posX, posY, value);
        if(conflict != null)
        {
            int PosXConflict = conflict.getLine().getGroupNumber();
            int PosYConflict = conflict.getColumn().getGroupNumber();
        }
    }

    public void save()
    {
        Saver saver = new Saver();
        saver.save(board);
    }
    
}
