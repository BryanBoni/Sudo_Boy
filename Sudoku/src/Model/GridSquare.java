package Model;


/**
 *
 * @author BryanBoni
 */
public class GridSquare{
    private Integer value;
    private boolean locked;
    
    private Column column;
    private Line line;
    private Square square;
    private GridMatrix grid;
    
    /**
     * 
     * @param grid 
     */
    public GridSquare(GridMatrix grid)
    {
        value = null;
        this.grid = grid;
    }

    /**
     * 
     * @return value or 0 if value is null
     */
    public int getValue()
    {
        return value == null? 0:value;
    }
    
    /**
     * Set the value to newValue only if the method checkValue returns true. the value can't be modified is locked is true
     * @param newValue 
     * @return true if the gridsquare value has been changed to a non-null value, else false
     */
    public boolean setValue(Integer newValue)
    {
        if(!locked)
            if(newValue == null)
                value = newValue;
            else
                if(checkValue(newValue))
                {
                    value = newValue;
                    return true;
                }
        return false;
    }
    
    /**
     * This method returns true if value cannot be found in gridsquares of either the column, line or square
     * @param value
     * @return boolean
     */
    public boolean checkValue(int value)
    {
        if(column.containsValue(value) != null || line.containsValue(value) != null || square.containsValue(value) != null)
            return false;
        return true;
    }

    /**
     * 
     * @param column 
     */
    public void setColumn(Column column)
    {
        this.column = column;
    }

    /**
     * 
     * @param line 
     */
    public void setLine(Line line)
    {
        this.line = line;
    }

    /**
     * 
     * @param square 
     */
    public void setSquare(Square square)
    {
        this.square = square;
    }

    /**
     * 
     * @return 
     */
    public boolean isLocked()
    {
        return locked;
    }

    /**
     * 
     * @param locked 
     */
    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }

    

    
}
