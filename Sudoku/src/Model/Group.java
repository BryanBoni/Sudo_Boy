package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BryanBoni
 */
public abstract class Group {
    protected int groupNumber;
    protected List<GridSquare> gridSquares;
    
    /**
     * 
     * @param groupNumber 
     */
    public Group(int groupNumber) {
        gridSquares = new ArrayList();
        this.groupNumber = groupNumber;
    }
    
    /**
     * Check if value is contained in a gridsquare
     * @param value
     * @return the gridsquare in which the value is found, else null
     */
    public GridSquare containsValue(int value)
    {
        for(GridSquare gs : gridSquares)
        {
            if(gs.getValue() == value)
                return gs;
        }
        return null;
    }

    public int getGroupNumber()
    {
        return groupNumber;
    }
    
    
    /**
     * Add a cell to a group and modify the cell according to the group added
     * @param cell 
     */
    public abstract void addGridSquare(GridSquare cell);

    
}
