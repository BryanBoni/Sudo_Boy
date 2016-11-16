package Model;

/**
 *
 * @author BryanBoni
 */
public abstract class Group {

    public Group() {
    }
    
    /**
     * 
     * @param value
     * @return 
     */
    public abstract GridSquare containsValue(int value);
}
