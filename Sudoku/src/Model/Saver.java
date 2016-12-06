package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Robin
 */
public class Saver
{
    private String path = "./sudoku.save";    
    /**
     * 
     */
    public Saver()
    {    
    }
    
    /**
     * Serialize a gridMatrix into the file path
     * @param grid the gridMatrix to be serialized
     */
    public void save(GridMatrix grid)
    {
        try{
            FileOutputStream filestream = new FileOutputStream(path);
            ObjectOutputStream stream = new ObjectOutputStream(filestream);
            stream.writeObject(grid);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    /**
     * Load a serialized GridMatrix from the file path
     * @return GridMatrix read in the file.
     */
    public GridMatrix load()
    {
        try{
            FileInputStream filestream = new FileInputStream(path);
            ObjectInputStream stream = new ObjectInputStream(filestream);
            return (GridMatrix) stream.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.println(e);
        }  
        return null;
    }

    /**
     * 
     * @return 
     */
    public String getPath()
    {
        return path;
    }

    /**
     * 
     * @param path 
     */
    public void setPath(String path)
    {
        this.path = path;
    }
    
    
}
