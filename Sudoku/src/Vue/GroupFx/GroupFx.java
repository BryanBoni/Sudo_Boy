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
     * 
     * @param posX
     * @param posY
     * @param height
     * @param width 
     */
    public GroupFx(int posX, int posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
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
     * @param posX 
     */
    public void setPosX(int posX) {
        this.posX = posX;
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
     * @param posY 
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * 
     * @return 
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 
     * @return 
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    
    
}
