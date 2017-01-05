package service;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;

/**
 * Created by Krzysztof on 2017-01-05.
 */
public class SavingFileService {

    TextArea textArea;

    public SavingFileService(TextArea textArea){
        this.textArea = textArea;
    }

    public void saveContentAss(Stage stageWindow){

        FileChooser fileChooser = new FileChooser();
        File savedFile = fileChooser.showSaveDialog(stageWindow);

    }

}
