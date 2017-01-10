package service;

import controller.MessageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.FileModel;
import service.interfaces.FileOperation;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class NotSavedService {

    private FileModel fileModel;
    private MessageController messageController;

    private FileOperation saveFileService;

    private Stage notepadWindow;

    public NotSavedService(FileModel fileModel, FileOperation saveFileService){
        this.fileModel = fileModel;
        this.saveFileService = saveFileService;
    }


    public void setNotepadWindow(Stage window){
        this.notepadWindow = window;
    }

    public void loadMessageWindow(FileOperation fileOperation) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/message.fxml"));
        Parent root = loader.load();

        setValuesToMsgController(loader, fileOperation);

        Scene scene = new Scene(root);
        Stage window = new Stage();

        window.setScene(scene);
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();

    }

    private void setValuesToMsgController(FXMLLoader loader, FileOperation fileOperation) throws IOException {

        messageController = loader.getController();
        messageController.setLabelFileName(fileModel.getName());
        messageController.setSavingFileService(saveFileService);
        messageController.setFileModel(fileModel);
        messageController.setNotepadWindow(notepadWindow);
        messageController.setFileOperation(fileOperation);

    }

}
