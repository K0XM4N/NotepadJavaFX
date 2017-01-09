package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
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
    private Stage notepadWindow;
    private Stage messageWindow;
    private FileModel fileModel;

    private OpeningFileService openingFileService;
    private CreatingNewFileService creatingNewFileService;


    public void initialize() throws IOException {


    }

    //--------------SETTERS------------
    public void setNotepadWindow(Stage window) throws IOException {
        this.notepadWindow = window;
    }

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
            openingFileService.openFile(notepadWindow);
        }
        else if (fileModel.getOperation().equals("create")){
            creatingNewFileService.createNewFile(notepadWindow);
        }

        messageWindow.close();
    }


    public void handleButtonYes(ActionEvent event) throws IOException {

        messageWindow = getMessageWindow(event);
        savingFileService.saveContent(notepadWindow);
        performFileOperations();

    }

    public void handleButtonNo(ActionEvent event) throws IOException {

        messageWindow = getMessageWindow(event);
        fileModel.setFileContent(fileModel.getFileContentBeforeSave());
        performFileOperations();

    }

    public void handleButtonCancel(ActionEvent event) {

        messageWindow = getMessageWindow(event);
        messageWindow.close();

    }



}
