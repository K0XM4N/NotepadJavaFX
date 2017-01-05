package model;

import controller.NotepadController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-05.
 */
public class NotepadModel {

    @FXML
    private MenuItem menuItemNewFile, menuItemOpen, menuItemSave, menuItemSaveAs;
    @FXML
    private TextArea textArea;

    NotepadController notepadController;

    private static NotepadModel notepadModel;



    public static NotepadModel getInstance(){

        if (notepadModel == null){
            notepadModel = new NotepadModel();
        }
        return notepadModel;
    }

    public void getNotepadController() throws IOException {

        FXMLLoader loader = FXMLLoader.load(getClass().getResource("/view/notepad.fxml"));
        notepadController = loader.getController();
    }

    public void setNotepadController(NotepadController notepadController) {
        this.notepadController = notepadController;
    }

    public void setAllNodes(MenuItem newFile, MenuItem open, MenuItem save, MenuItem saveAs, TextArea textArea){
        this.menuItemNewFile = newFile;
        this.menuItemOpen = open;
        this.menuItemSave = save;
        this.menuItemSaveAs = saveAs;
        this.textArea = textArea;
    }


}
