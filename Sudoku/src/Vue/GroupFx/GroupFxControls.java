package Vue.GroupFx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author BryanBoni
 */
public class GroupFxControls extends GroupFx{
    
    public GroupFxControls(int posX, int posY, int width, int height) {
        super(posX, posY, height, width);
        
        Rectangle controlsPanel = new Rectangle(width, height);
        
        //controlsPanel.setTranslateX(0);
        //controlsPanel.setTranslateY(0);
        controlsPanel.setStrokeWidth(2);
        controlsPanel.setStroke(Color.GOLD);
        controlsPanel.setFill(Color.TRANSPARENT);
        
        
        this.getChildren().add(controlsPanel);
        
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }
    
}
