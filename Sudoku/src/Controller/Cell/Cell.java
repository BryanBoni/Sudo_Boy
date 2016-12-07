package Controller.Cell;

import javafx.scene.Parent;
import javafx.scene.paint.Color;

/**
 * This class represent a cell of our grid, which contain a number between 1 to
 * 9 or nothing, on the window, link the view and the Model package.
 *
 * @author BryanBoni
 */
public abstract class Cell extends Parent {
    
    //Value of the cell
    private int value;

    //Coordinate on the scene.
    private final int posX;
    private final int posY;

    //coordinate of the Grid matrix.
    public int numX;
    public int numY;

    /**
     * Constructor for a cell.
     *
     * @param posX
     * @param posY
     * @param numX
     * @param numY
     */
    public Cell(int posX, int posY, int numX, int numY) {
        this.posX = posX;
        this.posY = posY;
        this.numX = numX;
        this.numY = numY;
    }

    /**
     *
     * @return
     */
    public int getPosX() {
        return posX;
    }

    /**
     *
     * @return
     */
    public int getPosY() {
        return posY;
    }

    /**
     * 
     * @return 
     */
    public int getNumX() {
        return numX;
    }

    /**
     * 
     * @return 
     */
    public int getNumY() {
        return numY;
    }

    /**
     * 
     * @return 
     */
    public abstract int getValue();

    /**
     * 
     * @param value 
     */
    public abstract void setValue(int value);

    /**
     * Color the cell border in red.
     */
    public abstract void redCell();
    
    /**
     * Color the cell border in Black.
     */
    public abstract void normalCell();
    
}
