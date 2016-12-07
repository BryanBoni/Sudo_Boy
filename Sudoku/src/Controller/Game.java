
package Controller;

import Controller.Cell.Cell;
import Model.Builder;
import Model.GameChecker;
import Model.GridMatrix;
import Model.GridSquare;
import Model.Saver;
import Vue.GroupFx.GroupFxSudoku;
import Vue.Window;
import javafx.scene.control.Alert;

/**
 *
 * @author Robin
 */
public class Game
{
    private GridMatrix board;
    private GameChecker gamecontroller;
    private GridSquare conflicted;
    
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
        if(board != null)
        {
            gamecontroller = new GameChecker(this);
            board.addObserver(gamecontroller);
        }
    }
    
    public void finishGame()
    {
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        message.setTitle("Information");
        message.setHeaderText(null);
        message.setContentText("Vous avez gagné!");
        message.show();
    }
    
    public boolean modifyValueOfCell(int posX, int posY, Integer value)
    {
        if(conflicted != null)
        {
            if(value == null)
            {
                GridSquare conflict = board.changeValue(posX, posY, value);
                if(conflicted.checkValue(conflicted.getValue()) == null)
                {
                    int PosXConflict = conflicted.getLine().getGroupNumber();
                    int PosYConflict = conflicted.getColumn().getGroupNumber();
                    Cell[][] tmp = GroupFxSudoku.getCellTab();
                    tmp[PosXConflict][PosYConflict].normalCell();
                    conflicted = null;   
                }
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            GridSquare conflict = board.changeValue(posX, posY, value);
            if(conflict != null)
            {
                conflicted = conflict;
                int PosXConflict = conflict.getLine().getGroupNumber();
                int PosYConflict = conflict.getColumn().getGroupNumber();
                Cell[][] tmp = GroupFxSudoku.getCellTab();
                tmp[PosXConflict][PosYConflict].redCell();
            }
            return true;
        }
    }

    public void save()
    {
        Saver saver = new Saver();
        saver.save(board);
    }

    public GridMatrix getBoard()
    {
        return board;
    }
    
    
}
