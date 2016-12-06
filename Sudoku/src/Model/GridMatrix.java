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
        
        for(int i = 1 ; i <= 9 ; i++)
        {
            cols[i - 1] = new Column(i);
            lines[i - 1] = new Line(i);
            squares[i - 1] = new Square(i);
        }
    }
    /**
     * This method change the value of the selected cell. Succeeding in changing
     * will notify the observers of this object.
     * @param x Line number
     * @param y Column number
     * @param value Value to put in selected cell
     */
    public void changeValue(int x, int y, int value)
    {
        if(grid[x][y].setValue(value))
        {
            setChanged();
            notifyObservers();
        }
        
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
