package Model;

 import java.util.Scanner;

/**
 *
 * @author Robin
 */
public class BuildFromFile implements Builder
{
    private String path;
    public BuildFromFile(String path)
    {
        this.path = path;
    }
    @Override
    public GridMatrix buildGrid()
    {
        try{
            Scanner fileStream = new Scanner(path);
            
            GridMatrix grid = new GridMatrix();
            for(int posY = 0 ; posY < 9; posY++)
                for(int posX = 0; posX < 9 ; posX++)
                {
                    GridSquare tmp = new GridSquare(grid);
                    grid.getCols()[posY].addGridSquare(tmp);
                    grid.getLines()[posX].addGridSquare(tmp);
                    int posGrid = (posY - (posY % 3)) + (posX - (posX % 3)) / 3;
                    grid.getSquares()[posGrid].addGridSquare(tmp);
                    int value = fileStream.nextInt();
                    if(value != 0)
                    {
                        tmp.setValue(value);
                        tmp.setLocked(true);
                    }
                    else
                    {
                        tmp.setLocked(false);
                    }
                }

            return grid;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    
}
