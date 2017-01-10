package service;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.FileModel;
import service.interfaces.FileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public class OpenFileService implements FileOperation {

    private TextArea textArea;
    private FileModel fileModel;
    private NotSavedService notSavedService;

    public OpenFileService(TextArea textArea, FileModel fileModel, NotSavedService notSavedService){
        this.textArea = textArea;
        this.fileModel = fileModel;
        this.notSavedService = notSavedService;
    }


    /**
     * Method that allows to open file, also provides operations that will handle if text is saved or not.
     * @param notepadWindow Stage object that is needed by FileChooser to open dialog pop up.
     * @throws FileNotFoundException
     */
    @Override
    public void performOperation(Stage notepadWindow) throws IOException {

        fileModel.setFileContentBeforeSave(textArea.getText());
        fileModel.isSaved();
        fileModel.setFileOperation("open");

        if (fileModel.getFileContentBeforeSave().isEmpty() || fileModel.getIsSaved()){
            System.out.println("SAVED -> OPEN NEW FILE");
            readFromFile(notepadWindow);
        }
        else{
            System.out.println("NOT SAVED -> ASK USER TO SAVE OR NOT");
            notSavedService.setNotepadWindow(notepadWindow);
            notSavedService.loadMessageWindow(this);
        }

    }


    /**
     * Method that allows to read text from file, store it and write to the TextArea
     * and FileModel object's field: FileContent.
     * @param notepadWindow Stage object that is needed by FileChooser to open dialog pop up.
     * @throws FileNotFoundException
     */
    private void readFromFile(Stage notepadWindow) throws FileNotFoundException {

        FileChooser fileChooser = new FileChooser();
        File openedFile = fileChooser.showOpenDialog(notepadWindow);

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
            notepadWindow.setTitle(fileModel.getName());
        }

    }
}
