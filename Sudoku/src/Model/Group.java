package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BryanBoni
 */
public abstract class Group implements Serializable {
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
     * @param curr
     * @return the gridsquare in which the value is found, else null
     */
    public GridSquare containsValue(int value, GridSquare curr)
    {
        for(GridSquare gs : gridSquares)
        {
            if(gs.getValue() == value && gs != curr)
                return gs;
        }
        return null;
    }
    /**
     * 
     * @return 
     */
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
