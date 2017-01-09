package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.FileModel;
import service.CreatingNewFileService;
import service.OpeningFileService;
import service.SavingFileService;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-08.
 */
public class MessageController {

    @FXML
    private Label labelMessage;

    private SavingFileService savingFileService;
    private Stage messageWindow;
    private FileModel fileModel;

    private OpeningFileService openingFileService;
    private CreatingNewFileService creatingNewFileService;


    //--------------SETTERS------------
    public void setSavingFileService(SavingFileService savingFileService) {
        this.savingFileService = savingFileService;
    }

    public void setLabelFileName(String name) {
        labelMessage.setText(labelMessage.getText().replaceAll("\\#FILE",name));
    }

    public void setFileModel(FileModel fileModel) {
        this.fileModel = fileModel;
    }

    public void setOpeningFileService(OpeningFileService openingFileService) {
        this.openingFileService = openingFileService;
    }

    public void setCreatingNewFileService(CreatingNewFileService creatingNewFileService) {
        this.creatingNewFileService = creatingNewFileService;
    }



    //--------------------------GETTERS----------------------------
    public Stage getMessageWindow(ActionEvent event){
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        return window;
    }


    private void performFileOperations() throws IOException {

        if (fileModel.getOperation().equals("open")){
            openingFileService.openFile(messageWindow);
        }
        else if (fileModel.getOperation().equals("create")){
            creatingNewFileService.createNewFile(messageWindow);
        }

        messageWindow.close();
    }


    public void handleButtonYes(ActionEvent event) throws IOException {

        messageWindow = getMessageWindow(event);
        savingFileService.saveContent(messageWindow);
        performFileOperations();

    }

    public void handleButtonNo(ActionEvent event) throws IOException {
        performFileOperations();
    }

    public void handleButtonCancel(ActionEvent event) {
        messageWindow = getMessageWindow(event);
        messageWindow.close();
    }



}
