package serviceapp.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import serviceapp.extra.Warnings;

/**
 *
 * @author joao
 */
public class StartController implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private Text texto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplashScreen().start();
    }    
    
    class SplashScreen extends Thread {
        @Override
        public void run(){
            try {
                Thread.sleep(5000);
                Platform.runLater(() -> {
                    try {
                        Parent parente = FXMLLoader.load(getClass().getResource("/serviceapp/view/Login.fxml"));
                        Stage stage = new Stage(StageStyle.UNDECORATED);
                        stage.setScene(new Scene(parente));
                        stage.show();
                        rootPane.getScene().getWindow().hide();
                    } catch (IOException ex) { Warnings.error(ex.getMessage()); }
                }); 
            } catch (InterruptedException e) { Warnings.error(e.getMessage()); }
        }
    }
}
