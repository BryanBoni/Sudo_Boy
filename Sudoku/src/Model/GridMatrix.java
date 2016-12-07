package Model;

import java.io.Serializable;
import java.util.Observable;

/**
 *
 * @author Robin
 */
public class GridMatrix extends Observable implements Serializable{
    
    private Column cols[];
    private Line lines[];
    private Square squares[];
    private GridSquare grid[][];
    
    /**
     * 
     */
    public GridMatrix() {
        super();
        cols = new Column[9];
        lines = new Line[9];
        squares = new Square[9];
        grid = new GridSquare[9][9];
        
        for(int i = 0 ; i <= 8 ; i++)
        {
            cols[i] = new Column(i);
            lines[i] = new Line(i);
            squares[i] = new Square(i);
        }
    }
    /**
     * This method change the value of the selected cell. Succeeding in changing
     * will notify the observers of this object.
     * @param x Line number
     * @param y Column number
     * @param value Value to put in selected cell
     * @return 
     */
    public GridSquare changeValue(int x, int y, Integer value)
    {
        GridSquare conflictGrid;
        if((conflictGrid = grid[x][y].setValue(value)) == null)
        {
            setChanged();
            notifyObservers();
        }
        return conflictGrid;
    }
    /**
     * 
     * @return Array of Column
     */
    public Column[] getCols()
    {
        return cols;
    }

    /**
     * 
     * @return Array of Line
     */
    public Line[] getLines()
    {
        return lines;
    }

    /**
     * 
     * @return Array of Square 
     */
    public Square[] getSquares()
    {
        return squares;
    }

    /**
     * 
     * @return Matrice of gridsquare. 
     */
    public GridSquare[][] getGrid()
    {
        return grid;
    }
    
    
    
    
    
}
