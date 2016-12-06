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
     * @param value
     * @param posX
     * @param posY
     * @param numX
     * @param numY
     */
    public CellFix(int value, int posX, int posY, int numX, int numY) {
        super(posX, posY, numX, numY);
        
        this.getStyleClass().add("cellFix");
        
        gCell2 = new Rectangle(46, 46, Color.BLACK);
        gCell2.setArcHeight(5);
        gCell2.setArcWidth(5);

        this.getChildren().add(gCell2);

        gCell = new Rectangle(44, 44, Color.WHITE);
        gCell.setArcHeight(5);
        gCell.setArcWidth(5);

        this.getChildren().add(gCell);

        gValue = new Text(Integer.toString(value));
        gValue.setFill(Color.BLACK);

        gValue.setFont(Font.font(25));
        gValue.setX(20);
        gValue.setY(30);
        this.getChildren().add(gValue);

        this.setTranslateX(posX - 350);
        this.setTranslateY(posY - 250);
        
        gCell2.setTranslateX(-1);
        gCell2.setTranslateY(-1);
    }

    /**
     *
     * @return the value of the cell.
     */
    public int getValue() {
        return value;
    }
    
    public void redCell(){
        gCell2.setFill(Color.RED);
    }

}
