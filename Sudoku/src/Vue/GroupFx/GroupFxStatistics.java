package Vue.GroupFx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * This class is use to display player statistics of the current game.
 *
 * @author BryanBoni.
 */
public class GroupFxStatistics extends GroupFx {

    private Text mod;
    private Text numbersRemaining;
    private Text bestTime;

    /**
     * Initiate all the component for the player statistics
     * 
     * @param posX
     * @param posY
     * @param width
     * @param height 
     */
    public GroupFxStatistics(int posX, int posY, int width, int height) {
        super(posX, posY, height, width);

        Rectangle statsPanel = new Rectangle(width, height);
        statsPanel.setStrokeWidth(2);
        statsPanel.setStroke(Color.GOLD);
        statsPanel.setFill(Color.TRANSPARENT);
        this.getChildren().add(statsPanel);

        Text modLabel = new Text("Mode de Jeu : ");
        modLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        modLabel.setFill(Color.WHITE);
        modLabel.setTranslateX(10);
        modLabel.setTranslateY(24);
        this.getChildren().add(modLabel);
        
        mod = new Text(" N/A");
        mod.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        mod.setFill(Color.WHITE);
        mod.setTranslateX(width*0.75);
        mod.setTranslateY(24);
        this.getChildren().add(mod);
        
        Text nbRLabel = new Text("Case vide restantes : ");
        nbRLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        nbRLabel.setFill(Color.WHITE);
        nbRLabel.setTranslateX(10);
        nbRLabel.setTranslateY(96);
        this.getChildren().add(nbRLabel);
        
        numbersRemaining = new Text(" N/A");
        numbersRemaining.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        numbersRemaining.setFill(Color.WHITE);
        numbersRemaining.setTranslateX(width*0.75);
        numbersRemaining.setTranslateY(96);
        this.getChildren().add(numbersRemaining);
        
        Text bestLabel = new Text("Meilleur score : ");
        bestLabel.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        bestLabel.setFill(Color.WHITE);
        bestLabel.setTranslateX(10);
        bestLabel.setTranslateY(168);
        this.getChildren().add(bestLabel);
        
        bestTime = new Text("  -- : -- : --");
        bestTime.setFont(Font.font("Courier New", FontWeight.BOLD, 24));
        bestTime.setFill(Color.WHITE);
        bestTime.setTranslateX(width*0.5);
        bestTime.setTranslateY(168);
        this.getChildren().add(bestTime);
        
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    /**
     * 
     * @return 
     */
    public Text getMod() {
        return mod;
    }

    /**
     * 
     * @param mod 
     */
    public void setMod(String mod) {
        this.mod.setText(" " + mod);
    }

    /**
     * 
     * @return 
     */
    public Text getNumbersRemaining() {
        return numbersRemaining;
    }

    /**
     * 
     * @param numbersRemaining 
     */
    public void setNumbersRemaining(int numbersRemaining) {
        this.numbersRemaining.setText(" " + Integer.toString(numbersRemaining));
    }

    /**
     * 
     * @return 
     */
    public Text getBestTime() {
        return bestTime;
    }

    /**
     * 
     * @param h : Hours
     * @param m : Minutes
     * @param s : Seconds
     */
    public void setBestTime(int h, int m, int s) {
        this.bestTime.setText("  " + Integer.toString(h) + " : " + Integer.toString(m) + " : " + Integer.toString(s));
    }
    
    

}
