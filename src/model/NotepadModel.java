package model;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import service.*;
import service.interfaces.FileOperation;
import service.SaveFileAsService;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-05.
 */
public class NotepadModel {

    @FXML
    private MenuItem menuItemNewFile, menuItemOpen, menuItemSave, menuItemSaveAs;
    @FXML
    private TextArea textArea;

    private FileModel fileModel;

    private NotSavedService notSavedService;

    private FileOperation saveFileAsService;
    private FileOperation saveFileService;
    private FileOperation openFileService;
    private FileOperation newFileService;

    private static NotepadModel notepadModel;


    //------------CONSTRUCTOR N GETTIN INSTANCE--------------------

    private NotepadModel(MenuItem newFile, MenuItem open, MenuItem save, MenuItem saveAs, TextArea textArea){

        this.menuItemNewFile = newFile;
        this.menuItemOpen = open;
        this.menuItemSave = save;
        this.menuItemSaveAs = saveAs;
        this.textArea = textArea;


        fileModel = FileModel.getInstace();

        saveFileAsService = new SaveFileAsService(textArea,fileModel);
        saveFileService = new SaveFileService(textArea,fileModel,saveFileAsService);

        notSavedService = new NotSavedService(fileModel, saveFileService);

        openFileService = new OpenFileService(textArea,fileModel,notSavedService);
        newFileService = new NewFileService(textArea,fileModel,notSavedService);

    }

    public static NotepadModel getInstance(MenuItem newFile, MenuItem open, MenuItem save, MenuItem saveAs, TextArea textArea){

        if (notepadModel == null){
            notepadModel = new NotepadModel(newFile,open,save,saveAs,textArea);
        }
        return notepadModel;

    }



    //--------------------FUNCTIONALITY METHODS-----------------------

    public void saveFileAs(Stage notepadWindow) throws IOException {
        saveFileAsService.performOperation(notepadWindow);
    }

    public void saveFile(Stage notepadWindow) throws IOException {
        saveFileService.performOperation(notepadWindow);
    }

    public void openFile(Stage notepadWindow) throws IOException {
        openFileService.performOperation(notepadWindow);
    }

    public void newFile(Stage notepadWindow) throws IOException {
        newFileService.performOperation(notepadWindow);
    }

}
