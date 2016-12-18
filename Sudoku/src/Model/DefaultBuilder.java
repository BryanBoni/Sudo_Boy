package Model;

/**
 *
 * @author Robin
 */
public class DefaultBuilder implements Builder
{
    private static int numbers[] = {5,6,0,8,4,7,0,0,0,3,0,9,0,0,0,6,0,0,0,0,8,0,0,0,0,0,0,0,1,0,0,8,0,0,4,0,7,9,0,6,0,2,0,1,8,0,5,0,0,3,0,0,9,0,0,0,0,0,0,0,2,0,0,0,0,6,0,0,0,8,0,7,0,0,0,3,1,6,0,5,9};
    
    /**
     *  Default constructor
     */
    public DefaultBuilder()
    {
    }
    /**
     * Construct a default GridMatrix. 
     * @return The generated GridMatrix
     */
    @Override
    public GridMatrix buildGrid()
    {
        GridMatrix grid = new GridMatrix();
        for(int posX = 0 ; posX < 9; posX++)
            for(int posY = 0; posY < 9 ; posY++)
            {
                GridSquare tmp = new GridSquare(grid);
                grid.getCols()[posY].addGridSquare(tmp);
                grid.getLines()[posX].addGridSquare(tmp);
                int posGrid = (posY - (posY % 3)) + (posX - (posX % 3)) / 3;
                grid.getSquares()[posGrid].addGridSquare(tmp);
                if(numbers[posX*9+posY] != 0)
                {
                    tmp.setValue(numbers[posX*9+posY]);
                    tmp.setLocked(true);
                }
                else
                {
                    tmp.setLocked(false);
                }
                grid.getGrid()[posX][posY] = tmp;
            }
        
        return grid;
    }
    
}
