package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.NotepadModel;

import java.io.FileNotFoundException;
import java.io.IOException;

public class NotepadController {

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem menuItemNewFile, menuItemOpen, menuItemSave, menuItemSaveAs;
    @FXML
    private TextArea textArea;

    private NotepadModel notepadModel;
    private Stage notepadWindow;


    public void initialize() throws IOException {

        notepadModel = NotepadModel.getInstance(menuItemNewFile,menuItemOpen,menuItemSave,menuItemSaveAs,textArea);

    }


    //----------------------GETTERS---------------------------
    public Stage getNotepadControllerWindow(){
        if (menuBar != null){
            notepadWindow = (Stage) menuBar.getScene().getWindow();
        }
        else{
            System.out.println("NULL");
        }
        return notepadWindow;
    }

    //----------------------EVENT HANDLERS---------------------

    public void handleMenuItemNewFile(ActionEvent event) throws IOException {
        Stage window = (Stage) menuBar.getScene().getWindow();
        notepadModel.newFile(window);
    }

    public void handleMenuItemOpen(ActionEvent event) throws IOException {
        Stage window = (Stage) menuBar.getScene().getWindow();
        notepadModel.openFile(window);
    }

    public void handleMenuItemSave(ActionEvent event) throws IOException {
        Stage window = (Stage) menuBar.getScene().getWindow();
        notepadModel.saveFile(window);
    }

    public void handleMenuItemSaveAs(ActionEvent event) throws IOException {
        Stage window = (Stage) menuBar.getScene().getWindow();
        notepadModel.saveFileAs(window);
    }


    public void test(){
        System.out.println("test");
    }
}
