package Controller.Cell;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * This class represent a cell of our grid, which contain a number between 1 to
 * 9 or nothing, on the window, link the view and the Model package, We cannot
 * change the value on this one.
 *
 * @author BryanBoni
 */
public class CellFix extends Cell {

    private int value;

    //graphics variable of the cell.
    private final Rectangle gCell;
    private final Rectangle gCell2;
    private final Text gValue;

    /**
     * Constructor for a none playable and first initiated cell.
     *
     * @param value the int value of the cell.
     * @param posX graphical position in X.
     * @param posY graphical position in Y.
     * @param numX location in X of the cell in the cellTab.
     * @param numY location in Y of the cell in the cellTab.
     */
    public CellFix(int value, int posX, int posY, int numX, int numY) {
        super(posX, posY, numX, numY);

        this.getStyleClass().add("cellFix");

        gCell2 = new Rectangle(46, 46, Color.BLACK);
        gCell2.setArcHeight(5);
        gCell2.setArcWidth(5);

        this.getChildren().add(gCell2);

        gCell = new Rectangle(42, 42, Color.WHITE);
        gCell.setArcHeight(5);
        gCell.setArcWidth(5);

        this.getChildren().add(gCell);

        gValue = new Text(Integer.toString(value));
        gValue.setFill(Color.BLACK);

        gValue.setFont(Font.font(23));
        gValue.setX(16);
        gValue.setY(30);
        this.getChildren().add(gValue);

        this.setTranslateX(posX + 1);
        this.setTranslateY(posY + 1);

        gCell2.setTranslateX(-2);
        gCell2.setTranslateY(-2);
    }

    /**
     *
     * @return the value of the cell.
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     * paint the border of the cell in red.
     */
    @Override
    public void redCell() {
        gCell2.setFill(Color.ORANGERED);
    }

    /**
     * paint the border of the cell in his normal color (black).
     */
    @Override
    public void normalCell() {
        gCell2.setFill(Color.BLACK);
    }

    /**
     * 
     * @param value the new value of the cell.
     */
    @Override
    public void setValue(int value) {
        gValue.setText(Integer.toString(value));
    }

}
