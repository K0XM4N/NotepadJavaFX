package service;

import controller.MessageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class NotSavedService {


    public void loadMessageWindow() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/message.fxml"));

        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}
