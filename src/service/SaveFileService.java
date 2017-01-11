package service;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.FileModel;
import service.interfaces.FileOperation;

import java.io.File;
import java.io.IOException;

/**
 * Created by Krzysztof on 2017-01-10.
 */
public class SaveFileService  extends SaveService implements FileOperation{

    private FileOperation saveFileAsService;

    public SaveFileService(TextArea textArea, FileModel fileModel, FileOperation saveFileAsService) {
        super(textArea, fileModel);
        this.saveFileAsService = saveFileAsService;
    }


    /**
     * Method that provide save actual created file.
     * @param notepadWindow Stage object that is needed by FileChooser to open dialog pop up (in case
     *                    when file was not created).
     * **/
    @Override
    public void performOperation(Stage notepadWindow) throws IOException {

        fileModel.setFileContentBeforeSave(textArea.getText());
        fileModel.checkSaveStatus();

        if (fileModel.getFileContent().isEmpty() || fileModel.getPath().equals("Default Path")){
            saveFileAsService.performOperation(notepadWindow);
        }
        else if (!fileModel.getFileContent().isEmpty() && !fileModel.getIsSaved()){
            File savedFile = new File(fileModel.getPath());
            writeToFile(fileModel.getFileContentBeforeSave(),savedFile);
        }

        fileModel.setFileContent(textArea.getText());

    }
}
