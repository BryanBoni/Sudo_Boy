package Controller.Cell;

import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class represent a cell of our grid, which contain a number between 1 to
 * 9 or nothing, on the window, link the view and the Model package, We can
 * change the value on this one.
 *
 *
 * @author BryanBoni
 */
public class CellPlayable extends Cell {

    private int value;

    //Graphics varialble of the cell.
   // private final Rectangle gCell;
    private final TextField gValue;

    /**
     * Constructor for an empty and playable cell.
     *
     * @param posX
     * @param posY
     * @param numX
     * @param numY
     */
    public CellPlayable(int posX, int posY, int numX, int numY) {
        super(posX, posY, numX, numY);

       /* gCell = new Rectangle(46, 46, Color.WHITE);
        gCell.setArcHeight(5);
        gCell.setArcWidth(5);
        this.getChildren().add(gCell);*/

        gValue = new TextField();
        gValue.setMaxSize(46, 46);
        gValue.setMinSize(46, 46);
        this.getChildren().add(gValue);

        this.setTranslateX(posX - 350);
        this.setTranslateY(posY - 250);
    }

    /**
     * Used to set the value of a playable cell.
     *
     * @param value
     */
    public void setValue(Integer value) {

        if (value != null) {
            if (value < 1 || value > 9) {
                System.out.println("Valeur incorrect !");

            } else if (this.value == value) {
                System.out.println("Valeur déjà initialisé");
            } else {
                this.value = value;
            }
        }

    }

    /**
     *
     * @return
     */
    public int getValue() {
        return value;
    }
}
