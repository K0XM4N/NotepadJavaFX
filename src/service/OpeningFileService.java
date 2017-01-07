package service;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.FileModel;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class OpeningFileService {
    private TextArea textArea;
    private FileModel fileModel;
    private PrintWriter printWriter;


    public OpeningFileService(TextArea textArea, FileModel fileModel){
        this.textArea = textArea;
        this.fileModel = fileModel;
    }

    private void readFromFile(Stage window) throws FileNotFoundException {

        FileChooser fileChooser = new FileChooser();
        File openedFile = fileChooser.showOpenDialog(window);

        if (openedFile != null){

            Scanner reader = new Scanner(openedFile);
            StringBuilder textFromFile = new StringBuilder();

            while (reader.hasNextLine()){
                textFromFile.append(reader.nextLine());
                if (reader.hasNextLine()) {
                    textFromFile.append("\n");
                }
            }

            fileModel.setAllFields(openedFile.getAbsolutePath(),openedFile.getName(),textFromFile.toString(),true);
            fileModel.setFileContent(textFromFile.toString());
            textArea.setText(textFromFile.toString());
        }

    }

    public void openFile(Stage window) throws FileNotFoundException {

        fileModel.setFileContentBeforeSave(textArea.getText());
        fileModel.isSaved();

        if (fileModel.getFileContent().isEmpty() || fileModel.getIsSaved()){
            System.out.println("SAVED -> OPEN NEW FILE");
            readFromFile(window);
        }
        else{
            System.out.println("NOT SAVED -> ASK USER TO SAVE OR NOT");
        }

    }



}
