package model;

import controller.NotepadController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import service.SavingFileService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Krzysztof on 2017-01-05.
 */
public class NotepadModel {

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem menuItemNewFile, menuItemOpen, menuItemSave, menuItemSaveAs;
    @FXML
    private TextArea textArea;

    private FileModel fileModel;

    NotepadController notepadController;
    SavingFileService savingFileService;

    private static NotepadModel notepadModel;

    private NotepadModel(MenuItem newFile, MenuItem open, MenuItem save, MenuItem saveAs, TextArea textArea){

        this.menuItemNewFile = newFile;
        this.menuItemOpen = open;
        this.menuItemSave = save;
        this.menuItemSaveAs = saveAs;
        this.textArea = textArea;

        fileModel = FileModel.getInstace();
        savingFileService = new SavingFileService(textArea);
        savingFileService.setFileModel(fileModel);

    }


    public static NotepadModel getInstance(MenuItem newFile, MenuItem open, MenuItem save, MenuItem saveAs, TextArea textArea){

        if (notepadModel == null){
            notepadModel = new NotepadModel(newFile,open,save,saveAs,textArea);
        }
        return notepadModel;
    }


    public void setNotepadController(NotepadController notepadController) {
        this.notepadController = notepadController;
    }


    public void saveFileAs(Stage stage) throws IOException {
        savingFileService.saveContentAss(stage);
    }

    public void saveFile(Stage stage) throws IOException {
        savingFileService.saveContent(stage);
    }

}
