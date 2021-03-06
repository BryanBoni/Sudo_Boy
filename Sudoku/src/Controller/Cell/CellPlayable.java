package Controller.Cell;

import Vue.Window;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

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
    private boolean rollback;
    private final TextField gValue;
    private final Rectangle gCell;

    /**
     * Constructor for an empty and playable cell.
     *
     * @param posX graphical position in X.
     * @param posY graphical position in Y.
     * @param numX location in X of the cell in the cellTab.
     * @param numY location in Y of the cell in the cellTab.
     */
    public CellPlayable(int posX, int posY, int numX, int numY) {
        super(posX, posY, numX, numY);
        rollback = false;

        gCell = new Rectangle(46, 46, Color.BLACK);
        gCell.setArcHeight(5);
        gCell.setArcWidth(5);
        this.getChildren().add(gCell);

        gValue = new TextField();
        gValue.setMaxSize(42, 42);
        gValue.setMinSize(42, 42);
        gValue.setAlignment(Pos.CENTER);
        gValue.setFont(Font.font(23));
        gValue.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (!rollback) {
                    if (!newValue.equals("") && !newValue.equals("1") && !newValue.equals("2") && !newValue.equals("3") && !newValue.equals("4")
                            && !newValue.equals("5") && !newValue.equals("6") && !newValue.equals("7") && !newValue.equals("8") && !newValue.equals("9")) {
                        rollback = true;
                        gValue.setText(oldValue);
                    } else {
                        if (!newValue.equals("")) {
                            try {
                                value = Integer.parseInt(newValue);
                                if (!Window.getgControls().getGame().modifyValueOfCell(numX, numY, value)) {
                                    rollback = true;
                                    gValue.setText(oldValue);
                                    if (oldValue.equals("")) {
                                        value = 0;
                                    } else {
                                        value = Integer.parseInt(oldValue);
                                    }
                                }
                            } catch (Exception e) {

                            }
                        } else {
                            value = 0;
                            Window.getgControls().getGame().modifyValueOfCell(numX, numY, null);
                        }
                    }
                } else {
                    rollback = false;
                }
            }

        });
        this.getChildren().add(gValue);

        this.setTranslateX(posX + 1);
        this.setTranslateY(posY + 1);

        gCell.setTranslateX(-2);
        gCell.setTranslateY(-2);
    }

    /**
     * Used to set the value of a playable cell.
     *
     * @param value the new value.
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
     * Return the value of gValue.
     *
     * @return the value of the cell.
     */
    @Override
    public int getValue() {
        return Integer.parseInt(gValue.getText());
    }

    /**
     * paint the border of the cell in red.
     */
    @Override
    public void redCell() {
        gCell.setFill(Color.ORANGERED);
    }

    
    /**
     * 
     * @param value the new value of the cell.
     */
    @Override
    public void setValue(int value) {
        gValue.setText(Integer.toString(value));
    }

    /**
     * paint the border of the cell in his normal color (black).
     */
    @Override
    public void normalCell() {
        gCell.setFill(Color.BLACK);
    }
}
