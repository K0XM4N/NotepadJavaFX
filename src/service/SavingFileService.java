package service;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

/**
 * Created by Krzysztof on 2017-01-05.
 */
public class SavingFileService {

    private TextArea textArea;
    private PrintWriter writer;
    private FileWriter fileWriter;
    private BufferedWriter buffWriter;

    public SavingFileService(TextArea textArea){
        this.textArea = textArea;
    }

    public void saveContentAss(Stage stageWindow){

        FileChooser fileChooser = new FileChooser();
        File savedFile = fileChooser.showSaveDialog(stageWindow);
        
        try {

            writer = new PrintWriter(savedFile);
            writer.println(textArea.getText());
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
