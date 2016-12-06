package Vue.GroupFx;

import Controller.Cell.Cell;
import Controller.Cell.CellFix;
import Controller.Cell.CellPlayable;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class is use to initiate the sudoku.
 *
 * @author BryanBoni.
 */
public class GroupFxSudoku extends GroupFx {

    public static Cell cellTab[][];
    public static Cell cellTabBeforRedraw[][];

    /**
     * 
     * Initiate the Sudoku.
     * 
     * @param posX
     * @param posY
     * @param height unused in this function.
     * @param width unused in this function.
     */
    public GroupFxSudoku(int posX, int posY, int width, int height) {
        super(posX, posY, height, width);
        
        cellTab = new Cell[9][9];

        Rectangle rect;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rect = new Rectangle(151, 151);
                rect.setTranslateX(151 * i /*- 400*/);
                rect.setTranslateY(151 * j/* - 200*/);
                rect.setStrokeWidth(5);
                rect.setStroke(Color.GOLD);
                rect.setFill(Color.TRANSPARENT);
                this.getChildren().add(rect);
            }
        }
        Cell temp;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                /*if (x == 4 || y == 2) {
                    temp = new CellFix(1, x * 51, y * 51, x, y);
                } else {*/
                    temp = new CellPlayable(x * 51, y * 51, x, y);
                //}
                
                cellTab[x][y] = temp;
                this.getChildren().add(cellTab[x][y]);
            }
        }
        
        this.setTranslateX(posX);
        this.setTranslateY(posY);
        
        cellTabBeforRedraw = cellTab;
    }
    
    public void redraw(){
        //First cleanning the groups from previous cells
        for(Cell[] cellTabTemp : cellTabBeforRedraw){
            for(Cell cellTemp : cellTabTemp){
                this.getChildren().remove(cellTemp);
            }
        }
        
        //Then adding the new cells.
        for(Cell[] cellTabTemp : cellTab){
            for(Cell cellTemp : cellTabTemp){
                this.getChildren().add(cellTemp);
            }
        }
        
        cellTabBeforRedraw = cellTab;
    }
}
