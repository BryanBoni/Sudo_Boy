package Vue.GroupFx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * This class is use to display player statistics of the current game.
 * 
 * @author BryanBoni.
 */
public class GroupFxStatistics extends GroupFx{
    
    private Text mode;
    private Text numbersRemaining;
    private Text bestTime;
    
    public GroupFxStatistics(int posX, int posY, int width, int height) {
        super(posX, posY, height, width);
        
        Rectangle statsPanel = new Rectangle(width, height);
        statsPanel.setStrokeWidth(2);
        statsPanel.setStroke(Color.GOLD);
        statsPanel.setFill(Color.TRANSPARENT);        
        this.getChildren().add(statsPanel);
        
        
        
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
    
}
