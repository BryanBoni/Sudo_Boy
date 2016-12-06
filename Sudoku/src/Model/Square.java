package Model;

/**
 *
 * @author Robin
 */
public class Square extends Group
{
    /**
     * 
     * @param groupNumber 
     */
    public Square(int groupNumber)
    {
        super(groupNumber);
    }
    
    /**
     * adds to his group the gridSquare cell and set himself has the cell's square
     * @param cell
     */
    @Override
    public void addGridSquare(GridSquare cell)
    {
        cell.setSquare(this);
        this.gridSquares.add(cell);
    }    
}
