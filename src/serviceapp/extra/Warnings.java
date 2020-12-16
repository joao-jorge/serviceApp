package serviceapp.extra;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author joao
 */
public class Warnings {
    
    public static void error(String msg){
        Alert waring = new Alert(Alert.AlertType.ERROR);
        waring.setTitle("Mensagem de erro");
        waring.setHeaderText(null);
        waring.setContentText(msg);
        waring.showAndWait();
    }
    
    public static void warning(String msg){
        Alert waring = new Alert(Alert.AlertType.INFORMATION);
        waring.setTitle("Mensagem de informação");
        waring.setHeaderText(null);
        waring.setContentText(msg);
        waring.showAndWait();
    }  
    
    public static boolean confirmDialog(String warnig){
        Alert waning = new Alert(Alert.AlertType.CONFIRMATION);
        waning.setTitle("Diálogo de Confirmação");
        waning.setHeaderText("Atenção");
        waning.setContentText(warnig);
        Optional<ButtonType> result = waning.showAndWait();
        if (result.get() == ButtonType.OK)
            return true;
        else 
            return false;
    }
}
