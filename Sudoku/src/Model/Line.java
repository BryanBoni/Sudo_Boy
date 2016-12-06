package Model;

/**
 *
 * @author Robin
 */
public class Line extends Group
{
    /**
     * 
     * @param groupNumber 
     */
    public Line(int groupNumber)
    {
        super(groupNumber);
    }
    
     /**
     * adds to his group the gridSquare cell and set himself has the cell's line
     * @param cell
     */
    @Override
    public void addGridSquare(GridSquare cell)
    {
        cell.setLine(this);
        this.gridSquares.add(cell);
    }
    
}
