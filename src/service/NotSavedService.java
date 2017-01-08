package service;

import controller.MessageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.FileModel;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class NotSavedService {

    private FileModel fileModel;
    private MessageController messageController;

    public NotSavedService(FileModel fileModel){
        this.fileModel = fileModel;
    }

    public void loadMessageWindow() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/message.fxml"));
        Parent root = loader.load();

        messageController = loader.getController();
        messageController.setLabelFileName(fileModel.getName());

        Scene scene = new Scene(root);
        Stage window = new Stage();

        window.setScene(scene);
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();

    }
}
