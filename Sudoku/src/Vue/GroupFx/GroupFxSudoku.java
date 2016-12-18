package Vue.GroupFx;

import Controller.Cell.Cell;
import Controller.Cell.CellFix;
import Controller.Cell.CellPlayable;
import Model.GridMatrix;
import Vue.Window;
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
     * Initiate the Sudoku and all his cells.
     *
     * @param posX the position on the scene in X.
     * @param posY the position on the scene in Y.
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
                rect.setStrokeWidth(6);
                rect.setStroke(Color.GOLD);
                rect.setFill(Color.TRANSPARENT);
                this.getChildren().add(rect);
            }
        }
        Cell temp;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                temp = new CellPlayable(x * 51, y * 51, x, y);

                cellTab[x][y] = temp;
                this.getChildren().add(cellTab[x][y]);
            }
        }

        this.setTranslateX(posX);
        this.setTranslateY(posY);

        cellTabBeforRedraw = cellTab;
    }

    /**
     * Used to redraw all the cells of the sudoku.
     *
     */
    public void redraw() {
        //First cleanning the groups from previous cells
        for (Cell[] cellTabTemp : cellTabBeforRedraw) {
            for (Cell cellTemp : cellTabTemp) {
                this.getChildren().remove(cellTemp);
            }
        }

        //Then adding the new cells.
        for (Cell[] cellTabTemp : cellTab) {
            for (Cell cellTemp : cellTabTemp) {
                this.getChildren().add(cellTemp);
            }
        }

        cellTabBeforRedraw = cellTab;
    }

    /**
     * Change the values of the matrix grid, in order to redraw.
     *
     * @param grid the new matrix of the grid.
     */
    public void setCellTableForRedraw(GridMatrix grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid.getGrid()[i][j].isLocked()) {
                    cellTab[i][j] = new CellFix(grid.getGrid()[i][j].getValue(),
                            cellTab[i][j].getPosX(), cellTab[i][j].getPosY(), cellTab[i][j].getNumX(), cellTab[i][j].getNumY());
                } else {
                    cellTab[i][j] = new CellPlayable(cellTab[i][j].getPosX(), cellTab[i][j].getPosY(), cellTab[i][j].getNumX(), cellTab[i][j].getNumY());
                }
            }
        }
    }

    /**
     * Used to redraw an empty sudoku.
     */
    public void emptySudoku() {

        for (Cell[] cellTabTemp : cellTabBeforRedraw) {
            for (Cell cellTemp : cellTabTemp) {
                this.getChildren().remove(cellTemp);
            }
        }
        cellTab = new Cell[9][9];
        
        Cell temp;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                temp = new CellPlayable(x * 51, y * 51, x, y);

                cellTab[x][y] = temp;
                this.getChildren().add(cellTab[x][y]);
            }
        }

    }

    /**
     *
     * @return the matrix of cell.
     */
    public static Cell[][] getCellTab() {
        return cellTab;
    }

    /**
     * Change the matrix cellTab.
     *
     * @param cellTab the new cellTab.
     */
    public static void setCellTab(Cell[][] cellTab) {
        GroupFxSudoku.cellTab = cellTab;
    }

}
