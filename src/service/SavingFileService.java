package service;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.FileModel;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Krzysztof on 2017-01-05.
 */
public class SavingFileService {

    private TextArea textArea;
    private PrintWriter writer;
    private FileWriter fileWriter;
    private BufferedWriter buffWriter;

    private FileModel fileModel;

    //----------------SETTERS--------------------
    public void setFileModel(FileModel fileModel) {
        this.fileModel = fileModel;
    }



    public SavingFileService(TextArea textArea){
        this.textArea = textArea;
    }

    public void saveContentAss(Stage stageWindow) throws IOException {

        String textContent = textArea.getText();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("All files (*.*)","*.*"));

        File savedFile = fileChooser.showSaveDialog(stageWindow);

        if (savedFile != null) {
            fileWriter = new FileWriter(savedFile);
            writer = new PrintWriter(fileWriter);
            Scanner inputText = new Scanner(textContent);

            while (inputText.hasNextLine()) {
                writer.print(inputText.nextLine());
                if (inputText.hasNextLine()) {
                    writer.print("\r\n");
                }
            }

            writer.close();
            inputText.close();
        }
    }

    public void saveContent(){

    }
}
