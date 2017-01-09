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

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class NotSavedService {

    private FileModel fileModel;
    private MessageController messageController;
    private SavingFileService savingFileService;
    private OpeningFileService openingFileService;
    private CreatingNewFileService creatingNewFileService;

    public NotSavedService(FileModel fileModel, SavingFileService savingFileService){
        this.fileModel = fileModel;
        this.savingFileService = savingFileService;
    }

    public void setCreatingNewFileService(CreatingNewFileService creatingNewFileService) {
        this.creatingNewFileService = creatingNewFileService;
    }

    public void setOpeningFileService(OpeningFileService openingFileService) {
        this.openingFileService = openingFileService;
    }

    public void loadMessageWindow() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/message.fxml"));
        Parent root = loader.load();

        setValuesToMsgController(loader);

        Scene scene = new Scene(root);
        Stage window = new Stage();

        window.setScene(scene);
        window.setResizable(false);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();

    }

    private void setValuesToMsgController(FXMLLoader loader) {
        messageController = loader.getController();
        messageController.setLabelFileName(fileModel.getName());
        messageController.setSavingFileService(savingFileService);
        messageController.setFileModel(fileModel);
        messageController.setCreatingNewFileService(creatingNewFileService);
        messageController.setOpeningFileService(openingFileService);
    }

}
