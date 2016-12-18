package Vue.GroupFx;

import javafx.scene.Parent;

/**
 * Used to define a new group in the window
 * 
 * @author BryanBoni.
 */
public abstract class GroupFx extends Parent{
    
    private int posX;
    private int posY;
    private int height;
    private int width;

    /**
     * General constructor for a group of components.
     * 
     * @param posX the position on the scene in X.
     * @param posY the position on the scene in Y.
     * @param width the width of the panel.
     * @param height the height of the panel.
     */
    public GroupFx(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
    }

    /**
     * 
     * @return the position on the scene in X.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * 
     * @param posX the new postion on the scene in X
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * 
     * @return the position on the scene in Y.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * 
     * @param posY the new position on the scene in Y.
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * 
     * @return the height of the panel.
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height the new height value of the panel.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 
     * @return the width of the panel.
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @param width the new width value of the panel.
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    
    
}
