package Model;

import java.io.Serializable;


/**
 *
 * @author BryanBoni
 */
public class GridSquare implements Serializable{
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
    public GridSquare setValue(Integer newValue)
    {
        GridSquare conflictGrid = null;
        if(!locked)
            if(newValue == null)
                value = newValue;
            else
                if((conflictGrid = checkValue(newValue))== null)
                {
                    value = newValue;
                }
        return conflictGrid;
    }
    
    /**
     * This method returns the gridsquare containing the same value in the line, column or square of this gridsquare. return null if value can't be found
     * @param value
     * @return boolean
     */
    public GridSquare checkValue(int value)
    {
        GridSquare columnGrid, lineGrid, squareGrid;
        if(( columnGrid = column.containsValue(value)) != null && columnGrid != this)
            return columnGrid;
        if(( lineGrid = line.containsValue(value)) != null && columnGrid != this)
            return lineGrid;
        if(( squareGrid = square.containsValue(value)) != null && columnGrid != this)
            return squareGrid;
        return null;
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

    public Column getColumn()
    {
        return column;
    }

    public Line getLine()
    {
        return line;
    }

    public Square getSquare()
    {
        return square;
    }

    
    

    
}
