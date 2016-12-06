/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Optional;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

/**
 *
 * @author Robin
 */
public class ClosingEvent implements EventHandler<WindowEvent>
{
    private Game game;

    public ClosingEvent(Game game)
    {
        this.game = game;
    }
    
    
    
    @Override
    public void handle(WindowEvent event)
    {
        if(event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST)
        {
            Alert message = new Alert(Alert.AlertType.CONFIRMATION,"Voulez vous sauvegarder la partie avant de quitter?",ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            message.setTitle("Attention");
            message.setHeaderText(null);
            Optional<ButtonType> answer = message.showAndWait();
            if(answer.get() == ButtonType.YES)
            {
                game.save();
            }
            if(answer.get() == ButtonType.CANCEL)
            {
                event.consume();
            }
                
        }
    }
    
}
