package Model;

/**
 *
 * @author Robin
 */
public class Column extends Group
{
    /**
     * 
     * @param groupNumber 
     */
    public Column(int groupNumber)
    {
        super(groupNumber);
    }

     /**
     * adds to his group the gridSquare cell and set himself has the cell's column
     * @param cell
     */
    @Override
    public void addGridSquare(GridSquare cell)
    {
        cell.setColumn(this);
        this.gridSquares.add(cell);
    }
   
}
