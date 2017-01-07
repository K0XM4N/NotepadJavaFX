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

    /**
     *
     * writeToFile Method - Writes text from TextArea (actually from FileModel's contentBeforeSave field) to a file.txt
     * where file - name of txt file
     *
     * **/
    private void writeToFile(String textContent, File savedFile) throws IOException {
        fileModel.setAllFields(savedFile.getAbsolutePath(),savedFile.getName(),textContent,true);

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


    public void saveContentAss(Stage stageWindow) throws IOException {

        String textContent = fileModel.getFileContentBeforeSave();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("All files (*.*)","*.*"));

        File savedFile = fileChooser.showSaveDialog(stageWindow);

        if (savedFile != null) {
            writeToFile(textContent, savedFile);
        }
    }


    public void saveContent(Stage stageWindow) throws IOException {

        fileModel.setFileContentBeforeSave(textArea.getText());
        fileModel.isSaved();

        if (fileModel.getFileContent().isEmpty() || fileModel.getPath().equals("Default Path")){
            saveContentAss(stageWindow);
        }
        else if (!fileModel.getFileContent().isEmpty() && !fileModel.getIsSaved()){
            File savedFile = new File(fileModel.getPath());
            writeToFile(fileModel.getFileContentBeforeSave(),savedFile);
        }

        fileModel.setFileContent(textArea.getText());

    }
}
