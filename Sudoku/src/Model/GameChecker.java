package Model;

import Controller.Game;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Robin
 */
public class GameChecker implements Observer
{
    Game game;
    
    /**
     * Default constructor
     * @param game
     */
    public GameChecker(Game game)
    {
        this.game = game;
    }
    
    
    /**
     * Check if the group grp is completed. This means the values from 1 to 9 can be found and there's no value 0;
     * @param grp
     * @return true is the group is completed, else false
     */
    private boolean groupCompleted(Group grp)
    {
        if(grp.containsValue(0,null) != null)
            return false;
        for(int i = 1; i <= 9; i++)
            if(grp.containsValue(i,null) == null)
                return false;
        return true;
    }
    
    /**
     * Check if the grid is completed. This means all the groups of the grid are completed
     * @param grid
     * @return true if the grid is completed, else false
     */
    private boolean gridCompleted(GridMatrix grid)
    {
        for(int i = 0; i < 9 ; i++)
        {
            if(! groupCompleted( grid.getCols()[i]))
                return false;
            if(! groupCompleted( grid.getLines()[i]))
                return false;
            if(! groupCompleted( grid.getSquares()[i]))
                return false;
        }
        return true;
    }

    /**
     * Called when notified by the observables objects. Check the completion of the grid
     * @param o the observable that notified the observers
     * @param arg a specified object
     */
    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof GridMatrix)
        {
            if(gridCompleted((GridMatrix) o))
            {
                game.finishGame();
            }

        }
    }
    
}
