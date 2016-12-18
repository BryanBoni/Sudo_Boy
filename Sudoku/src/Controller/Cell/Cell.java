package Controller.Cell;

import javafx.scene.Parent;

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
     * @param posX graphical position in X.
     * @param posY graphical position in Y.
     * @param numX location in X of the cell in the cellTab.
     * @param numY location in Y of the cell in the cellTab.
     */
    public Cell(int posX, int posY, int numX, int numY) {
        this.posX = posX;
        this.posY = posY;
        this.numX = numX;
        this.numY = numY;
    }

    /**
     *
     * @return position in X
     */
    public int getPosX() {
        return posX;
    }

    /**
     *
     * @return position in Y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * 
     * @return location in X in the cellTab.
     */
    public int getNumX() {
        return numX;
    }

    /**
     * 
     * @return location in Y in the cellTab.
     */
    public int getNumY() {
        return numY;
    }

    /**
     * an abstract class.
     * 
     * @return the value of the cell.
     */
    public abstract int getValue();

    /**
     * an abstract class.
     * 
     * @param value the new value of the cell
     */
    public abstract void setValue(int value);


    /**
     * an abstract class.
     * 
     * Color the cell border in red.
     */
    public abstract void redCell();
    
    /**
     * an abstract class.
     * 
     * Color the cell border in Black.
     */
    public abstract void normalCell();
    
}
