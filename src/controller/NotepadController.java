package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.NotepadModel;

import java.io.IOException;

public class NotepadController {

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem menuItemNewFile, menuItemOpen, menuItemSave, menuItemSaveAs;
    @FXML
    private TextArea textArea;

    private NotepadModel notepadModel;


    public void initialize() throws IOException {

        notepadModel = NotepadModel.getInstance(menuItemNewFile,menuItemOpen,menuItemSave,menuItemSaveAs,textArea);
        notepadModel.setNotepadController(this);

    }


    //----------------GETTERS-------------------



    public void handleMenuItemNewFile(ActionEvent event) {

    }

    public void handleMenuItemOpen(ActionEvent event) {

    }

    public void handleMenuItemSave(ActionEvent event) {

    }

    public void handleMenuItemSaveAs(ActionEvent event) {
        Stage window = (Stage) menuBar.getScene().getWindow();
        notepadModel.saveFile(window);
    }



}
